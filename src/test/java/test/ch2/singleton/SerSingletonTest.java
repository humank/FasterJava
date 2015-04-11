package test.ch2.singleton;

import ch2.singleton.SerSingleton;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by yikai on 2015/4/12.
 */
public class SerSingletonTest {

    @Test
    public void test() throws IOException, ClassNotFoundException {
        SerSingleton s1 = null;
        SerSingleton s = SerSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton) ois.readObject();

        assertEquals(s, s1);

    }
}
