package Inherence;
//single level inherence

 class sample {
	void showA(){
		System.out.println("A class method");
	}
}
class B extends sample{
 void showB() {
	 System.out.println("A class method");
 }
}
public class A{
public static void main(String[] args) {
	B	b1=new B();
	b1.showA();
	b1.showB();

	}
}


