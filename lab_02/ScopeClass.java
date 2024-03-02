package pl.edu.pw.mini.po.lab02;

import pl.edu.pw.mini.po.lab02.a.*;
import pl.edu.pw.mini.po.lab02.b.MethodClass;
// Ctrl + O - importy automatyczne

public class ScopeClass {

	public static void main(String[] args) {
		
		MyClass myClass = new MyClass();
		
		myClass.defaultValue = 100;
		myClass.publicValue = 200;
		myClass.protectedValue = 300;
		
		//Ctrl + / - komentarz
		//myClass.privateValue = 400; - nie da sie
		
		MyClass2 myClass2 = new MyClass2();
		
		//myClass2.defaultValue = 100; - nie da sie
		myClass2.publicValue = 200;
		//myClass2.protectedValue = 300; - nie da sie

		MethodClass methodClass = new MethodClass();
		methodClass.myGreetingsPublic("Martyna");
		
	}

}
