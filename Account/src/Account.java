import java.util.Scanner;

public class Account {
	
	private double balance; //����
	private String name; //account ����
	private static Scanner sc;
	
	Account (double a, String name){ //������
		balance =  a;
		name = this.name;
	}
	public void credit(double money){ //�Ա�
		balance += money;
	
	}

	public void debit(){ //���
		System.out.printf("Enter withdrawal account for %s: ",name);
		double money ;
		money = sc.nextDouble();
		if(balance - money < 0 ){
			System.out.printf("subtracting %f from account2 balance", money);
			System.out.print("Debit amount exceed account balance.");
		
			
			
		}else{
			balance -= money;
			System.out.printf("subtracting %f from account1 balance",money);
		}
	}
	
	public double getBalance(){ //�ܾ�Ȯ��
		return balance;
	}
	

}