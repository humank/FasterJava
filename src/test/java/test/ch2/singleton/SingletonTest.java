package test.ch2.singleton;

import ch2.singleton.Singleton;
import org.junit.Test;

import static ch2.singleton.Singleton.isInited;
import static org.junit.Assert.assertTrue;


/**
 * Created by yikai on 2015/4/11.
 */


public class SingletonTest {

    @Test
    public void checkIsInstantiated() {
        assertTrue(isInited());
    }

    @Test
    public void checkExecutionSequence() {
        Singleton.saySomething();
    }
}
