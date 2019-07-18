// thinkinjavaex/chapter14/Ex6.java

import java.util.*;

abstract class Shape{
    void drow() { System.out.println(this + ".drow()"); }
    abstract public String toString();
}

class Circle extends Shape {
    boolean flag = false;
    public String toString() { 
        return (flag ? "H" : "Unh") + "ighlighted " + "Circle";
    }
}

class Square extends Shape {
    boolean flag = false;
    public String toString() { 
        return (flag ? "H" : "Unh") + "ighlighted " + "Square";
    }
}

class Triangle extends Shape {
    boolean flag = false;
    public String toString() { 
        return (flag ? "H" : "Unh") + "ighlighted " + "Triangle";
    }
}

public class Ex6 {
    public static void setFlag(Shape s) {
        if(s instanceof Triangle)
            ((Triangle)s).flag = true; 
    }            
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
            new Circle(), new Square(), new Triangle());
        for(Shape s: shapeList){
            // s.drow();
            setFlag(s);
            System.out.println(s);
        }
        // Rhomboid cannot be cast to Circle
        // ((Circle)shape).drow();
    }
}
