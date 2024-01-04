package complexObjects.ballGame;
public class Box {
    private int size;
    private boolean isOpen;
    private Ball ball;
    public Box(int size){
        this.size = size;
        ball = new Ball(size);
    }
    public void open(){
        if (isOpen == false){
            isOpen = true;
        }
        System.out.println("You've opened the door");
    }
    public void close(){
        if (isOpen == true){
            isOpen = false;
        }
        System.out.println("You've closed the door");
    }
    public void putBallInsideTheBox(Ball ball){
        if (isOpen == true && this.ball == null){
                if (ball.getSize() == size){
                    this.ball = ball;
                    System.out.println("You've successfully put a ball inside the box");
                } else {
                    System.out.println("You ball size is bigger than a box size");
                }
        } else if (isOpen != true) {
            System.out.println("You have to open the door first");
        } else {
            System.out.println("There is a ball inside");
        }

    }

    public Ball pressButton(){
        if (isOpen == false && ball != null){
            Ball ballCopy = ball;
            ball = null;
            isOpen = true;
            System.out.println("The ball jumped out of the box");
            return ballCopy;
        } else if (ball == null){
            System.out.println("There is no ball inside the box");
        } else {
            System.out.println("The door is opened");
        }
        return null;
    }
}
