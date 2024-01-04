package inheritance.paint;

public abstract class Figure {
    protected Point leftPoint;
    protected Point rightPoint;
    protected Line lines;
    protected Color color;
    public Figure(Point leftPoint, Point rightPoint, Line lines, Color color){
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
        this.lines = lines;
        this.color = color;
        draw();
    }
    public void changeColor(Color color){
        this.color = color;
        draw();
    }
    public void changeLine(Line lines){
        this.lines = lines;
        draw();
    }
    public abstract void draw();
    public void move(Point point){
        leftPoint = new Point(point.getX() + leftPoint.getX(), point.getY() + leftPoint.getY());
        rightPoint = new Point(point.getX() + rightPoint.getX(), point.getY() + rightPoint.getY());
        draw();
    }
}
