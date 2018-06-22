package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by codebugcn on 17-1-22.
 */
public class ZookeeperTest {
    public static void main(String args[]) throws IOException, InterruptedException, KeeperException {
        //createConnection();
        //synCreateNode();
        //asynCreateNode();
        //deleteNode();
        //getChildrenNode();
        updateNode();
        Thread.sleep(100000);
    }

    public static void createConnection() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2188", 5000, new ZookeeperWatch(countDownLatch));
        countDownLatch.await();
    }

    public static void synCreateNode() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2188", 5000, new ZookeeperWatch());
        System.out.println(zookeeper.create("/node", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
        System.out.println(zookeeper.create("/node/node2", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL));
    }

    public static void asynCreateNode() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2188", 5000, new ZookeeperWatch());
        zookeeper.create("/node","hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,new IStringCallback(),"I am Context");
    }

    public static void deleteNode() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2188", 5000, new ZookeeperWatch());
        zookeeper.create("/node","hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,new IStringCallback(),"I am Context");
        zookeeper.delete("/node",-1);
    }

    public static void getChildrenNode() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2188", 5000, new ZookeeperWatch());
        System.out.println(zookeeper.getChildren("/node",new ZookeeperWatch()));
    }

    public static void updateNode() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2188", 5000, new ZookeeperWatch());
        String path = "/node";
        Stat stat = zookeeper.setData(path,"888".getBytes(),-1);
        System.out.println("Czxid " + stat.getCzxid() + " Mzxid " + stat.getMzxid() + " stat.getCzxid()" + " Version " + stat.getVersion());
        zookeeper.setData(path,"666".getBytes(),stat.getVersion());
        zookeeper.setData(path,"555".getBytes(),stat.getVersion());
    }

    static class IStringCallback implements AsyncCallback.StringCallback{
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            System.out.println(i + " " + s +  " "  + o + " "  + s1);
        }
    }
}
