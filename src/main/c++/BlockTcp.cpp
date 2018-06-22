// BlockTcp.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "windows.h"

#include <stdio.h>

#pragma comment(lib, "ws2_32.lib") 
static const int PORT = 9999;
static const int BUFFER_LENGTH = 128;

bool InitWSA();

int main()
{
	if (!InitWSA())
	{
		return -1;
	}

	SOCKET sockSrv = socket(AF_INET, SOCK_STREAM, 0);

	SOCKADDR_IN addrSrv;
	addrSrv.sin_addr.S_un.S_addr = htonl(INADDR_ANY);
	addrSrv.sin_family = AF_INET;
	addrSrv.sin_port = htons(PORT);

	bind(sockSrv, (SOCKADDR *)&addrSrv, sizeof(SOCKADDR));

	listen(sockSrv, 1);

	SOCKADDR_IN addrClient;
	int len = sizeof(addrClient);

	while (true)
	{
		SOCKET sockConn = accept(sockSrv, (SOCKADDR *)&addrClient, &len);

		char sendBuf[BUFFER_LENGTH];
		sprintf(sendBuf, "Hello, %s, This is Server.", inet_ntoa(addrClient.sin_addr));

		send(sockConn, sendBuf, strlen(sendBuf) + 1, 0);

		char recvBuf[BUFFER_LENGTH];
		recv(sockConn, recvBuf, BUFFER_LENGTH, 0);
		printf("%s", recvBuf);
		closesocket(sockConn);
	}

	closesocket(sockSrv);
	WSACleanup();

	return 0;
}

bool InitWSA()
{
	WORD wVersionRequested;
	WSADATA wsaData;
	int err;

	wVersionRequested = MAKEWORD(1, 1);
	err = WSAStartup(wVersionRequested, &wsaData);
	if (err != 0)
	{
		return false;
	}
	if (LOBYTE(wsaData.wVersion) != 1 ||
		HIBYTE(wsaData.wVersion) != 1)
	{
		WSACleanup();
		return false;
	}
	return true;
}
