package clazz;

import java.lang.reflect.Proxy;

public class SolutonProxy {

	public static void main(String[] args) {
		Object object  = new Object();
		@SuppressWarnings("unchecked")
		Class<Object> oClass = (Class<Object>) object.getClass();
		
		Proxy.getProxyClass(oClass.getClassLoader(), oClass.getInterfaces());

	}

}
