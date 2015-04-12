package test.ch2.proxy;

import ch2.proxy.CglibDbQueryInterceptor;
import ch2.proxy.IDBQuery;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by yikai on 2015/4/12.
 */
public class CglibDbQueryInterceptorTest {

    @Test
    public void getDbQueryInstance() {
        assertNotNull(CglibDbQueryInterceptor.createCglibProxy());
        assertTrue(CglibDbQueryInterceptor.createCglibProxy() instanceof IDBQuery);
    }
}

