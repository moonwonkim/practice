import java.util.Scanner;

public class CheckingAccount extends Account{
	
	private double credit_limit ; //대출 한도 -100
	private double interest; //이자율 
	private double loan_interest;//대출 이자율
	
	CheckingAccount (double a, String name){
		super(a, name);
		credit_limit = -100;
		interest  = 100;
		loan_interest = 100;
	}

	@Override
	public void debit(double money){ //한도까지 출금 -> 마이너스 통장가능
		balance -= money;
		if(balance - money < credit_limit) {
			System.out.print("한도 초과입니다!!\n");
		}
		else if (balance < 0){
			System.out.print("잔액이 0보다 작습니다.");
		}
		
	}
	
	public double nextMonth(){// 한달이 지나면 잔액변동
		if(balance > 0){
			balance = balance + (balance * 0.01);
			return balance;
		}else{
			balance = balance + (balance * 0.07);
			return -balance;
		}
	}
}


