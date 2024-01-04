package inheritance.paint;

public final class Triangle extends Figure{
    public Triangle(Point leftPoint, Point rightPoint, Line lines, Color color){
        super(leftPoint, rightPoint, lines, color);
        }
    @Override
    public void draw() {
        System.out.println("Circle on coordinates : " + leftPoint + ", " + rightPoint + "\nWith a color : " + color + ". And line size : " +
                lines);
    }
}
