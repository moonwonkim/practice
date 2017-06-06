package moonwonkim; //2016125006
import java.io.*;
import java.util.*;
//��ǰ��� �����
//����ó�� - ��ĭ,�ѱ�,��ҹ��� try catch ����غ���
// �������� - �ܾ� ���� �̱�
// 5������ ���а��� 6��°���� ���� ��
// �õ����� Ƚ�� ������ֱ�
// �����ϸ� GUI�� �����ϱ�
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
		int random = R.nextInt(3); //�������� ���ڿ��� �̴´�
		if(random == 0){
			hidden = "hello";
		} else if (random == 1){
			hidden = "administrator";
		} else if (random == 2){
			hidden = "kanggun";
		}
	}
	
	public void CheckString(char guess){ //�Է¹��� ���ڿ� üũ guess�� ����� �Է�
		boolean already = false; //already�� �̹� �Է��� ���ڿ�
		for (int i = 0; i < input.length(); i++){
			//charAt(index) = index���ִ� ���� ���
			if (input.charAt(i) == guess){ // ����ڰ� �Ȱ��� ���ڿ��� �Է�������� fail���� ���� x
				System.out.println("\n�ߺ��� �����Դϴ�. \nTry Again~");
				already = true; //already�� true������
			}
		}
		
		if (!already){
			input.append(guess); //�Էµ� ���ڿ��� �߰�
			
			boolean correct = false; //correct�� ���� ���ڿ�
			for(int i = 0; i < hidden.length(); i++){
				if(hidden.charAt(i) == guess){ //������ ���ڿ��� �ִ� ���ڿ����� ��
					//setCharAt(a,b) a�� b�� �ִ´ٴ� ����
					output.setCharAt(i,guess); //�ش��ϴ� ���ڿ��� �ִ°�� '-'�� �Է��� ���ڷ� ����
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
		
	//	drawPicture(); //������ �׸���
		do{
			CheckString(readString());
			System.out.println("�ܾ� " + hidden.length() + "���� \n"
					+"[" + output + "]");
		//	drawPicture(); //Ʋ�� Ƚ���� ���� ������ ���
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
		
		return user.charAt(0);
	}

	
	
/*	
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
*/
	
}