package moonwonkim; //2016125006
import java.io.*;
import java.util.*;
//��ǰ��� �����
//����ó�� - ����,�ߺ�   
// ���͸� �Է������� ������ �ߴ� ������ readLine�� ���� ���ڸ� �дµ� ���͸� �Է��ϰ� �Ǹ� ���������� ��� ������ �߻��Ѵ�.
//��� - �����ܾ�, ������ �׸�
// �߰��ϰ� ������ - �ܾ������� �����ؼ� �̱�, �÷��̾� ���� �α�
// 6/24�� Hangman �����ڳ��� �ܾ �����ϴ� WordSelection�� �߰��Ͽ���. ���� ������ �Է¹����� �õ�ȸ���� �����ϴ� ��츦 ���ݴ�.
// 6/25�� DrawPicture Ŭ������ �׸������ ���� , ��ҹ��� ���о��� �ҹ��ڷ� �Է¹ޱ�.3
public class Hangman{
	int remain; // ���� ���ڿ�
	int fail; //���� Ƚ��
	String hidden; //������ ���ڿ�
	private DrawPicture dr; //�׸��׸���
	//StringBuffer�� ������ �Ӽ��� ���� StringBuilder�� �ٸ��� ����ȭ����
	StringBuffer output; //��� ���ڿ�
	StringBuffer input; //�Է� ���ڿ�
	//IOException = ����� ����ó��
	public Hangman() throws IOException{ //�����ڿ� �ܾ �����ϴ°��� �־���
		dr = new DrawPicture();
		dr.drawPicture(fail);
		WordSelection ws = new WordSelection();
		hidden = ws.selection();
	} //��� ������ 
	
	
	public char readString() throws IOException{ //�Է¹��� ���ڿ��� ù��°�� ��ȯ
		//BufferedReader�� readLine�� ���� ���庰�� �о��� 
		//InputStreamReader�� ����Ʈ��Ʈ���� ���ڽ�Ʈ������ �о���
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String user;
		
		System.out.println("���ڸ� �Է����ּ���: ");
		user = in.readLine().toLowerCase();
		if(user.length()==0){
			System.out.println("enter�� �Է��߽��ϴ� �ٽ��Է��ϼ���! ");
			fail -= 1;
			return 0;
		}
			
		return user.charAt(0);
	}

	
	public void CheckString(char userInput){ //�Է¹��� ���ڿ� üũ userInput�� ����� �Է�
		boolean already = false; //already�� �̹� �Է��� ���ڿ�
		for (int i = 0; i < input.length(); i++){
			//charAt(index) = index���ִ� ���� ���
			if (input.charAt(i) == userInput){ // ����ڰ� �Ȱ��� ���ڿ��� �Է�������� fail���� ���� x
				System.out.println("\n�ߺ��� �����Դϴ�. \nTry Again~");
				already = true; //already�� true������
				if(userInput == '\0'){ //���͸� �� �Է�
					fail = 0;
				}
			}
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
		
		dr.drawPicture(fail); //�׸� �׸���
		do{
			CheckString(readString());
			System.out.println("�ܾ� " + hidden.length() + "���� \n"
					+"[" + output + "]");
			System.out.println("�õ������� Ƚ��: " + (6-fail) +"�� �Դϴ�"); 
			if((6-fail) == 1){
				System.out.println("������ ��ȸ�Դϴ� �����ϼ���!"); 
			}
			
			dr.drawPicture(fail); //Ʋ�� Ƚ���� ���� �׸� ���
		}while((remain > 0) && (fail < 6)); //���б�ȸ�� 6�� 
		
		return fail;
	}
	

	
	

	
}