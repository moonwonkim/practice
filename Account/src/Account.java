import java.util.Scanner;

public abstract class Account {
	
	abstract void getWithdrawableAccount(); //  ���� ��� ������ �ݾ�
	abstract void passTime(int day); // �Ⱓ�� ���ڷ� ������ ���� ���  
	
	protected double balance; //����
	private String name; //account ����
	private static Scanner sc;
	Account(){}
	Account (double a, String name){ //������
		balance =  a;
		this.name = name;
	}
	public double credit(double money){ //�Ա�
		balance += money;
		return balance;
		
	
	}

	public void debit(double money){ //���
		System.out.println("Enter withdrawal account for " + name + ": ");
		sc = new Scanner(System.in);
		money = sc.nextDouble();
		
		balance -= money;
	}
	
	public double getBalance(){ //�ܾ�Ȯ��
		return balance;
	}
	
	protected void setBalance(double balance){//�ܾ� ����
		this.balance = balance;
	}

	

}