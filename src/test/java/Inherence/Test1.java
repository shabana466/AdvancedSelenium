package Inherence;
//super calling statement

public class Test1 {
	 Test1(int a){
		System.out.println("value of a is "+ a);
	}
}
 class Test extends Test1{
	 Test(){
	super(10);
		 System.out.println("Zero argument constructor");
	 }
 
	
	

	public static void main(String[] args) {
		
          Test t=new Test();
          
	}

}
