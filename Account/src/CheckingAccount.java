import java.util.Scanner;

public class CheckingAccount extends Account{
	private double balance;
	
	
	public void debit(){ //�ѵ����� ��� -> ���̳ʽ� ���尡��
		if(balance < 0) {
			
		}
	}
	
	public double nextMonth(){// �Ѵ��� ������ �ܾ׺���
		if(balance > 0){
			balance = balance + (balance * 0.01);
			return balance;
		}else{
			balance = balance - (balance * 0.07);
			return balance;
		}
	}
}
