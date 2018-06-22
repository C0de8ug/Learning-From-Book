package Understanding_the_JVM_Advanced_Features_and_Best_Practices.chapter8;

import java.io.Serializable;

public class Overload {

	public static void sayHello(Object arg) {
        System.out.println("hello Object");
	}



	public static void sayHello(char... arg) {
		System.out.println("hello char ...");
	}

	public static void sayHello(Serializable arg) {
		System.out.println("hello Serializable");
	}

	public static void main(String[] args) {
		sayHello('a');
	}
}
