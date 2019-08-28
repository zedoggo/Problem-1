import java.util.Scanner;

public class CaesarCipher {

	public static String encrypt(String plainText, int shift){
		if(shift>26){
			shift = shift%26;
		}else if(shift<0){
			shift = (shift%26)+26;
		}
		
		String cipherText = "";
		int length = plainText.length();
		for(int i=0; i<length; i++){
			char ch = plainText.charAt(i);
			if(Character.isLetter(ch)){
				if(Character.isLowerCase(ch)){
					char c = (char)(ch+shift);
					if(c>'z'){
						cipherText += (char)(ch - (26-shift));
					}else{
						cipherText += c;
					}
				}else if(Character.isUpperCase(ch)){
					char c = (char)(ch+shift);
					if(c>'Z'){
						cipherText += (char)(ch - (26-shift));
					}else{
						cipherText += c;
					}
				}
			}else{
				cipherText += ch;
			}
		}
		return cipherText;
	}
	
	public CaesarCipher(){
		int shift;
		String plainText = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Caesar Cipher");
		System.out.println("=============");
		
		do{
			System.out.println("Input how many shift: ");
			shift = sc.nextInt();
		}while(shift < 0 || shift > 26);
		
		do{
			System.out.println("Input the text that you want to encrypt: ");
			plainText = sc.nextLine();
		}while(plainText.isEmpty());
		
		System.out.println();
		System.out.println("This is the encrypted text: ");
		String cipher = encrypt(plainText, shift);
		
		System.out.println(cipher);
		System.out.println("Thank you for using the service...");
	}
	
	
	public static void main(String[] args) {
		new CaesarCipher();
	}

}
