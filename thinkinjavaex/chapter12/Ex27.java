// thinkinjavaex/chapter12/Ex27.java

// public class Ex27{
    // private static Integer[] ia = new Integer[2];
    // private static int i = 3;
    // public static void main(String[] args){
        // try{
            // ia[3] = i;
        // }catch(ArrayIndexOutOfBoundsException e){
            // throw new ArrayIndexOutOfBoundsException();
        // }
    // }
// }

class MyRuntimeException extends RuntimeException{
    void myThrowRuntimeException(){
        throw new MyRuntimeException();
    }
}

public class Ex27{
    private static Integer[] ia = new Integer[2];
    private static int i = 3;
    public static void main(String[] args){
        try{
            ia[3] = i;
        }catch(Exception e){
            throw new MyRuntimeException();
        }
    }
}