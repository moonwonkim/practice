import java.util.Scanner;

public class CheckingAccount extends Account{
	
	private double credit_limit ; //���� �ѵ� 
	private double interest; //������ 
	private double loan_interest;//���� ������

	CheckingAccount (double balance, double credit_limit, double interest, double loan_interest ){
		super();
		this.credit_limit = credit_limit;
		this.balance = balance;
		this.interest = interest;
		this.loan_interest = loan_interest;
		
	
	}
	

	@Override
	public void debit(double money){ //�ѵ����� ��� -> ���̳ʽ� ���尡��
		
		if (balance < 0){
			System.out.print("�ܾ��� 0���� �۽��ϴ�.\n");
		}
		else if(balance - money < -1*credit_limit) {
			System.out.print("�ѵ� �ʰ��Դϴ�!!\n");
		}
		
		balance -= money;
		
	}
	
	public double nextMonth(){// �Ѵ��� ������ �ܾ׺���
		if(balance > 0){
			balance = balance + (balance * 0.01);
			return balance;
		}else{
			balance = balance + (balance * 0.07);
			return -(balance);
		}
	}
		
	public double getWithdrawableAccount(){ //���� ��� ������ �ݾ�
		
		return credit_limit + balance;
	}
	
	public void passTime(int day){ // �Ⱓ�� ���ڷ� ������ ���� ���
		if(balance > 0){
			balance += balance*day*interest;
		}else{
			balance += balance*day*loan_interest;
		}
	}

	public boolean isBankrupted(){
		if(balance < (-1)*credit_limit){
			System.out.println("account1 went Bankrupt!");
			return true;
		}else{
			return false;
		}
	}
}


