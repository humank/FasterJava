package test.ch2.proxy;

import ch2.proxy.IDBQuery;
import ch2.proxy.JavassistDynDbQueryHandler;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by yikai on 2015/4/12.
 */
public class JavassistDynProxyTest {

    @Test
    public void getDBQueryInstance() throws InstantiationException, IllegalAccessException {
        assertTrue(JavassistDynDbQueryHandler.createJavassistDynProxy() instanceof IDBQuery);
    }


    /**
     * 這個測試會fail , 具體原因還沒完全理解，但初步體會是因為動態產生的class 在compile time 有幾個地方跟需要的結構不一樣，<br/>
     * 導致執行期間會拋出 javassist.compiler.SyntaxError
     *
     * @throws CannotCompileException
     * @throws InstantiationException
     * @throws NotFoundException
     * @throws IllegalAccessException
     */

    @Test
    public void getDBQueryFromDynaBytecodeRetrieve() throws CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException {
        Object target = JavassistDynDbQueryHandler.createJavassistByteCodeDynamicProxy();
        assertTrue(target instanceof IDBQuery);
    }

}
