/**
 * Created by pkura on 2016-03-10.
 */
public class JustInTime {
    // JIT
//        -> optimizes code
//    java code -> highly optimized machine code  for a specific platform
//

//    JIT compiler overview - IBM
//        program has started => JIT compiler
//                                  => on the fly -> compile => faster code = CPU's native instruction
//                                  => dynamic runtime information
//
//    Standard compiler
//    ! dynamic runtime information
//    before run =>
//    java.java => emerging as binary code on a microchip
//    javap -s
    static class A {
        B b = new B();
        public void newMethod() {
            b.value =1;
            int y = b.get();
//          ...do stuff...
            int z = b.get();
            int sum = y + z;
        }
        /**
         public void newMethod() {
            y = b.value;  <- inlining functions
            ...do stuff...
            sum = y + y;
         }
         */
    }
    static class B {
        int value;
        final int get() {
            return value;
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.newMethod();

    }
}
