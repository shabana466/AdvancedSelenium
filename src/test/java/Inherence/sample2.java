package Inherence;
//hirectial

public class sample2 {
	void showA(){
		System.out.println("A class method");
	}
}
class P extends A{
 void show() {
	 System.out.println("A class method");
 }
}
class Q extends A{
	 void showC() {
		 System.out.println("A class method");
	 }
	public static void main(String[] args) {
	  C a=new C();
	  a.showA();
	  a.showC();
	  P p=new P();
	    p.show();
	    p.showA();
	  
	 

	  
	}

}
