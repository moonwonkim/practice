import java.util.Scanner;

public class SavingAccounts extends Account{
	private double interest; //����
	private int constract;//���
	SavingAccounts (double balance, double interest){ 
		this.balance = balance;
		this.interest = interest;
	}
	@Override
	public void debit(double money){ //���Ⱓ ��ݺҰ�, ������� �� ��ݰ���
		if(constract < 12){
			System.out.println("���� ����� �� �����ϴ�.");
		}else if(constract >= 12){
			balance -= money;
		}
	}
	@Override
	public double getWithdrawableAccount(){ //���� ��� ���� �ݾ�
		if(constract < 12){
			return 0;
		}else{
			return balance;
		}
	}
	
	public void passTime(int day){ //����
		if(constract < 12){
			constract += day;
		}else if(constract >= 12){
			balance = balance* Math.pow(1+interest,12);
		}
	}
	
	
	




}
	