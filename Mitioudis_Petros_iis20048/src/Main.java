public class Main {

	public static void main(String[] args) {
		
		Menu menu = new Menu();	
		Initialize start = new Initialize();
		if(menu.getSelection()==1) {
			start.InitializeEncode();
			char[] encoded_num = Encode(start.getDecimal());
			for(int i=0; i<encoded_num.length; i++ )
				System.out.print(encoded_num[i]);
		}else {
			start.InitializeDecode();
			int decoded_num = Decode(start.getVB());
			System.out.println("The decimal number of the given variable byte code bitstream,is: " + decoded_num);
		}
	}
	
	
	public static char[] Encode(int num) {
		
		int i,j=0;
		String str = Integer.toBinaryString(num);
		char[] temp = str.toCharArray();
		int NumOfZero = 8-temp.length % 8;
		int NumOfBits = (temp.length) / 8 ;
		char[] final_string = new char[8+8*NumOfBits];
		for(i=0; i<NumOfZero; i++) {
			final_string[i] = '0';
		}
		for(i=NumOfZero-NumOfBits; i<final_string.length; i++) {
			if(i%8 != 0 ) {
				final_string[i] = temp[j];
				j++;
			}else
				final_string[i] = '0';
			
		}
		final_string[8*NumOfBits] = '1';
		return final_string;
		
	
	}

	public static int Decode(String bitstream) {
		
		char[] stream = bitstream.toCharArray();
		int num = 0;
		
		/*Check if the bitstream meet the variable code rules(If the bits are multiple of the number 8 AND if the last
		 * sequence of the bits have the continuation bit equal to 1) */
		if(stream.length % 8 != 0){
			System.out.print("The given bytestream isn't a variable byte code");
			System.exit(0);
		}
		if(stream[7] != '1') {
			System.out.print("The given bytestream isn't a variable byte code");
			System.exit(1);
		}
		/* End of the check */
		
		for(int i=0; i<stream.length; i++) {
			if(i%8 != 7 || i==0) {
				if(stream[i] == '1') {
					if(i<=7)
						num += Math.pow(2,i);
					else 
						num += Math.pow(2,i-(i/8));
				}
			}else {
				/* Check if the continuation bit of all the bit sequences except the last, is equal to zero */
				if(stream[i] != '0' && i!=7) {
					System.out.print("The given bytestream isn't a variable byte code");
					System.exit(2);
				}
			}
		}
		return num;
	}
	
}