package Extraa;

public class InverseNumberRecursively {
    public static void main(String[] args) {
        System.out.println(inverseRecursion(123456,0));
        System.out.println(inverseIteratively(123456));
    }
    /* idea is we will generate the calculation in one stack function call
       then we will send that calculation in every other call stacks
       recursion will help us to build the call-stack and send the calculation to upper stacks
     */
    static int inverseRecursion(int n, int calculation){
        if(n != 0){
            calculation = calculation * 10 + (n%10); 
            return  inverseRecursion(n/10, calculation);
        }
        else
            return calculation;
    }


    static int inverseIteratively(int n){
        int calculation = 0;
        while(n!=0){
            calculation = calculation * 10 + (n%10);
            n = n / 10 ;
        }
        return calculation;
    }
}
