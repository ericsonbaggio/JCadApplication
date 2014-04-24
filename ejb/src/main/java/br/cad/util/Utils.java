package br.cad.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlcleaner.HtmlCleaner;

import br.cad.model.Model;

public class Utils {
	public Utils() {

	}

	// Passado uma string e o tamanho para completar com zeros a esquerda
	public String zeroEsquerda(String s1, int tamString) {
		while (s1.length() < tamString) {
			s1 = "0" + s1;
		}
		return s1;
	}

	// Passado uma string e um caracter elimina este da string
	public String delCaracter(String s1, String c1) {
		if (s1.indexOf(c1) != -1) {
			s1 = s1.substring(0, s1.indexOf(c1)) + s1.substring(s1.indexOf(c1) + 1);
		}
		return s1;
	}

	// Passado uma data, retorna esta no formato juliano
	@SuppressWarnings({ "deprecation", })
	public String dataJuliana(Date d1) {
		int anoCorrente;

		anoCorrente = d1.getYear();
		Timestamp dataInicioAno = new Timestamp(d1.getYear(), 00, 01, 0, 0, 0, 0); // 01/01/ano vencimento

		return zeroEsquerda(Long.toString(DateDiffUtil.dateDiff(dataInicioAno, d1, DateDiffUtil.Units.DAY) + 1), 3) + Integer.toString(anoCorrente + 1900).substring(3, 4);
	}

