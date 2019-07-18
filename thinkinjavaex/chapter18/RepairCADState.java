// thinkinjavaex/chapter18/RepairCADState.java
import java.io.*;
import java.util.*;

abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random();
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();
    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }
    public String toString() {
        return getClass() + 
            "color[" + getColor() + "] xPos[" + xPos +
            "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }
    public static Shape randomFactory(){
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch(counter++ % 3) {
            default:
            case 0: return new Circle(xVal, yVal, dim);
            case 1: return new Square(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }            
}

class Circle extends Shape {
    private static int color;
    public static void
    serializeStaticState(ObjectOutputStream os)
    throws IOException { os.writeInt(color); }
    public static void
    deserializeStaticState(ObjectInputStream os)
    throws IOException { os.readInt(); }
    public Circle(int xVal, int yVal, int dim){
        super(xVal, yVal, dim);
    }
    public void setColor(int newColor) { color = newColor; }
    public int getColor() { return color; }
}

class Square extends Shape {
    private static int color;
    public static void
    serializeStaticState(ObjectOutputStream os)
    throws IOException { os.writeInt(color); }
    public static void
    deserializeStaticState(ObjectInputStream os)
    throws IOException { os.readInt(); }
    public Square(int xVal, int yVal, int dim){
        super(xVal, yVal, dim);
    }
    public void setColor(int newColor) { color = newColor; }
    public int getColor() { return color; }
}


class Line extends Shape {
    private static int color;
    public static void
    serializeStaticState(ObjectOutputStream os)
    throws IOException { os.writeInt(color); }
    public static void
    deserializeStaticState(ObjectInputStream os)
    throws IOException { os.readInt(); }
    public Line(int xVal, int yVal, int dim){
        super(xVal, yVal, dim);
    }
    public void setColor(int newColor) { color = newColor; }
    public int getColor() { return color; }
}

public class RepairCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        List<Shape> shapes = new ArrayList<Shape>();
        // make some shapes;
        for(int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());
        // set all the static colors to GREEN
        for(int i = 0; i < 10; i++)
            ((Shape)shapes.get(i)).setColor(Shape.GREEN);
        // save the state vector
        ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream("CADState.out"));
        Circle.serializeStaticState(out);
        Square.serializeStaticState(out);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        // display the shapes
        System.out.println(shapes);
        // now read the file back in:
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("CADState.out"));
        // read in the same order they were writtern
        Circle.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        Line.deserializeStaticState(in);
        shapes = (List<Shape>)in.readObject();
        System.out.println(shapes);
    }
}






