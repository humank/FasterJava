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


}
