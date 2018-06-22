package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * Created by codebugcn on 17-1-22.
 */
public class ZookeeperWatch implements Watcher{
    CountDownLatch countDownLatch;

    ZookeeperWatch(){

    }

    ZookeeperWatch(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
        System.out.println(watchedEvent.getState());
        System.out.println(watchedEvent.getPath());
        System.out.println(watchedEvent.getType());
        System.out.println(watchedEvent.getWrapper());
        if (countDownLatch != null)
        countDownLatch.countDown();
    }
}
