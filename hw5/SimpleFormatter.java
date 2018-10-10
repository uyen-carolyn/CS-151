/**
 * A simple invoice formatter.
 */
public class SimpleFormatter implements InvoiceFormatter {
	public String formatHeader() {
		total = 0;
		return "     I N V O I C E\n\n\n";
	}

	/**
	 * Edit: altered the method to display how much of the item is bought 
	 * and the new calculated score. 
	 */
	public String formatLineItem(LineItem item) {
		total += item.getPrice() * item.getAmount();
		return (String.format("%s: $%.2f 	X %d\n", item.toString(), item.getPrice(), item.getAmount()));
	}

	public String formatFooter() {
		return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
	}

	private double total;
}
