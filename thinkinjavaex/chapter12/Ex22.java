// thinkinjavaex/chapter12/Ex22.java

public class Ex22{
    public static void main(String[] args){
        try{
            FailingConstructor fc = new FailingConstructor();
            try{
                //
            }catch(Exception e){
                System.out.println(e);
            }finally{
                fc.dispose();
            }
        }catch(ConstructorFailException e){
            System.out.println(e);
        }
    }
}