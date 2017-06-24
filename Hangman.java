package moonwonkim; //2016125006
import java.io.*;
import java.util.*;
//��ǰ��� �����
//����ó�� - ����,�ߺ�
//��� - �����ܾ�, ������ �׸�
public class Hangman{
	int remain; // ���� ���ڿ�
	int fail; //���� Ƚ��
	String hidden; //������ ���ڿ�
	//StringBuffer�� ������ �Ӽ��� ���� StringBuilder�� �ٸ��� ����ȭ����
	StringBuffer output; //��� ���ڿ�
	StringBuffer input; //�Է� ���ڿ�
	
	//IOException = ����� ����ó��
	public Hangman() throws IOException{ //��� ������
		Random R = new Random();
		int Fruit = R.nextInt(10); //10���� ������ �������� �̴´�.
		if(Fruit == 0){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "apple";
		} else if (Fruit == 1){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "banana";
		} else if (Fruit == 2){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "pineapple";
		} else if (Fruit == 3){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "manggo";
		} else if (Fruit == 4){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "watermelon";
		}else if (Fruit == 5){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "melon";
		}else if (Fruit == 6){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "strawberry";
		}else if (Fruit == 7){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "grape";
		}else if (Fruit == 8){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "lemon";
		}else if (Fruit == 9){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "tomato";
		}else if (Fruit == 10){
			System.out.println("Hint: �ܾ�� ���� �Դϴ�!!");
			hidden = "cherry";
		}
		
		
	}
	
	public void CheckString(char userInput){ //�Է¹��� ���ڿ� üũ userInput�� ����� �Է�
		boolean already = false; //already�� �̹� �Է��� ���ڿ�
		for (int i = 0; i < input.length(); i++){
			//charAt(index) = index���ִ� ���� ���
			if (input.charAt(i) == userInput){ // ����ڰ� �Ȱ��� ���ڿ��� �Է�������� fail���� ���� x
				System.out.println("\n�ߺ��� �����Դϴ�. \nTry Again~");
				already = true; //already�� true������
			}//..
		}
		if (!already){
			input.append(userInput); //�Էµ� ���ڿ��� �߰�
			
			boolean correct = false; //correct�� ���� ���ڿ�
			for(int i = 0; i < hidden.length(); i++){
				if(hidden.charAt(i) == userInput){ //������ ���ڿ��� �ִ� ���ڿ����� ��
					//setCharAt(a,b) a�� b�� �ִ´ٴ� ����
					output.setCharAt(i,userInput); //�ش��ϴ� ���ڿ��� �ִ°�� '-'�� �Է��� ���ڷ� ����
					remain--; //�����ִ� ���ڼ� ����
					correct = true; //�Է��� ���ڰ� ������ ������� true ��ȯ
				}
			}
			if(!correct){ //�Էµ� ���ڰ� ������� ����Ƚ�� 1ȸ�� ����
				fail++;
			}
		}
	}
	
	public int playGame() throws IOException{ //��ǰ��ӽ���
		
		output = new StringBuffer();
		
		for (int i = 0; i < hidden.length(); i++){
			output.append('-'); //���ڿ��� ���̸�ŭ '-'�� ����Ѵ�
		}
		input = new StringBuffer();
		
		remain = hidden.length(); //�����ִ� ���� ������ ���ڼ�
		fail = 0;
		
		System.out.println("�ܾ� " + hidden.length() + "���� \n"
				+ "[" + output + "]");
		System.out.println("�õ������� Ƚ��: " + (6-fail) +"�Դϴ�"); 
		
		drawPicture(); //�׸� �׸���
		do{
			CheckString(readString());
			System.out.println("�ܾ� " + hidden.length() + "���� \n"
					+"[" + output + "]");
			System.out.println("�õ������� Ƚ��: " + (6-fail) +"�� �Դϴ�"); 
			if((6-fail) == 1){
				System.out.println("������ ��ȸ�Դϴ� �����ϼ���!"); 
			}
			
			drawPicture(); //Ʋ�� Ƚ���� ���� �׸� ���
		}while((remain > 0) && (fail < 6)); //���б�ȸ�� 6�� 
		
		return fail;
	}
	
	public char readString() throws IOException{ //�Է¹��� ���ڿ��� ù��°�� ��ȯ
		//BufferedReader�� readLine�� ���� ���庰�� �о��� 
		//InputStreamReader�� ����Ʈ��Ʈ���� ���ڽ�Ʈ������ �о���
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String user;
		
		System.out.println("���ڸ� �Է����ּ���: ");
		user = in.readLine();
		if(user.length()==0){
			System.out.println("null�� �Է��ϼ̽��ϴ�\n�õ�ȸ��:-1 ");
			return 0;
		}
		return user.charAt(0);
	}

	
	
	
	public void drawPicture(){
		System.out.println("   \n\n   ");
		System.out.println("   |----------------|   ");
	
		switch(fail){ //���� Ƚ����ŭ �׸��׸���
		
		case 0:
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("   \n  ");
			break;	
			
		case 1:
			System.out.println("            |  ");
			System.out.println("            ��  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 2:
			System.out.println("            |  ");
			System.out.println("            ��  ");
			System.out.println("          -----  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 3:
			System.out.println("            |  ");
			System.out.println("            ��  ");
			System.out.println("          -----  ");
			System.out.println("          |   |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	

		case 4:
			System.out.println("            |  ");
			System.out.println("            ��  ");
			System.out.println("          -----  ");
			System.out.println("          |   |  ");
			System.out.println("            |  ");
			System.out.println("          |   |");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 5:
			System.out.println("            |  ");
			System.out.println("            ��  ");
			System.out.println("          -----  ");
			System.out.println("          |   |  ");
			System.out.println("            |  ");
			System.out.println("          |   |");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 6:
			System.out.println("           X-X  ");
			System.out.println("       ===========  ");
			System.out.println("| -------You are DIE ----- |  ");
			break;
		}
	}

	
}