import java.util.Scanner;

public class AccountTest {

	public static void main(String[]args){
		Account acc1 = new Account(50.0,"account1"); //1¹øÂ° °èÁÂ
		Account acc2 = new Account(0.0, "account2");  //2¹øÂ° °èÁÂ
		
		System.out.printf("account1 balance: %f",acc1.getBalance());
		System.out.printf("account2 balance: %f",acc2.getBalance());
		
		acc1.debit();
		
		System.out.printf("account1 balance: %f",acc1.getBalance());
		System.out.printf("account2 balance: %f",acc2.getBalance());
		
		acc2.debit();
		
		System.out.printf("account1 balance: %f",acc1.getBalance());
		System.out.printf("account2 balance: %f",acc2.getBalance());
		
		
		
		
	}
}
