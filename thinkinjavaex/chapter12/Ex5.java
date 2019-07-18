// thinkinjavaex/chapter12/Ex5.java

public class Ex5 {
    private static Integer[] arr = new Integer[2];
    public static void main(String[] args){
        int x = 5;
        while(true){
            try{
                arr[x] = 1;
                System.out.println(arr[x]);
                break;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                e.printStackTrace();
                x--;
            }finally{
                System.out.println("aaa");
            }
        }
    }
}