public class HashString {

    public static void main(String[] args) {

        int n = 18;
        String[] ht = new String[n];

        System.out.println("Inserting apple at "  +  hashFunction("apple", ht.length));
        ht[hashFunction("apple", ht.length)] = "apple";
        System.out.println("Inserting bean at "   +  hashFunction("bean", ht.length));
        ht[hashFunction("bean", ht.length)] = "bean";
        System.out.println("Inserting carrot at " +  hashFunction("carrot", ht.length));
        ht[hashFunction("carrot", ht.length)] = "carrot";
        System.out.println("Inserting date at "   +  hashFunction("date", ht.length));
        ht[hashFunction("date", ht.length)] = "date";
        System.out.println("Inserting endive at " + hashFunction("endive", ht.length));
        ht[hashFunction("endive", ht.length)] = "endive";
        System.out.println("Inserting fennel at " + hashFunction("fennel", ht.length));
        ht[hashFunction("fennel", ht.length)] = "fennel";
        System.out.println("Inserting beet at "   + hashFunction("beet", ht.length));
        ht[hashFunction("beet", ht.length)] = "beet";
    }

    public static int hashFunction(String s, int length) {

        return Math.abs(s.hashCode()) % length;  // a hashcode can return a negative number
    }
}