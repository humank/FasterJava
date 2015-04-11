package ch2.singleton;

import java.io.Serializable;

/**
 * Created by yikai on 2015/4/11.
 */
public class SerSingleton implements Serializable {

    private String name;

    private SerSingleton() {
        System.out.println("Serializable singleton is constructed ! ");

        name = "serSingletonInstance";
    }

    private static SerSingleton instance = new SerSingleton();

    public static SerSingleton getInstance() {
        return instance;
    }

    public static void saySomething(){
        System.out.println("something is happened ! ");
    }

    /**
     * 這個 readResolve method 是Serializable spec 所定義的，<br/>
     * 每一個serializable object 都可以自由發揮來決定每一次返還的實體對象
     * @return
     */
    private Object readResolve(){
        return instance;
    }

}
