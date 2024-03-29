package net.haaim.web.api.system.security;

import java.security.MessageDigest;

public class Crypto {
	public static String sha256(final String string) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(string.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			
			for(int i=0;i<hash.length;i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			
			return hexString.toString();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
