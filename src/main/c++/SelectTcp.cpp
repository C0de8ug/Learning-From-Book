// ConsoleApplication1.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "windows.h"

#define PORT       5150 
#define MSGSIZE     1024 
#pragma comment(lib, "ws2_32.lib") 
int     g_iTotalConn = 0; 
SOCKET g_CliSocketArr[FD_SETSIZE];

DWORD WINAPI WorkerThread(LPVOID lpParam)
{
	int             i;
	fd_set         fdread;
	int             ret;
	struct timeval tv = { 1, 0 };
	char           szMessage[MSGSIZE];
	while (TRUE)
	{
		FD_ZERO(&fdread);
		for (i = 0; i < g_iTotalConn; i++)
		{
			FD_SET(g_CliSocketArr[i], &fdread);
		}                     // We only care read event 
		ret = select(0, &fdread, NULL, NULL, NULL);
		if (ret == 0)
		{       // Time expired 
			continue;
		}
		for (i = 0; i < g_iTotalConn; i++)
		{
			if (FD_ISSET(g_CliSocketArr[i], &fdread))
			{   
				ret = recv(g_CliSocketArr[i], szMessage, MSGSIZE, 0);
				if (ret == 0 || (ret == SOCKET_ERROR && WSAGetLastError() == WSAECONNRESET))
				{
					// Client socket closed           
					printf("Client socket %d closed.\n", g_CliSocketArr);
					closesocket(g_CliSocketArr[i]);
					if (i < g_iTotalConn - 1)
					{
						g_CliSocketArr[i--] = g_CliSocketArr[--g_iTotalConn];
					}
				}
				else
				{
					// We received a message from client 
					szMessage[ret] = '\0';
					send(g_CliSocketArr[i], szMessage, strlen(szMessage), 0);
				}
			} //if 
		}//for 
	}//while     
	return 0;
}

int main()
{
	DWORD dwThreadId;
	WSADATA wsaData;
	WSAStartup(MAKEWORD(2, 2), &wsaData);

	SOCKET m_socket, m_client;
	m_socket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	SOCKADDR_IN local, client;

	local.sin_addr.S_un.S_addr = htonl(INADDR_ANY);
	local.sin_family = AF_INET;
	local.sin_port = htons(9999);

	bind(m_socket, (LPSOCKADDR)&local, sizeof(SOCKADDR_IN));
	listen(m_socket, 3);
	// Create worker thread   
	CreateThread(NULL, 0, WorkerThread, NULL, 0, &dwThreadId);
	while (TRUE)
	{
		// Accept a connection   
		int size = sizeof(local);
		m_client = accept(m_socket, (sockaddr*)&client, &size);
		printf("Accepted client:%s:%d/n", inet_ntoa(client.sin_addr), ntohs(client.sin_port));
		// Add socket to g_CliSocketArr   
		g_CliSocketArr[g_iTotalConn++] = m_client;
	}
}