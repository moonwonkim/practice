import java.util.Scanner;

public class Account {
	public static void main(String[]args){
		float num1 = 50;
		float num2 = 0;
		
		System.out.printf("account1 balance: %f\n",num1);
		System.out.printf("account2 balance: %f\n",num2);
		while(true){
		
			System.out.printf("Enter withdraw amount for account1: ");
			Scanner input = new Scanner(System.in);
	
			double a = input.nextFloat();
			num1 -= a;
			if(num1<0){
				num1 = 0;
				System.out.printf("Debit amount exceeded account balance ");
				System.out.printf("account1 balance: %f\n",num1);
				System.out.printf("account2 balance: %f\n",num2);
				break;
				
			}else if(num2<0){
				num2 = 0;
				System.out.printf("Debit amount exceeded account balance ");
				System.out.printf("account1 balance: %f\n",num1);
				System.out.printf("account2 balance: %f\n",num2);
				break;
			}
			System.out.printf("account1 balance: %f\n",num1);
			System.out.printf("account2 balance: %f\n",num2);
			
			System.out.printf("Enter withdraw amount for account2: ");
			double b = input.nextFloat();
			num2 -= b;
			if(num1<0){
				num1 = 0;
			}else if(num2<0){
				num2 = 0;
			}
			System.out.printf("account1 balance: %f\n",num1);
			System.out.printf("account2 balance: %f\n",num2);
		
		
		}

	}
}