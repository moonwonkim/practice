package moonwonkim;
import java.io.*;
import java.util.*;

public class HangmanTest {
	public static void main(String[]args) throws IOException{
		Hangman hangman = new Hangman();
		
		int result = hangman.playGame();
		
		System.out.println();
		//result�� Ʋ��Ƚ�� �ִ� 5��Ʋ���� ���� 6���ϰ�� ���
		if(result <= 1){ 
			System.out.println("Your answer is correct!!");
			System.out.println("Your level: very perfect~!!");
		}else if(result <= 3){
			System.out.println("Your answer is correct!!");
			System.out.println("Your level: perfect~!!");
		}else if(result <= 5){
			System.out.println("Your answer is correct!!");
			System.out.println("Your level: soso~!!");
		}else{
			System.out.println("Your answer is incorrect!!");
			System.out.println("You are die!!");
		}
	
	}
}