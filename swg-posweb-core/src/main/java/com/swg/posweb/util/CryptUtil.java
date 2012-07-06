/**
 * 
 */
package com.swg.posweb.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

import com.swg.posweb.PoswebErrorException;

/**
 * @author satriaprayoga
 *
 */
public class CryptUtil {

	private CryptUtil(){}

	private static final char[] HEX = "0123456789abcdef".toCharArray();
	
	public static final String getMD5(String target) {
		try {
			return getMD5(target, "US-ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new PoswebErrorException();
		}
	}
	
	public static final String getSHA1(String target){
		try {
			return getSHA1(target, "US-ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new PoswebErrorException();
		}
	}

	public static String getMD5(String target, String charsetName)
			throws UnsupportedEncodingException {
		try {
			final byte[] md5 = MessageDigest.getInstance("MD5").digest(
					target.getBytes(charsetName));
			final char[] md5Chars = new char[32];
			int i = 0;
			for (final byte b : md5) {
				md5Chars[i++] = HEX[(b >> 4) & 0xF];
				md5Chars[i++] = HEX[b & 0xF];
			}
			return new String(md5Chars);
		} catch (NoSuchAlgorithmException nsae) {
			throw new RuntimeException();
		}
	}
	
	 public static String getSHA1(String target, String charsetName)
	            throws UnsupportedEncodingException {
	        try {
	        	byte[] sha1=MessageDigest.getInstance("SHA1").digest(
	                    target.getBytes(charsetName));
	            return Base64.encodeBase64String(sha1);
	        } catch (NoSuchAlgorithmException nsae) {
	            throw new RuntimeException();
	        }
	    }
}
