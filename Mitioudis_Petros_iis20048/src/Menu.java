import java.util.Scanner;

public class Menu {
	private int selection=0;

	public Menu() {
		Scanner input = new Scanner(System.in);
		while(selection !=1 && selection !=2){
			System.out.println("Select 1 or 2");
			System.out.println("1.Encode a decimal to VB code");
			System.out.println("2.Decode a VB code to decimal");
			System.out.print("Your selection:");
			this.selection = input.nextInt();
		}
	}
	
	public int getSelection() {
		return this.selection;
	}
}
