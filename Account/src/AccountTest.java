import java.util.Scanner;

public class AccountTest {
	private static Scanner sc;
	private static double num; //�Ա� ����
	public static void main(String[]args){
		Account acc1 = new Account(100.0,"account1"); //1��° ����
		Account acc2 = new Account(100.0, "account2");  //2��° ����
		
		System.out.printf("Account1 balance: %f\n",acc1.getBalance());
		System.out.printf("Account2 balance: %f\n",acc2.getBalance());
	
		sc = new Scanner(System.in);

		
		System.out.printf("Account1 balance: %f\n",acc1.getBalance());
		System.out.printf("Account2 balance: %f\n",acc2.getBalance());
		
		acc2.debit();
		
		System.out.printf("Account1 balance: %f\n",acc1.getBalance());
		System.out.printf("Account2 balance: %f\n",acc2.getBalance());
		
		
		
		
	}
}
