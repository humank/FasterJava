package ch2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yikai on 2015/4/12.
 */
public class JdkDbQueryHandler implements InvocationHandler {
    private IDBQuery real;


    /**
     * 透過這個 method 來進行介面的代理類別實現，代理類別的內部邏輯由handler決定!!
     *
     * @return
     */
    public static IDBQuery createJdkProxy() {
        IDBQuery jdkQuery = (IDBQuery) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{IDBQuery.class},
                new JdkDbQueryHandler() // 指定handler !!
        );
        return jdkQuery;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }
}