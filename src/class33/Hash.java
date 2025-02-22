package class33;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

// 需要自己找一下javax.xml.bind的jar，然后导入到项目
//import javax.xml.bind.DatatypeConverter;

public class Hash {

	private MessageDigest hash;

	public Hash(String algorithm) {
		try {
			hash = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public String hashCode(String input) {
		//这里为了编译通过,
//		return DatatypeConverter.printHexBinary(hash.digest(input.getBytes())).toUpperCase();
		return input;
	}

	public static void main(String[] args) {
		System.out.println("支持的算法 : ");
		for (String str : Security.getAlgorithms("MessageDigest")) {
			System.out.println(str);
		}
		System.out.println("=======");

		String algorithm = "MD5";
		Hash hash = new Hash(algorithm);

		String input1 = "zuochengyunzuochengyun1";
		String input2 = "zuochengyunzuochengyun2";
		String input3 = "zuochengyunzuochengyun3";
		String input4 = "zuochengyunzuochengyun4";
		String input5 = "zuochengyunzuochengyun5";
		System.out.println(hash.hashCode(input1));
		System.out.println(hash.hashCode(input2));
		System.out.println(hash.hashCode(input3));
		System.out.println(hash.hashCode(input4));
		System.out.println(hash.hashCode(input5));

	}

}
