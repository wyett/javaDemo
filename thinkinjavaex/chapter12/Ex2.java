// thinkinjavaex/chapter12/Ex2.java

public class Ex2 {
    private static Integer i = null;
    public static void main(String[] args){
        try{
            System.out.println(i.toString());
        } catch(NullPointerException e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}