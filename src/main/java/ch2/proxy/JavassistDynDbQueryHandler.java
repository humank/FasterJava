package ch2.proxy;

import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * Created by yikai on 2015/4/12.
 */

/**
 * 換用Javassist 來寫看看!!
 */
public class JavassistDynDbQueryHandler implements MethodHandler {

    private IDBQuery real;

    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {

        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createJavassistDynProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory factory = new ProxyFactory(); // 先初始化javassist factory
        factory.setInterfaces(new Class[]{IDBQuery.class}); //指定要proxy 介面
        Class proxyClass = factory.createClass();
        IDBQuery proxy = (IDBQuery) proxyClass.newInstance();

        ((ProxyObject) proxy).setHandler(new JavassistDynDbQueryHandler());//特別指定handler
        return proxy;
    }

    public static IDBQuery createJavassistByteCodeDynamicProxy() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {

        ClassPool pool = new ClassPool(true);

        //定義類別名稱
        CtClass ctClass = pool.makeClass(IDBQuery.class.getName() + "Javasssist-BytecodeProxy");

        //指定抽象介面
        ctClass.addInterface(pool.get(IDBQuery.class.getName()));

        //add constructor
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));

        ctClass.addField(CtField.make("public " + IDBQuery.class.getName() + "real;", ctClass));

        String dbQueryName = DBQuery.class.getName();

        ctClass.addMethod(CtNewMethod.make(

                "public String request(){ " +
                        "if(real==null) real = new" + dbQueryName + "(); " +
                        "return real.request();" +
                        "}", ctClass));

        Class pc = ctClass.toClass();

        IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();
        return bytecodeProxy;

    }

}
