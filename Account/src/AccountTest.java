import java.util.Scanner;

public class AccountTest {
	private static Scanner sc;
	private static double num; //입금 변수
	public static void main(String[]args){
		CheckingAccount acc1 = new CheckingAccount(100.0,"account1"); //1번째 계좌
		CheckingAccount acc2 = new CheckingAccount(100.0,"account2");  //2번째 계좌
		
		System.out.printf("Account1 balance: %f\n",acc1.getBalance());
		System.out.printf("Account2 balance: %f\n",acc2.getBalance());
	
		sc = new Scanner(System.in);
		System.out.print("Enter deposit amount for Account1: \n");
		num = sc.nextDouble();
		acc1.credit(num);
		
		System.out.printf("Account1 balance: %f\n",acc1.getBalance());
		System.out.printf("Account2 balance: %f\n",acc2.getBalance());
	
		System.out.printf("Enter withdrawal amount for Account 2: \n");
		num = sc.nextDouble();
		acc2.debit(num);
		
		System.out.printf("Account1 balance: %f\n",acc1.getBalance());
		System.out.printf("Account2 balance: %f\n",acc2.getBalance());

		System.out.print("next month!\n");
		acc1.nextMonth();
		acc2.nextMonth();
		
		System.out.printf("Account1 balance: %f\n",acc1.getBalance());
		System.out.printf("Account2 balance: %f\n",acc2.getBalance());
		

		
	}
}
