import java.util.Scanner;

public class Account {
	
	private double balance; //계좌
	private String name; //account 저장
	private static Scanner sc;
	
	Account (double a, String name){ //생성자
		balance =  a;
		name = this.name;
	}
	public void credit(double money){ //입금
		balance += money;
	
	}

	public void debit(){ //출금
		System.out.printf("Enter withdrawal account for %s: ",name);
		double money ;
		money = sc.nextDouble();
		if(balance - money < 0 ){
			System.out.printf("subtracting %f from account2 balance", money);
			System.out.print("Debit amount exceed account balance.");
		
			
			
		}else{
			balance -= money;
			System.out.printf("subtracting %f from account1 balance",money);
		}
	}
	
	public double getBalance(){ //잔액확인
		return balance;
	}
	

}