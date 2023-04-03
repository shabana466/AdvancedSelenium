package Inherence;
//multiple inherence

public class sample1 {
	void showA(){
		System.out.println("A class method");
	}
}
class p extends A{
 void show() {
	 System.out.println("A class method");
 }
}
class C extends p{
	 void showC() {
		 System.out.println("A class method");
	 }
	public static void main(String[] args) {
	
    C s2=new C();
      s2.showA();
      s2.showC();
      s2.show();
	

}
}
