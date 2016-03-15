import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pkura on 2016-03-10.
 */
public class ArrayLinkedDiffList {
    static List<String> array = new ArrayList<String>();
    static List<String> list = new LinkedList<String>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            array.add(""+i);
            list.add(""+i);
        }
        // ------------ Search (get method) -------------
        //ArrayList maintains index system = array data structure
        //  => faster for searching
        System.out.println("Search ArrayList  O(1)");
        TakeTime(() -> array.get(500000));

        //LinkedList linked nodes
        //  +> equires the traversal through all the elements for searching an element
        System.out.println("Search LinkedList O(n)");
        TakeTime(() -> list.get(500000));

        //worst case first element
        //best case last element
        // shifted
        System.out.println("Deletion ArrayList  O(n)");
        TakeTime(() -> array.remove(0));
        // change two pinters:  -> * <-
        System.out.println("Deletion LinkedList O(1)");
        TakeTime(() -> array.remove(0));


//        Memory Overhead
//          ArrayList: {indexes,ele}
//          LinkdedList: {2 pointers,ele}

//          insertion order


//        guicksort is imp:
//              -> arraylist
//                -> linkedlist
    }

    private static void TakeTime(Functor functor) {
        long time1 = System.nanoTime();
        functor.apply();
        long time2 = System.nanoTime();
        long timeTaken = time2 - time1;
        System.out.println("Time taken : " + timeTaken + " ns");
        System.out.println();
    }
}
