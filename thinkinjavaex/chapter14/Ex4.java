// thinkinjavaex/chapter14/Ex4.java

import java.util.*;

abstract class Shape{
    void drow() { System.out.println(this + ".drow()"); }
    abstract public String toString();
}

class Circle extends Shape {
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
    public String toString() { return "Rhomboid"; }
}


public class Ex4 {
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
            new Circle(), new Square(), new Triangle());
        for(Shape s: shapeList)
            s.drow();
        Rhomboid shape = new Rhomboid();
        Shape s = (Shape)shape;
        s.drow();
        if(s instanceof Circle)
            ((Circle)s).drow();
        else if(!(s instanceof Circle))
            System.out.println("Rhomboid cannot converse to Circle");
        //Rhomboid cannot be cast to Circle
        // ((Circle)shape).drow();
    }
}
