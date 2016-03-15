import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pkura on 2016-03-10.
 */
public class CollectDifferences {
/**
 * Array
 *
 * Iterable (Collections)
 *  Collection
 *      * List
 *          - ArrayList
 *              : API Rest
 *          - LinkedList
 *      * Queue
 *          - PriorityQueue
 *              : XesLog
 *      * Set
 *          - HashSet
 *              :InitAdds
 *          - LinkedHashSet
 *          - TreeSet
 */
    public static void main(String[] args) {
        String [] array = new String[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = "" +i;
        }
        List list = new ArrayList<String>();
        list = Arrays.asList(array);

        long time1 = System.nanoTime();
        String s = array[10];
        long time2 = System.nanoTime();
        long timeTaken = time2 - time1;
        //array: 466 ns
        System.out.println("Time taken for array: " + timeTaken + " ns");

        time1 = System.nanoTime();
        list.get(10);
        time2 = System.nanoTime();
        timeTaken = time2 - time1;
        //list: 28924 ns
        System.out.println("Time taken for list: " + timeTaken + " ns");
    }
}
