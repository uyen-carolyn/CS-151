import java.util.*;

public class Encoding {

	public static Set<String> morseCodes(int m, int n) {
		Set<String> result = new TreeSet<>();

		String dots = "";
		String dashes = "";

		for (int i = 0; i < m; i++) {
			dots = dots + ".";
		}
		for (int j = 0; j < n; j++) {
			dashes = dashes + "-";
		}

		String morse = dots + dashes; // creates string out of given dots and dashes to be used

		permute(result, morse, 0, morse.length() - 1); // created new method to create recursion

		return result;
	}

	private static void permute(Set<String> r, String p, int indexL, int indexR) {
		if (indexL == indexR) {
			return; // stops recursion when it reaches the last index
		}
		else {
			char[] swap = p.toCharArray();

			for (int i = indexL; i <= indexR; i++) {
				char temp = swap[i]; // swaps indices and records them into TreeSet
				swap[i] = swap[indexL];
				swap[indexL] = temp;
				p = new String(swap);

				r.add(p);

				permute(r, p, indexL + 1, indexR); // recursion
			}
		}
	}
}