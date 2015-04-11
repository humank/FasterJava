package test.ch2.singleton;

import ch2.singleton.LazySingleton;
import ch2.singleton.Singleton;
import org.junit.Test;

/**
 * Created by yikai on 2015/4/11.
 */
public class LazySingletonTest {

    long processLazyTime = 0;
    long processNoSyncTime = 0;

    @Test
    public void lazyInitDurationTime() {
        Thread testTarget = new Thread(new Runnable() {
            @Override
            public void run() {
                long begin = System.currentTimeMillis();
                for (int i = 0; i < 1000000; i++) {
                    LazySingleton.getInstance();
                }
                long end = System.currentTimeMillis();
                processLazyTime = end - begin;

                System.out.println("processLazy -->" + processLazyTime);
            }
        });
        testTarget.start();

    }

    @Test
    public void normalNoSyncDurationTime() {
        Thread testTarget = new Thread(new Runnable() {
            @Override
            public void run() {
                long begin = System.currentTimeMillis();
                for (int i = 0; i < 1000000; i++) {
                    Singleton.getInstance();
                }
                long end = System.currentTimeMillis();
                processNoSyncTime = end - begin;

                System.out.println(String.format("normal process : %d", processNoSyncTime));
            }
        });
        testTarget.start();
    }

//    @Test
//    public void normalInitNoSyncIsFaster() {
//
//        System.out.println("lazy --> " + processLazyTime);
//        System.out.println("normal --> " + processNoSyncTime);
//
//        assertTrue((processLazyTime - processNoSyncTime) > 0);
//    }
}
