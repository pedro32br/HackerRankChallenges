// An example Java program for demonstrating HashTable and HashMap
import java.util.*;
import java.lang.*;
class Sample
{
    public static void main(String args[])
    {
//hashtable
        Hashtable<Integer,String> hasht=new Hashtable<Integer,String>();
        hasht.put(500,"Abi");
        hasht.put(500,"Ragul");
        hasht.put(501,"Raja");
        hasht.put(502,"Raja");
        System.out.println("******Hash table******");
        for (Map.Entry<Integer, String> mm:hasht.entrySet()) {
            System.out.println(mm.getKey()+" "+mm.getValue());
        }

//----------------hashmap--------------------------------

        HashMap<Integer,String> hashm=new HashMap<Integer,String>();
        hashm.put(500,"Abi");
        hashm.put(500,"Ajith");  //One null value is allowed in HashMap
        hashm.put(501,"Sanjay");
        hashm.put(502,"Sanjay");
        System.out.println("********Hash Map******");
        for (Map.Entry<Integer, String> mm:hashm.entrySet()) {
            System.out.println(mm.getKey()+" "+mm.getValue());
        }
    }
}
