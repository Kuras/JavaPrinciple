import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pkura on 2016-03-10.
 */
public class Hash_Equ {
    public static class Point extends AbstracPoint{
        public int x;
        public int y;
        public Point(int x,int y){this.x=x;this.y=y;}

        @Override
        public String toString(){return "(" +this.x+","+this.y+")"+"["+super.toString()+"]";}

        @Override
        public int hashCode(){
            return this.x;
        }
        // annotation override show me my mistake !!!!!
        @Override
        public boolean equals(Object other){
            return this.x == ((Point)other).x && this.y == ((Point)other).y;
        }
    }

    public static class WrongPoint extends AbstracPoint{
        public int x;
        public int y;
        public WrongPoint(int x,int y){this.x=x;this.y=y;}

        @Override
        public String toString(){return "(" +this.x+","+this.y+")"+"["+super.toString()+"]";}

        @Override
        public int hashCode(){
            return this.x+this.y;
        }
        // annotation override show me my mistake !!!!!
        @Override
        public boolean equals(Object other){
            return this.x == ((WrongPoint)other).x;
        }
    }

    public static void main(String []args){
        printaFunctor("Point", () -> point(new Point(1,1),new Point(1,1)));
        printaFunctor("Wrong Point", () -> point(new WrongPoint(1,1),new WrongPoint(1,1)));
        printaFunctor("Wrong Point: obj with the same hashcode and diff eq", () -> point(new WrongPoint(2,3),new WrongPoint(3,2)));
        printaFunctor("Point: like upper but with right impl", () -> point(new Point(2,3),new Point(3,2)));
    }

    private static void printaFunctor(String name, Functor f) {
        System.out.println(name);
        f.apply();
        System.out.println();
    }

    private static void point(AbstracPoint p11,AbstracPoint p22) {
        AbstracPoint p1 = p11;
        AbstracPoint p2 = p22;
        System.out.println("Check eq: " + p1.equals(p2));

        // In the case of HashSet, the item isn't inserted.
        Set<AbstracPoint> set = new HashSet<AbstracPoint>();
        set.add(p1);
        set.add(p2);
        System.out.println("HashSet: "+set);
        System.out.println("Eval size set: "+set.size());

        // In the case of HashMap, it replaces the old value with the new one.
        Map<Integer,AbstracPoint> map = new HashMap<Integer,AbstracPoint>();
        map.put(p1.hashCode(),p1);
        map.put(p2.hashCode(),p2);
        System.out.println("HashMap: "+map);
    }

    private static class AbstracPoint {}
}
