package br.cad.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

public class Util {

	public static String gerarMD5(String texto) {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
		sen = hash.toString(16);
		return sen;
	}
	
	public static Date getDate(int dia, int mes, int ano) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.YEAR, ano);
		return c.getTime();
	}
	
	public static void main(String args[]) {
		System.out.println(gerarMD5("_mm2010_"));
	}
}
