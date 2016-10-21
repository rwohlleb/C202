public class Rectangle <T extends Number> {
    T height; T width; public Rectangle (){ height = null; width = null;} public Rectangle(T h, T w){ height = h; width = w;} public T getHeight(){ return height;} public void setHeight(T h){ height = h; } public Number getArea() { return height.doubleValue() * width.doubleValue();}
}