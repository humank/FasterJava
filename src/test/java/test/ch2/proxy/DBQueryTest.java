package test.ch2.proxy;

import ch2.proxy.DBQueryProxy;
import ch2.proxy.IDBQuery;
import org.junit.Test;

/**
 * Created by yikai on 2015/4/12.
 */
public class DBQueryTest {

    @Test
    public void testDBQuery(){
        IDBQuery dbquery = new DBQueryProxy();
        dbquery.request();
    }
}
