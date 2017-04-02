import java.util.Scanner;

public class CheckingAccount extends Account{
	
	private double credit_limit ; //���� �ѵ� -100
	private double interest; //������ 
	private double loan_interest;//���� ������
	
	CheckingAccount (double a, String name){
		super(a, name);
		credit_limit = -100;
		interest  = 100;
		loan_interest = 100;
	}

	@Override
	public void debit(double money){ //�ѵ����� ��� -> ���̳ʽ� ���尡��
		balance -= money;
		if(balance - money < credit_limit) {
			System.out.print("�ѵ� �ʰ��Դϴ�!!\n");
		}
		else if (balance < 0){
			System.out.print("�ܾ��� 0���� �۽��ϴ�.");
		}
		
	}
	
	public double nextMonth(){// �Ѵ��� ������ �ܾ׺���
		if(balance > 0){
			balance = balance + (balance * 0.01);
			return balance;
		}else{
			balance = balance + (balance * 0.07);
			return -balance;
		}
	}
}


