package zookeeper;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * Created by codebugcn on 17-1-18.
 */
public class ZkClientTest {

    public static void main(String args[]) throws InterruptedException {
        ZkClient zkClient = new ZkClient("127.0.0.1:2188",5000);
        //createNode(zkClient);
        listenerTest(zkClient);
    }
    public static void createNode(ZkClient zkClient){
        String path = "/zk-book/c1";
        zkClient.createPersistent(path,true);

    }

    public static void listenerTest(ZkClient zkClient) throws InterruptedException {
        int i = 0;
        String path = "/zk-book";
        zkClient.subscribeChildChanges(path,(parentPath,children)-> {
            System.out.println(parentPath + "children: " + children);
        });
        zkClient.createPersistent(path+"/c1",true);
        zkClient.createPersistent(path+"/c2",true);
        zkClient.delete(path+"/c1");
        zkClient.delete(path+"/c2");
        zkClient.delete(path);

    }
}
