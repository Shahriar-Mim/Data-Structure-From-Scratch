public class Testing {

    public static void main(String[] args) {
        Testing t = new Testing();
         InnerClass t2 = new InnerClass();
        doIt(2147483647);
     }
     static void doIt(int x){
         System.out.println(x);
     }
   static class InnerClass{

   }

}
