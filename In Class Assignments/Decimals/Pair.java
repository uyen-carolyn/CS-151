import java.math.BigDecimal;
import java.util.AbstractList;

public class Pair<T>
{
   public Pair() { first = null; second = null; }
   public Pair(T first, T second) { this.first = first;  this.second = second; }

   public T get(int n) { return n == 0 ? first : n == 1 ? second : null; }

   public void set(int n, T t) 
   {
      if (n == 0) first = t;
      else if (n == 1) second = t; 
   }
   
   public void copyFrom(Pair<? extends T> t) {
	   t.set(0, t.first);
	   t.set(1, t.second);
   }
   

   private T first;
   private T second;
}
