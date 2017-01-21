package core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SmartElementProxy implements InvocationHandler {

    private final ElementFinder finder;

    SmartElementProxy(ElementFinder finder){
        this.finder = finder;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        long timeout = 5000;
        long poolingInterval = 100;
        Throwable lastError;
        do {
            try{
                return Commands.executeCommand(method, proxy, finder, args);
            }catch (Throwable catched){
                lastError = catched;
                catched.printStackTrace();
            }
            Utils.sleep(poolingInterval);
        }while(System.currentTimeMillis() - startTime <= timeout);
        throw lastError;
    }
}
