import java.util.Scanner;

public class CheckingAccount extends Account{
	
	private double credit_limit ; //대출 한도 
	private double interest; //이자율 
	private double loan_interest;//대출 이자율

	CheckingAccount (double balance, double credit_limit, double interest, double loan_interest ){
		super();
		this.credit_limit = credit_limit;
		this.balance = balance;
		this.interest = interest;
		this.loan_interest = loan_interest;
		
	
	}
	

	@Override
	public void debit(double money){ //한도까지 출금 -> 마이너스 통장가능
		balance -= money;
		
		if (balance < 0){
			System.out.print("잔액이 0보다 작습니다.\n");
		}
		else if(balance - money < credit_limit) {
			System.out.print("한도 초과입니다!!\n");
		}
		
	}
	
	public double nextMonth(){// 한달이 지나면 잔액변동
		if(balance > 0){
			balance = balance + (balance * 0.01);
			return balance;
		}else{
			balance = balance + (balance * 0.07);
			return -(balance);
		}
	}
		
	public double getWithdrawableAccount(){ //현재 출금 가능한 금액
		
		return credit_limit + balance;
	}
	
	public void passTime(int day){ // 기간을 인자로 받은후 이자 계산
		balance += balance*day*interest;
	}

	public boolean isBankrupted(){
		if(balance < -1*credit_limit){
			System.out.println("account1 went Bankrupt!");
			return true;
		}else{
			return false;
		}
	}
}


