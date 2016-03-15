/**
 * Created by pkura on 2016-03-10.
 */
public class ArrayThink {
    public static void main(String[] args) {
        // complier-checked type safety
        // runtime
        //            => arrays are “covariant”
        //            =>  if T < S ==> T[] < S[]
        /**
         * Number
         *  * Integer
         *  * Long
         *  * Long
         */
        Number[] numbers = new Integer[10];
        //Arrays are not typesafe
        //  type info in runtime
//      numbers[0] = Long.valueOf( 0 ); // throws ArrayStoreException
        //            =>  if Integer < Number ==> Integer[] < Number[]
        // generic and array

        Box<Number>[] boxes = new BoxR[10];

        boxes[0] = new Box<Number>();
        boxes[0].add(Long.valueOf(1));

        boxes[1] = new Box<Number>();
        boxes[1].add(Integer.valueOf(11));
    }

    public static class Box<T> {

        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }

    public static class BoxR<T> extends Box<T>{

        private T t;

        @Override
        public void add(T t) {
            this.t = t;
        }

        @Override
        public T get() {
            return t;
        }
    }
}
