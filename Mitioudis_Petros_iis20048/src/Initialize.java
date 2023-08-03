import java.util.Scanner;

public class Initialize {
	private int number;
	private String VB;
	private Scanner keyboard = new Scanner(System.in);
	
	public Initialize() {
		
	}
	
	public void InitializeEncode() {
		System.out.print("Enter a number to be encoded with VB code:");
		number = keyboard.nextInt();
		while(number<=0) {
			System.out.print("Enter a number greater than 0:");
			number = keyboard.nextInt();
			}
	}
	
	public void InitializeDecode() {
		System.out.print("Enter a binary number to be decoded with VB code:");
		VB = keyboard.next();
		VB = String_Reverse(VB);
		keyboard.close();
	}
	
	public int getDecimal() {
		return this.number;
	}
	
	public String getVB() {
		return VB;
	}
	
	public static String String_Reverse(String s) {
		
		StringBuilder input = new StringBuilder();
        input.append(s);
        input.reverse();
        return input.toString();
	}
	
}

