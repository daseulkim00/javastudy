package prob5;

public class Prob5 {

	public static void main(String[] args) {
		  int a;
	      int b;
	      for(int i=0; i<100; i++) {
	         a=i/10; //10의 자리
	         b=i%10;   //1의 자리
	         
	         if((a%3==0 && a!=0) && (b%3==0 && b!=0)) {
	            if(a==0) {
	               System.out.println(b + "\0짝짝");
	            } else {
	               System.out.print(a);
	               System.out.println(b + "\0짝짝");
	            }

	         } else if((a%3==0 && a!=0) || (b%3==0 && b!=0)) {
	            if(a==0) {
	               System.out.println(b + "\0짝");
	            } else {
	               System.out.print(a);
	               System.out.println(b + "\0짝");
	            }
	            

	         }
	         
	      }
	}
}
