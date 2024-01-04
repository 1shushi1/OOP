package inheritance.paint;

public final class Rectangle extends Figure{
    public Rectangle(Point leftPoint, Point rightPoint, Line lines, Color color){
        super(leftPoint, rightPoint, lines, color);
    }
    @Override
    public void draw(){
        System.out.println("Rectangle on coordinates : " + leftPoint + ", " + rightPoint + "\nWith a color : " + color + ". And line size : " +
                lines);
    }
}
