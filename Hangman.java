package moonwonkim; //2016125006
import java.io.*;
import java.util.*;
//행맨게임 만들기
//예외처리 - 빈칸,한글,대소문자 try catch 사용해보기
// 주제선택 - 단어 랜덤 뽑기
// 5번까지 실패가능 6번째에는 게임 끝
// 시도가능 횟수 출력해주기
// 가능하면 GUI로 구현하기
public class Hangman{
	int remain; // 남은 문자열
	int fail; //실패 횟수
	String hidden; //숨겨진 문자열
	//StringBuffer은 가변의 속성을 가짐 StringBuilder와 다르게 동기화보장
	StringBuffer output; //출력 문자열
	StringBuffer input; //입력 문자열
	
	//IOException = 입출력 예외처리
	public Hangman() throws IOException{ //행맨 생성자
		Random R = new Random();
		int random = R.nextInt(3); //랜덤으로 문자열을 뽑는다
		if(random == 0){
			hidden = "hello";
		} else if (random == 1){
			hidden = "apple";
		} else if (random == 2){
			hidden = "bicycle";
		}
	}
	
	public void CheckString(char guess){ //입력받은 문자열 체크 guess는 사용자 입력
		boolean already = false; //already는 이미 입력한 문자열
		for (int i = 0; i < input.length(); i++){
			//charAt(index) = index에있는 문자 출력
			if (input.charAt(i) == guess){ // 사용자가 똑같은 문자열을 입력했을경우 fail에서 차감 x
				System.out.println("\n중복된 문자입니다. \nTry Again~");
				already = true; //already를 true값으로
			}
		}
		
		if (!already){
			input.append(guess); //입력된 문자열에 추가
			
			boolean correct = false; //correct는 맞춘 문자열
			for(int i = 0; i < hidden.length(); i++){
				if(hidden.charAt(i) == guess){ //문제의 문자열에 있는 문자열인지 비교
					//setCharAt(a,b) a에 b를 넣는다는 개념
					output.setCharAt(i,guess); //해당하는 문자열이 있는경우 '-'를 입력한 문자로 변경
					remain--; //남아있는 문자수 감소
					correct = true; //입력한 문자가 문제에 있을경우 true 반환
				}
			}
			if(!correct){ //입력된 문자가 없을경우 실패횟수 1회씩 증가
				fail++;
			}
		}
	}
	
	public int playGame() throws IOException{ //행맨게임시작
		
		output = new StringBuffer();
		
		for (int i = 0; i < hidden.length(); i++){
			output.append('-'); //문자열의 길이만큼 '-'로 출력한다
		}
		input = new StringBuffer();
		
		remain = hidden.length(); //남아있는 맞출 문제의 문자수
		fail = 0;
		
		System.out.println("단어 " + hidden.length() + "글자 \n"
				+ "[" + output + "]");
		
	//	drawPicture(); //교수대 그리기
		do{
			CheckString(readString());
			System.out.println("단어 " + hidden.length() + "글자 \n"
					+"[" + output + "]");
		//	drawPicture(); //틀린 횟수에 따른 교수대 출력
		}while((remain > 0) && (fail < 6)); //실패기회는 6번 
		
		return fail;
	}
	
	public char readString() throws IOException{ //입력받은 문자열의 첫번째를 반환
		//BufferedReader는 readLine을 통한 문장별로 읽어줌 
		//InputStreamReader는 바이트스트림을 문자스트림으로 읽어줌
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String user;
		
		System.out.println("문자를 입력해주세요: ");
		user = in.readLine();
		
		return user.charAt(0);
	}

	
	
/*	
	public void drawPicture(){
		System.out.println("   \n\n   ");
		System.out.println("   |----------------|   ");
	
		switch(fail){ //실패 횟수만큼 그림그리기
		
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
			System.out.println("            ○  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 2:
			System.out.println("            |  ");
			System.out.println("            ○  ");
			System.out.println("          -----  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 3:
			System.out.println("            |  ");
			System.out.println("            ○  ");
			System.out.println("          -----  ");
			System.out.println("          |   |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	

		case 4:
			System.out.println("            |  ");
			System.out.println("            ○  ");
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
			System.out.println("            ○  ");
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
