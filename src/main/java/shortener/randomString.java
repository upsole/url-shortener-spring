package shortener;

import java.util.Random;

class randomString {
	public static String generateString(int length) {
    Random rng = new Random();
    String characters = "abcdefghijklmnopqrstuvwxyz";
	char[] text = new char[length];

    for (int i = 0; i < length; i++) {
      text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
	System.out.println("RANDOM STRING CALLED");
    return new String(text);
  }
}
