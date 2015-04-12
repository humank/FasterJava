package ch2.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yikai on 2015/4/12.
 */


/**
 * 在這裡自己筆記一下! <br/>
 * 這是第一次自己用gradle build 專案，在引入cglib , javassit的時候把build.gradle配置弄成runtime dependency<br/>
 * 導致我在IDE編譯的時候一直過不了(看得到dependency lib, 卻用不到 ?_?)，這是因為根本就life cycle 不正確... =.= </br/>
 * 後來修正為 compile就能看得到也用得到了!!
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {

    private IDBQuery real;

    /**
     * 透過這樣的intercepter 的切入方式，使用cglib 的enhancer 來處理指定產生的代理類別的instance.
     * 但這個方法還是有點累人，因為每次都得要這樣生成一個handler 來處理
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor());
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        IDBQuery cglibProxy = (IDBQuery) enhancer.create();
        return cglibProxy;
    }

}
