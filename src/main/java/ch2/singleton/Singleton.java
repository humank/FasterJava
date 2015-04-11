package ch2.singleton;

/**
 * Created by yikai on 2015/4/11.
 */


/**
 * 在傳統的GoF pattern 裏頭已經提到爛掉的singleton pattern ,<br/>
 * 我們都知道要做好簡單的控管，讓singleton 可以比較省記憶體，也少去gc 的次數<br/>
 * singleton 在這裏這個範例是第一版本 !!
 */
public class Singleton {

    private Singleton() {
        System.out.println("Singleton is constructed !! ");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    //TODO

    /**
     * 思考一下這個singleton 的問題在哪裡?<br/>
     * 這個singleton 的問題出在於，他無法延遲載入這個class initialization 的時間點..<br/>
     * 假設他的constructor 會跑很慢，那這樣就整個會被拉得超級慢!!!<br/>
     * <p/>
     * <br/>
     * <p/>
     * 此外，由於instance 這個 instance variable 是static 期間宣告並初始化!!<br/>
     * 也就意味著在JVM 載入的時候他的singleton instance 就會被建立了...<br/>
     * 如果這個class 還有其他功能，那就會在被呼叫其他的功能的時候就被強制初始化了 Orz <br/>
     * 那麼還有啥方法嗎? 請看其他的範例 @see ch2.singleton.LazySingleton
     */
    public static void saySomething() {
        System.out.println("lol .. you see see you , your singleton instance is called before my invoke ...");
    }

    public static boolean isInited() {
        return instance != null;
    }

}
