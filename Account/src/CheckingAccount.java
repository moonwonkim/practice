import java.util.Scanner;

public class CheckingAccount extends Account{
	private double balance;
	
	
	public void debit(){ //한도까지 출금 -> 마이너스 통장가능
		if(balance < 0) {
			
		}
	}
	
	public double nextMonth(){// 한달이 지나면 잔액변동
		if(balance > 0){
			balance = balance + (balance * 0.01);
			return balance;
		}else{
			balance = balance - (balance * 0.07);
			return balance;
		}
	}
}
