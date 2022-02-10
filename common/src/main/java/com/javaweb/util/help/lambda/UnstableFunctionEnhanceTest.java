package com.javaweb.util.help.lambda;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class UnstableFunctionEnhanceTest {

	public static void main(String[] args) throws Exception {
		UnstableFunctionEnhanceTest.convert(User::getUserName);
	}

	public static <T,R> void convert(FunctionEnhance<T,R> function) throws Exception {
		/**
		ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(function);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        function  = (FunctionEnhance) ois.readObject();
        */
        Method method = function.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(Boolean.TRUE);
        SerializedLambda lambda = (SerializedLambda) method.invoke(function);
        System.out.println(lambda);
        String methodName = lambda.getImplMethodName();
		System.out.println(methodName);//理想中应该输出getUserName，但是不是所有的编译环境都会输出getUserName，有可能输出lambda$0
	}

}

class User {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
