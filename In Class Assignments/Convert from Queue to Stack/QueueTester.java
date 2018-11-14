public class QueueTester
{
   public static void main(String[] args)
   {
      BoundedQueue<String> q = new BoundedQueue<>(10);

      q.add("Belgium");
      q.add("Italy");
      q.add("France");
      q.remove();
      q.add("Thailand");

      ArrayList<String> a = new ArrayList<>();
      a.addAll(q);
      System.out.println("Result of bulk add: " + a); 
    System.out.println("Minimum: " + Collections.min(q));
   }
}
