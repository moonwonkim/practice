import java.util.Scanner;

public class Account {
	
	private double balance; //계좌
	private String name; //account 저장
	private static Scanner sc;
	
	
	Account (double a, String name){ //생성자
		balance =  a;
		this.name = name;
	}
	public void credit(double money){ //입금
		balance += money;
		
		
	
	}

	public void debit(){ //출금
		double money ;
		System.out.println("Enter withdrawal account for " + name + ": ");
		sc = new Scanner(System.in);
		money = sc.nextDouble();
		if(balance - money < 0 ){
			System.out.printf("subtracting %f from account2 balance\n", money);
			System.out.print("Debit amount exceed account balance\n.");
		
			
			
		}else{
			balance -= money;
			System.out.printf("subtracting %f from account1 balance",money);
		}
	}
	
	public double getBalance(){ //잔액확인
		return balance;
	}
	
	public double setBalance(){//잔액 수정
		
	}
	

}