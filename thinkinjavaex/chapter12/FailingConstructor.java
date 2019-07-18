// thinkinjavaex/chapter12/FailingConstructor.java

class ConstructorFailException extends Exception{}

public class FailingConstructor{
    public FailingConstructor() throws ConstructorFailException{
        throw new ConstructorFailException();
    }
    public void dispose(){
        System.out.println("FailingConstructor dispose()");
    }
}