package utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
 
public class HashUtil { 
 
	    public static String sha256(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException { 
	    
	    MessageDigest md;
	    md = MessageDigest.getInstance("SHA-256");
	    byte[] sha256hash = new byte[64];
	    md.update(plainText.getBytes("iso-8859-1"), 0, plainText.length() );
	    sha256hash = md.digest();
	    
	    String hashedText = new String (sha256hash, "iso-8859-1");
	    
	    hashedText = String.format("%040x", new BigInteger(1, hashedText.getBytes("iso-8859-1")) );
	    
	    return hashedText;
	    }

	    public static String saltedSha256(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	    
	    	String salt = "ab5bab5944ecb32c85c831acaa079541ad3fe8c446978c1e1723e59899c6d944";
	    	
	    	plainText = plainText + ":" + salt;
	    	
	    	System.out.println("SaltedPlainText = " + plainText);
	    	
	    	return sha256(plainText);
	    }
	    
//	private static String toHex(String arg) throws UnsupportedEncodingException {
//	    return String.format("%040x", new BigInteger(1, arg.getBytes("iso-8859-1")) );
//	}

//	private static String convertToHex(byte[] data) { 
//	    StringBuffer buf = new StringBuffer();
//	    for (int i = 0; i < data.length; i++) { 
//	        int halfbyte = (data[i] >>> 4) & 0x0F;
//	        int two_halfs = 0;
//	        do { 
//	            if ((0 <= halfbyte) && (halfbyte <= 9)) 
//	                buf.append((char) ('0' + halfbyte));
//	            else 
//	                buf.append((char) ('a' + (halfbyte - 10)));
//	            halfbyte = data[i] & 0x0F;
//	        } while(two_halfs++ < 1);
//	    } 
//	    return buf.toString();
//	}
} 