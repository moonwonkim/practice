import java.util.Scanner;

public class SavingAccounts extends Account{
	private double interest; //이자
	private int constract;//계약
	SavingAccounts (double balance, double interest){ 
		this.balance = balance;
		this.interest = interest;
	}
	@Override
	public void debit(double money){ //계약기간 출금불가, 계약종료 후 출금가능
		if(constract < 12){
			System.out.println("아직 출금할 수 없습니다.");
		}else if(constract >= 12){
			balance -= money;
		}
	}
	@Override
	public double getWithdrawableAccount(){ //현재 출금 가능 금액
		if(constract < 12){
			return 0;
		}else{
			return balance;
		}
	}
	
	public void passTime(int day){ //이자
		if(constract < 12){
			constract += day;
		}else if(constract >= 12){
			balance = balance* Math.pow(1+interest,12);
		}
	}
	
	
	




}
	