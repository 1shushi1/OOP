package complexObjects.ballGame;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(10);
        Ball ball = new Ball(11);
        box.open();
        box.close();
        Ball ball1 = box.pressButton();
        box.putBallInsideTheBox(ball);
        box.pressButton();
        box.putBallInsideTheBox(ball1);
    }

}
