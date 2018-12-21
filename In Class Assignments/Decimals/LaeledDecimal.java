import java.math.*;
public class LabeledDecimal extends BigDecimal
{
   public LabeledDecimal(String label, String digits)
   {
      super(digits);
      this.label = label;
   }

   public String getLabel() { return label; }
   public String toString() { return label + "=" + super.toString(); }

   private String label;
   
   public static void main(String[] args) {
	   Pair<BigDecimal> p1 = new Pair<BigDecimal>();
	   LabeledDecimal ld1 = new LabeledDecimal("pi", "3.14");
	   LabeledDecimal ld2 = new LabeledDecimal("sqrt(2)", "1.414");
	   Pair<LabeledDecimal> p2 = new Pair<LabeledDecimal>(ld1, ld2);
	   p1.copyFrom(p2);
	   System.out.println(p1);
   }
   
}
