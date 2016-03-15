import java.util.*;

/**
 * Created by pkura on 2016-03-10.
 */
public class MapDifferences {
    /**
     * Iterable (Collections)
     *  Collection
     *      * List
     *          - ArrayList
     *          - LinkedList
     *      * Queue
     *          - PriorityQueue
     *              : XesLog
     *      * Set
     *          - HashSet
     *              :InitAdds
     *          - LinkedHashSet
     *          - TreeSet
     *
     * Map (Dictionaries)
     *      * HashMap
     *      *
     *      * TreeMap
     *
     *      ->
     *          order diffrence
     *
     *      * Hashtable == ConcurrentHashMap
     */
    public static final String ALLOW_ALL = "ALLOW_ALL";

    public static void main(String[] args) {

        // changebly order
        Map m1 = new HashMap();
        m1.put("map", "HashMap");
        m1.put("schildt", "java2");
        m1.put("mathew", "Hyden");
        m1.put("schildt", "java2s");
        printSet(m1.keySet());
        printCollection(m1.values());

        System.out.println();
        // "natural ordering of the" keys
        //                              compareTo() method
//                                      Comparator
        SortedMap sm = new TreeMap();
        sm.put("map", "TreeMap");
        sm.put("schildt", "java2");
        sm.put("mathew", "Hyden");
        sm.put("schildt", "java2s");
        printSet(sm.keySet());
        printCollection(sm.values());

        System.out.println();
        // order in which the entries were put into the map
        LinkedHashMap lm = new LinkedHashMap();
        lm.put("map", "LinkedHashMap");
        lm.put("schildt", "java2");
        lm.put("mathew", "Hyden");
        lm.put("schildt", "java2s");
        printSet(lm.keySet());
        printCollection(lm.values());
    }

    private static void printCollection(Collection c) {
        System.out.println(c);
    }
    private static void printSet(Set set) {
        System.out.println(set);
    }
}
