import java.util.Scanner;

public abstract class Account {
	
	abstract void getWithdrawableAccount(); //  현재 출금 가능한 금액
	abstract void passTime(int day); // 기간을 인자로 받은후 이자 계산  
	
	protected double balance; //계좌
	private String name; //account 저장
	private static Scanner sc;
	Account(){}
	Account (double a, String name){ //생성자
		balance =  a;
		this.name = name;
	}
	public double credit(double money){ //입금
		balance += money;
		return balance;
		
	
	}

	public void debit(double money){ //출금
		System.out.println("Enter withdrawal account for " + name + ": ");
		sc = new Scanner(System.in);
		money = sc.nextDouble();
		
		balance -= money;
	}
	
	public double getBalance(){ //잔액확인
		return balance;
	}
	
	protected void setBalance(double balance){//잔액 수정
		this.balance = balance;
	}

	

}