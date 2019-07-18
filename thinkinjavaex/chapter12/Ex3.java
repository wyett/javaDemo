// thinkinjava/chapter12/Ex3.java

public class Ex3 {
    public static void main(String[] args){
        Integer[] is = new Integer[10];
        try {
            for(int i=0; i<13; i++){
                System.out.println(i);
                is[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}