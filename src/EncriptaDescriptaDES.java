import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class EncriptaDescriptaDES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			//Informa o tipo de criptografia DES
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			
			//Gera a chave da criptografia
			SecretKey secretKey = keyGenerator.generateKey();
			
			Cipher cifraDES;
			//Cria a cifra
			cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
			
			//Inicializa a cifra para o processo de criptografia
			//Cipher.ENCRYPT_MODE -> informa que sera feita uma criptografia
			cifraDES.init(Cipher.ENCRYPT_MODE, secretKey);
			
			/*Texto puro -> Boa noite Marcelo aprendendo criptografia
			 Transforma o Texto puro em Bytes */
			byte[] textoPuro = "Boa noite Marcelo estudando criptografia".getBytes();
			
			System.out.println("Texto [Formato de Byte] : " + textoPuro);
			System.out.println("Texto Puro : " + new String(textoPuro));
			
			/*Texto criptografado -> ou seja criptografa a frase que esta na variavel
			textoPuro */
			byte[] textoCriptografado = cifraDES.doFinal(textoPuro);			
			System.out.println("Texto Criptografado : " + textoCriptografado);
			
			/* Inicializa a cifra para o processo de decriptografia
			  Cipher.DECRYPT_MODE -> informa que sera feita uma decriptografia */
			cifraDES.init(Cipher.DECRYPT_MODE, secretKey);
			
			//Decriptografa o texto
			byte[] textoDecriptografado = cifraDES.doFinal(textoCriptografado);
			
			System.out.println("Texto Decriptografado : " + new String(textoDecriptografado));
			
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
