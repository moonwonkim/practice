import java.util.Scanner;

public class Account {
	
	private double balance; //����
	private String name; //account ����
	private static Scanner sc;
	
	
	Account (double a, String name){ //������
		balance =  a;
		this.name = name;
	}
	public void credit(double money){ //�Ա�
		balance += money;
		
		
	
	}

	public void debit(){ //���
		double money ;
		System.out.println("Enter withdrawal account for " + name + ": ");
		sc = new Scanner(System.in);
		money = sc.nextDouble();
		if(balance - money < 0 ){
			System.out.printf("subtracting %f from account2 balance\n", money);
			System.out.print("Debit amount exceed account balance\n.");
		
			
			
		}else{
			balance -= money;
			System.out.printf("subtracting %f from account1 balance",money);
		}
	}
	
	public double getBalance(){ //�ܾ�Ȯ��
		return balance;
	}
	
	public double setBalance(){//�ܾ� ����
		
	}
	

}