//Hansanie Neththasinghe

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);		
		//Taking user inputs
		System.out.print("Enter pattern 1 : ");
		String p1 = scanner.next();
		
		System.out.print("Enter pattern 2 : ");
		String p2 = scanner.next();
		
		System.out.print("Enter count : ");
		int count = scanner.nextInt();
		
		
		System.out.println("========Threads start printing patterns.========");
		Main ob = new Main();
		Pattern01 Pattern_01 = new Pattern01(ob,p1, count);
		Pattern02 Pattern_02 = new Pattern02(ob,p2, count);
		
		Pattern_02.start();
		Pattern_01.start();
		
	}
}
class Pattern01 extends Thread{
	private String pattern;
	private int count;
	Main ob;

	public Pattern01(Main ob, String pattern, int count){
		this.pattern = pattern;
		this.count = count;
		this.ob = ob;
	}
		
	public void run(){
		
		synchronized(ob) {
			try {
				int n = this.count;
				for(int i=1; i<=n;i++) {
					System.out.print("Pattern 01 Thread = ");
					
					for(int j =1; j<=i;j++) {
						System.out.print(" ");
					}
					
					for(int j =i; j<=n;j++) {
						System.out.print(this.pattern + " ");
					}
					
					for(int j = i; j<=n; j++) {
						System.out.print(" ");
					}
					System.out.println();
					sleep(1000);
					ob.notify();
					ob.wait();
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
	
class Pattern02 extends Thread{
	private String pattern;
	private int count;
	Main ob;
		
	Pattern02(Main ob,String pattern, int count){
		this.pattern = pattern;
		this.count = count;
		this.ob = ob;
	}
	
	
	public void run(){
		synchronized(ob) {
			try {
				int n = this.count;
				for(int i=1; i<=n;i++) {
					System.out.print("Pattern 02 Thread = ");
					for(int j =1; j<=i;j++) {
						System.out.print(" ");
					}
					
					for(int j =i; j<=n;j++) {
						System.out.print(this.pattern + " ");
					}
					
					for(int j = i; j<=n; j++) {
						System.out.print(" ");
					}
					System.out.println();
					sleep(1000);
					ob.notify();
					ob.wait();
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
		
}
