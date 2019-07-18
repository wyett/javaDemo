// thinkinjavaex/chapter14/Ex3.java

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


public class Ex3 {
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
            new Circle(), new Square(), new Triangle());
        for(Shape s: shapeList)
            s.drow();
        Rhomboid shape = new Rhomboid();
        ((Shape)shape).drow();
        // Rhomboid cannot be cast to Circle
        // ((Circle)shape).drow();
    }
}
