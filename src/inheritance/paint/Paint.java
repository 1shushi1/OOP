package inheritance.paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Paint {
    private Color color;
    private Line line;
    private ArrayList<Figure> figures = new ArrayList<>();
    private ArrayList<Figure> selectedFigures = new ArrayList<>();
    private Scanner s = new Scanner(System.in);
    public Paint(){
        this.color = Color.BLACK;
        this.line = Line.MEDIUM;
        menu();
    }
    private void selectFigure(){
        System.out.println("Enter frame coordinates for left (x,y)");
        int leftCoordinateX = s.nextInt();
        int leftCoordinateY = s.nextInt();
        System.out.println("Enter frame coordinate for right (x, y)");
        int rightCoordinateX = s.nextInt();
        int rightCoordinateY = s.nextInt();
        for (Figure figure : figures){
            if (figure.leftPoint.getX() >= leftCoordinateX && figure.rightPoint.getX() <= rightCoordinateX &&
                    figure.leftPoint.getY() >= leftCoordinateY && figure.rightPoint.getY() <= rightCoordinateY) {
                selectedFigures.add(figure);
                System.out.println("Figure was selected");
            }
        }
    }
    private void menu(){
        while(true){
            System.out.println("Enter a number : 1 - Select figure, 2 - draw figure, 3 - change color, 4 - change line size, " +
                    "5 - remove figure, 6 - move figure, 7 - program exit");
            int selection = s.nextInt();
            switch (selection){
                case 1 -> selectFigure();
                case 2 -> drawFigure();
                case 3 -> changeColor();
                case 4 -> changeLineSize();
                case 5 -> removeFigures();
                case 6 -> moveFigure();
                case 7 -> System.exit(0);
            }
        }
    }
    private void drawFigure(){
        System.out.println("Select a figure you would like to draw : " + "\nCircle, rectangle, triangle");
        String figureName = s.next();
        System.out.println("Enter a left point coordinate x and y");
        int leftCoordinateX = s.nextInt();
        int leftCoordinateY = s.nextInt();
        System.out.println("Enter a right point coordinate x and y");
        int rightCoordinateX = s.nextInt();
        int rightCoordinateY = s.nextInt();
        Point leftPoint = new Point(leftCoordinateX, leftCoordinateY);
        Point rightPoint = new Point(rightCoordinateX, rightCoordinateY);
        if (figureName.equalsIgnoreCase("Circle"))
            figures.add(new Circle(leftPoint, rightPoint, line, color));
        if (figureName.equalsIgnoreCase("Rectangle"))
            figures.add(new Rectangle(leftPoint, rightPoint, line, color));
        if (figureName.equalsIgnoreCase("Triangle"))
            figures.add(new Triangle(leftPoint, rightPoint, line, color));
    }
    private void changeColor(){
        System.out.println("Select color to which you would like to change : \n" + Arrays.toString(Color.values()));
        String colorName = s.next();
        color = Color.valueOf(colorName.toUpperCase());
        for (int i = 0; i < selectedFigures.size(); i++) {
            selectedFigures.get(i).changeColor(color);
        }
    }
    private void changeLineSize(){
        System.out.println("Select line size to which you would like to change : \n " + Arrays.toString(Line.values()));
        String lineName = s.next();
        line = Line.valueOf(lineName.toUpperCase());
        for (int i = 0; i < selectedFigures.size() ; i++) {
            selectedFigures.get(i).changeLine(line);
        }
    }
    private void removeFigures(){
        figures.removeAll(selectedFigures);
        selectedFigures.clear();
    }
    private void moveFigure(){
        System.out.println("Enter a coordinate (x, y) where you would like to move you figure");
        int coordinateX = s.nextInt();
        int coordinateY = s.nextInt();
        Point point = new Point(coordinateX, coordinateY);
        for (Figure figure : selectedFigures) {
            figure.move(point);
        }
    }

}
