/**
   A product with a price and description.
*/
public class Product implements LineItem
{
   /**
      Constructs a product.
      @param description the description
      @param price the price
   */
   public Product(String description, double price)
   {
      this.description = description;
      this.price = price;
      amount = 1; 
   }
   public double getPrice() { return price; }
   public String toString() { return description; }
   public int getAmount() { return amount; }
   public void addAmount() { amount++; }
   private String description;
   private double price;
   private int amount; 
}
