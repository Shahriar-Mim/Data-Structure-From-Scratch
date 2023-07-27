package map;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * read the hashCode method() and For Loop for printing pair;
 */
public class HashMapShikhi {
    public static void main(String[] args) {
        HashMap<Student,String> hashMap = new HashMap<>();
        Student s1 = new Student(1,"Akash");
        s1.setAttribute("Chagol");
        Student s2 = new Student(1,"Akash");
        s2.setAttribute("Chagol 2");
        Student s3 = new Student(5,"Batash");;
        s3.setAttribute("Goru");
        hashMap.put(s1,s1.getAttribute());
        hashMap.put(s2,s2.getAttribute()); // student roll 1 got updated attribute from s2 since the key is same
        hashMap.put(s3,s3.getAttribute());
        //System.out.println(hashMap+"\n"+hashMap.size());
        for(Map.Entry<Student,String> me : hashMap.entrySet()){
            System.out.println(me.getKey()+"       "+me.getValue());
        }

        System.out.println(hashMap.get(s3));
    }

}
class Student{
    private int roll;
    private String name;
    private String attribute;
    public Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }
    @Override
    public boolean equals(Object others){
        Student ob = (Student) others;
        if(this.roll == ob.getRoll()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int s = Objects.hash(roll); //--------> Remember
        System.out.println("I am at hashCode() "+s);
        return s;
//        System.out.println(roll);
//        return roll;
    }


    public void setAttribute(String s){
        attribute = s;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getAttribute(){
        return attribute;
    }
    @Override
    public String toString(){
        return name+"  "+roll+"  ";
    }
}
