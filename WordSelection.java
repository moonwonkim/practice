package moonwonkim;
import java.io.*;
import java.util.*;

public class WordSelection{
	public WordSelection(){}
	
	public String selection(){ //�ܾ���ϱ�
		
		System.out.println("�ܾ� ������ �����Ͻÿ�: [1.����  2.���� 3.ä��]");
		Scanner sc = new Scanner(System.in);
		int num;
		while(true){
			num = sc.nextInt();
			if(num == 1){
				System.out.println("�����Ͻ� ������ �����Դϴ�~");
				Random A = new Random();
				int Fruit = A.nextInt(10); //10���� ������ �������� �̴´�.
				if(Fruit == 0){
					return "apple";
				} else if (Fruit == 1){
					return "banana";
				} else if (Fruit == 2){
					return "pineapple";
				} else if (Fruit == 3){
					return "manggo";
				} else if (Fruit == 4){
					return "watermelon";
				}else if (Fruit == 5){
					return "melon";
				}else if (Fruit == 6){
					return "strawberry";
				}else if (Fruit == 7){
					return "grape";
				}else if (Fruit == 8){
					return "lemon";
				}else if (Fruit == 9){
					return "tomato";
				}
			}else if(num == 2){
				System.out.println("�����Ͻ� ������ �����Դϴ�~");
				Random B = new Random();
				int Food = B.nextInt(10); //10���� ������ �������� �̴´�.
				if(Food == 0){
					return "pizza";
				}else if(Food == 1){
					return "chicken";
				}else if(Food == 2){
					return "hambugger";
				}else if(Food == 3){
					return "potato";
				}else if(Food == 4){
					return "ramen";
				}else if(Food == 5){
					return "sausage";
				}else if(Food == 6){
					return "pasta";
				}else if(Food == 7){
					return "taco";
				}else if(Food == 8){
					return "cake";
				}else if(Food == 9){
					return "cheese";
				}
			}else if(num == 3){
				System.out.println("�����Ͻ� ������ ä���Դϴ�~");
				Random C = new Random();
				int Vegetable = C.nextInt(5); //5���� ä���� �������� �̴´�.
				if(Vegetable == 0){
					return "cabbage";
				}else if(Vegetable == 1){
					return "lettuce";
				}else if(Vegetable == 2){
					return "cucumber";
				}else if(Vegetable == 3){
					return "pepper";
				}else if(Vegetable == 4){
					return "bean";
				}
			}else{
				System.out.println("Error Input!!");
				continue;
			}
		}
	}
}
	
	

