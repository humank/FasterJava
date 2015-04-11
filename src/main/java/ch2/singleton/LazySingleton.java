package ch2.singleton;

/**
 * Created by yikai on 2015/4/11.
 */
public class LazySingleton {

    private LazySingleton() {
        System.out.println("yoyo , this is lazy singleton ! ");
    }

    private static LazySingleton instance = null; // 先不急著初始化啊:D

    /**
     * 這裏的作法基本上就如同一般網站上看到的做法，強調晚期綁定, <br/>
     * 透過synchronized 控制面對多執行緒操作得時候的併發問題. <br/>
     * 但他相對的會比較耗時!! <br/>
     * 那還有辦法嗎? 請看這個 - @see ch2.singleton.StaticSingleton
     *
     *
     @return
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
