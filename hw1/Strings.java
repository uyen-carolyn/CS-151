import java.util.ArrayList;

public class Strings {

	public static String uniqueLetters(String str) {
		String[] word = str.split("");

		ArrayList<String> unique = new ArrayList<>();

		int repeat = 0; // count how many times the letter is seen

		for (int i = 0; i < word.length; i++) {

			for (int j = 0; j < word.length; j++) {
				if (word[i].equals(word[j])) {
					repeat++;
				}
			}

			if (repeat == 1) { // only repeat is itself
				unique.add(word[i]);
			}

			repeat = 0; // resets for the next letter
		}

		String letters = "";

		for (int i = 0; i < unique.size(); i++) {
			letters = letters + unique.get(i);
		}

		return letters;
	}
}
