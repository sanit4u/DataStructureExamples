package ShortenUrl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ShortenUrl {
	static Map<String, Long> url2Index = new HashMap<String, Long>();
	static Map<Long, String> index2Url = new HashMap<Long, String>();
	static long counter = 1L;
	final static String DOMAIN = "www.s-url/";
	final static String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		String longUrl = "http://cloud.smile-h2020.eu:9092/EnrollmentService/webresources/smilebk/users/getUsers";
		final String shortUrl = base62Encode(longUrl);
		System.out.println(shortUrl);
		final String longUrlGot = base62Decode(shortUrl);

		if (longUrl.equals(longUrlGot)) {
			System.out.println("true");
		}

		String longUrl2 = "http://cloud.smile-h2020.eu:9092/EnrollmentService/webresources/smilebk/users/getUserss";
		final String shortUrl2 = base62Encode(longUrl2);
		System.out.println(shortUrl2);

		final String longUrlGot2 = base62Decode(shortUrl2);

		if (longUrl2.equals(longUrlGot2)) {
			System.out.println("true");
		}

		String longUrl3 = "http://cloud.smile-h2020.eu:9092/EnrollmentService/webresources/smilebk/users/getUsersdsds";
		final String short34Url = base62Encode(longUrl3);
		System.out.println(short34Url);

		final String longUr32lGot = base62Decode(short34Url);

		if (longUrl3.equals(longUr32lGot)) {
			System.out.println("true");
		}

	}

	private static String base62Decode(String shortUrl) {

		return decode(shortUrl);
	}

	private static String base62Encode(String longUrl) {

		if (!url2Index.containsKey(longUrl)) {

			index2Url.put(counter, longUrl);
			url2Index.put(longUrl, counter);
			counter++;
			return DOMAIN + encode(url2Index.get(longUrl));
		} else {

			return DOMAIN + encode(url2Index.get(longUrl));
		}

	}

	private static String encode(Long counterIndex) {
		StringBuilder sb = new StringBuilder();
		while (counterIndex != 0) {
			int big = (int) (counterIndex % 62);
			sb.append(BASE62.charAt(big));
			counterIndex /= 62;
		}

		return sb.toString();
	}

	// Decodes a shortened URL to its original URL.
	public static String decode(String shortUrl) {
		String base62Encoded = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
		long decode = 0;
		for (int i = 0; i < base62Encoded.length(); i++) {
			decode = decode * 62 + BASE62.indexOf("" + base62Encoded.charAt(i));
		}
		return index2Url.get(decode);
	}
}
