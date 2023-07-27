package Extraa;

public abstract class Ab {
   protected abstract void doIt();
  static void high(){
      System.out.println(Long.MAX_VALUE);
      System.out.println(Long.MIN_VALUE);
      String s = Long.toString(Long.MAX_VALUE);
      System.out.println(s.length());
      String x = Integer.toString(Integer.MAX_VALUE);
      System.out.println(x.length());
   }

   public static void main(String[] args) {
      high();
   }
}
