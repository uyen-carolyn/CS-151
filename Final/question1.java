public class question1 {
	private Object[] a;

    public question1(Object[] a) {
        this.a = a;
    }
    
    public void dumpArray() {
    	for (int i = 0; i < a.length; i++) {
    		if(a[i].getClass() != String.class) {
    			System.out.print(a[i].toString() + " ");
    		}
    		else {
    			System.out.print(a[i] + " ");
    		}
    	}
    }
    public static void main(String[] args) {
    	Object[] test = new Object[] {"a", 4.756, "hello", 77, "opiwaend", "95", 883}; 
    	question1 tester = new question1(test); 
    	tester.dumpArray(); 
    }
}