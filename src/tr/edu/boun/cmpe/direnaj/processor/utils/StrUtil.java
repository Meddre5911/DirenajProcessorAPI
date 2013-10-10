package tr.edu.boun.cmpe.direnaj.processor.utils;

public class StrUtil {
	
	public static boolean isNumeric(String str)	{
		  return str.matches("-?\\d+(.\\d+)?");
	}
	
	public static String removeNonAlphanumeric(String str) {
		str = str.replaceAll("-", " ");
		return str.replaceAll("[^A-Za-z0-9 ğüşiöç�?Ü�?İÖÇ]", ""); // !isNumeric(str) && StringUtils.isAlphanumericSpace(str);
	}

	/**
	 * Preventing construction
	 */
	private StrUtil () {
		throw new AssertionError();
	}
	
}
