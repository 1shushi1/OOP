package anonymousClasses.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Eating eat = new Eating();
        eat.execute();
        Action drinkVodka = new Action(){
            @Override
            public void execute(){
                System.out.println("Drinking vodka");
            }
        };
        drinkVodka.execute();
        AbsAction walking = new AbsAction() {
            @Override
            public void execute() {
                System.out.println("Walking");
            }
        };
        walking.execute();
        Eating eating = new Eating(){
        };
       new SimpleClass(){
          @Override
          public void run(){
              System.out.println("Running");
          }
          public void stopForRest(){
              System.out.println("Resting");
          }
        }.stopForRest();
       SecondAction secondAction = new SecondAction() {
           @Override
           public double execute(int first, int second) {
               return (first + second)/2.0;
           }
       };
        double avg = secondAction.execute(7,10);
        System.out.println(avg);
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button1 = new JButton("RED");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.RED);
            }
        });
        JButton button2 = new JButton("BLUE");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });
        frame.add(panel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, "This is an example string.",
                "For example, consider the following.",
                "In this example, we'll explore various possibilities.",
                "Here's another illustrative example.",
                "You can use this as a template, for example.",
                "Let me provide you with an example scenario.",
                "An excellent example showcases the concept clearly.",
                "This serves as a prime example of the topic at hand.",
                "Consider this as a practical example in your study.",
                "In the context of our discussion, here's a relevant example.");
        Collections.sort(words, new SortingByLength());
        System.out.println(words);
        Comparator<String> sortingDESC = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(o1.length(), o2.length());
            }
        };
        Collections.sort(words, sortingDESC);
        System.out.println(words);
        ArrayList<String> letters = new ArrayList<>();
        Collections.addAll(letters, "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                "k",
                "l",
                "m",
                "n",
                "o",
                "p",
                "q",
                "r",
                "s",
                "t",
                "u",
                "v",
                "w",
                "x",
                "y",
                "z");
        Collections.sort(letters, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(letters);
    }
}
