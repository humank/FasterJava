package ch2.singleton;

/**
 * Created by yikai on 2015/4/11.
 */
public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("yo ... static singleton is constructed ..");
    }


    /**
     * 在這裡活用inner class 來作為 內部lazy instance holder<br/>
     * 這樣可以避免當outer class 被載入的時候就要去產生新的實體<br/>
     * 同時也在內部的class 被載入得時候直接就是產生一個instance ,<br/>
     * 而且之後因為已經直接回傳他的instance , 所以也就不需要上鎖了!!! <br/>
     * <p/>
     * 像這樣的設計 就對於多執行緒的環境非常的人性，完全免除鎖定的問題!! <br/>
     * 不過還有最極限的設計，避免被序列化反序列化後的問題 @see ch2.singleton.SerSingleton
     */
    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