	public static String capFirst(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String uncapFirst(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static String getGetterMethodName(String property) {
		return "get" + capFirst(property);
	}

	public static String getGetterIsMethodName(String property) {
		return "is" + capFirst(property);
	}

	public static String getSetterMethodName(String property) {
		return "set" + capFirst(property);
	}

	public static <MODEL extends Model> boolean listContains(List<MODEL> list, MODEL obj) {
		for (MODEL model : list) {
			if (model.equals(obj))
				return true;
		}
		return false;
	}
	
	public static <T> boolean listContains(List<T> list, T obj) {
		for (T model : list) {
			if (model.equals(obj))
				return true;
		}
		return false;
	}
	

	/**
	 * Verifica se a string esta nula ou vazia
	 * 
	 * @param str
	 * string a ser verificada
	 * @return true caso a string seja nula ou vazia, ou possua somente espacos em branco
	 */
	public static boolean emptyString(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * Transforma um String em Inteiro<br>
	 * Caso a String nao seja um Inteiro valido, retorna 0
	 * 
	 * @param str
	 * String a ser transformada
	 * @return o Inteiro correspondente e String
	 */
	public static int toInteger(String str) {
		return toInteger(str, 0);
	}
	
	/**
	 * Tenta transformar um obj em inteiro, caso nao consiga retorna null
	 * @param obj
	 * @return
	 */
	public static Integer toIntegerFromObj(Object obj) {
		try{
				return obj!=null ? new Integer(obj.toString()) : null;
		}catch(Exception e){}
		return null;
	}

	/**
	 * Transforma um objeto em String<br>
	 * Caso obj seja nulo retorna nulo.
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		return obj != null ? obj.toString() : null;
	}

	/**
	 * Transforma um String em Inteiro<br>
	 * Caso a String nao seja um Inteiro valido, retorna o defaultValue
	 * 
	 * @param str
	 * String a ser transformada
	 * @param defaultValue
	 * valor a ser retornado caso a String nao seja um Inteiro valido
	 * @return o Inteiro transformado
	 */
	public static int toInteger(String str, int defaultValue) {
		if (str == null)
			return defaultValue;
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	/**
	 * Verifica se a string e um Integer
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (str == null)
			return false;
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * Verifica se a string e um Long
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isLong(String str) {
		if (str == null)
			return false;
		try {
			Long.parseLong(str);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * Substitui enters no texto pela TAG HTML 'br'
	 * 
	 * @param text
	 * @return
	 */
	public static String replaceNewLinesToHTML(String text) {
		if(text==null)
			return null;
		String saida;
		saida = text.replaceAll("\r\n", "<br/>");
		saida = saida.replaceAll("\n", "<br/>");
		return saida;
	}
	
	/**
	 * Retorna o text plain do HTML informado, limpando as tags HTML
	 * @param html
	 * @return
	 */
	public static String htmlClean(String html) {
		return new HtmlCleaner().clean(html).getText().toString();
	}

	@SafeVarargs
	public static <OBJECT> boolean notIn(OBJECT obj, OBJECT... values) {
		if (obj == null || values == null)
			return false;
		for (OBJECT value : values) {
			if (obj.equals(value))
				return false;
		}
		return true;
	}

	@SafeVarargs
	public static <OBJECT> boolean in(OBJECT obj, OBJECT... values) {
		if (obj == null || values == null)
			return false;
		for (OBJECT value : values) {
			if (obj.equals(value))
				return true;
		}
		return false;
	}

	/**
	 * Retorna uma instancia java.io.File do arquivo que esta na pasta WEB-INF/classes
	 * 
	 * @param file
	 * caminho relativo � pasta WEB-INF/classes do projeto compilado, ou 'conf' referente ao projeto.
	 * @return
	 */
	public static File getWebClassesFile(String file) throws FileNotFoundException {
		URL url = Utils.class.getClassLoader().getResource(file);
		if (url == null)
			throw new FileNotFoundException("File not found '" + file + "'");
		return new File(url.getFile());
	}

	/** retorna a url para um arquivo que esta na pasta WEB-INF/classes
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static URL getWebClassesURL(String file) throws FileNotFoundException {
		URL url = Utils.class.getClassLoader().getResource(file);
		if (url == null)
			throw new FileNotFoundException("File not found '" + file + "'");
		return url;
	}
	
	public static String getPropertyName(Method method) {
		String name = method.getName();
		if (name.startsWith("get"))
			name = name.replaceFirst("get", "");
		if (name.startsWith("is"))
			name = name.replaceFirst("is", "");
		return Utils.uncapFirst(name);
	}

	public static String generateFilename(String originalFilename) {
		String ext = "";
		if (originalFilename != null) {
			int i = originalFilename.lastIndexOf(".");
			if (i != -1 && i < originalFilename.length()) {
				ext = originalFilename.substring(i);
			}
		}
		return System.nanoTime() + ext;
	}

	public static int randomInt(int ini, int end) {
		return (int) Math.round(Math.random() * (end - ini)) + ini;
	}

	public static String limitaCaracteres(String text, int quantidade) {
		if (quantidade < 1)
			return text;
		int size = text.length();

		if (quantidade >= size)
			return text;

		String tmp = text.substring(quantidade);
		int proximoEspaco = tmp.indexOf(" ");
		if (proximoEspaco != -1) {
			return text.substring(0, Math.min(quantidade + proximoEspaco, size)) + "...";
		} else {
			return text.substring(0, Math.min(quantidade + 15, size)) + "...";
		}
	}

	/**
	 * Retorna uma sub string de tamanho maximo maxlen, dividindo a string original por espacos
	 * 
	 * @param str
	 * @param maxlen
	 * @return
	 */
	public static String subStringWhiteSpaces(String str, int maxLen) {
		if (str == null)
			return null;
		if (maxLen < 1)
			return "";

		int size = str.length();

		if (maxLen >= size)
			return str;

		String ini = str.substring(0, maxLen);
		String end = str.substring(maxLen, str.length());

		if (end.charAt(0) == ' ')
			return ini;

		int whitespace = ini.lastIndexOf(' ');
		if (whitespace == -1)
			return ini;

		return ini.substring(0, whitespace);

	}

	public static <E extends Model> Map<Long, E> getMapFromList(List<E> list) {
		Map<Long, E> map = new HashMap<Long, E>();
		for (E e : list) {
			map.put(e.getId(), e);
		}
		return map;
	}
	
	public static <E> Map<Object, E> getMapFromList(List<E> list, String propertyKey) {
		Map<Object, E> map = new HashMap<Object, E>();
		for (E e : list) {
			Object key = ObjectBinder.getValueObject(propertyKey, e);
			if(key!=null) {
				map.put(key, e);
			}
		}
		return map;
	}	

	private static final DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

	public static String formatDecimal(Double d) {
		return decimalFormat.format(d);
	}

	public static Double parseDecimal(String d) {
		try {
			return decimalFormat.parse(d).doubleValue();
		} catch (Exception e) {
			return 0D;
		}
	}

	public static String ListToString(List<? extends Object> lista) {
		if (lista != null)
			return lista.toString().replaceAll("\\[", "").replaceAll("\\]", "");
		else
			return "";
	}
	
	public static String zeroEsquerda(int x, int casas) {
		if(x < Math.pow(10, casas)) {
			String r = String.valueOf(x);
			for(int i=r.length();i<casas;i++) {
				r="0"+r;
			}
			return r;
		}
		return String.valueOf(x);
	}

	
	public static String toStringFromArray(Object[] array, String separator) {
		if(array==null)
			return null;
		String ret = "";
		
		for(int i=0;i<array.length;i++) {
			Object obj = array[i];
			if(obj!=null)
				ret += obj;
			if(i < array.length -1)
				ret += separator;
		}
		return ret;
	}
	
	public static <E> List<E> setPropertyList(List<E> lista, String prop, Object value){
		for (Object object : lista) {
			ObjectBinder.setValueObject(prop, object, value);
		}
		return lista;
	}
	
	
	private static final String RAND_VAR_CHARS = "abcdefghijlmnopqrstuvxz0123456_ABCDEFGHIJKLMNOPQRSTUVXZ";
	private static final int RAND_VAR_CHARS_LENGTH = RAND_VAR_CHARS.length();
	private static final char RAND_VAR_CHAR_ARRAY[] = RAND_VAR_CHARS.toCharArray();
	
	public static String generateRandomVar(int length) {
		StringBuffer sb = new StringBuffer(length);
		for(int i=0;i<length;i++) {
			int index = Utils.randomInt(0, RAND_VAR_CHARS_LENGTH - 1);
			sb.append(RAND_VAR_CHAR_ARRAY[index]);
		}
		return sb.toString();
	}
	
	public static List<Long> getListIdsFromModel(List<? extends Model> models) {
		if(models!=null) {
			List<Long> ids = new ArrayList<Long>(models.size());
			for(Model model: models) {
				ids.add(model.getId());
			}
			return ids;
		}
		return null;
	}
	
	
	public static String encodeString(String text, String charsetName) {
		if(text!=null) {
			byte bbb[] = text.getBytes();
			
			try {
				return new String(bbb, charsetName);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
			return text;
		}
		return text;
	}
	
	public String convertEncode(String text, String EncodeOrigem, String encodeDestino){
		if(text!=null) {

			try {
				Charset origemCharset = Charset.forName(EncodeOrigem);
				Charset destinoCharset = Charset.forName(encodeDestino);
				
				return new String(destinoCharset.encode(origemCharset.decode(ByteBuffer.wrap(text.getBytes()))).array());
				
			} catch (IllegalCharsetNameException e1) {
				e1.printStackTrace();
			} catch (UnsupportedCharsetException e2) {
					e2.printStackTrace();
			}
		}
		return text;
	}
}
