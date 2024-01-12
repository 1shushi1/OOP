package anonymousClasses.task1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MacroCommand macroCommand1 = new MacroCommand() {
            private ArrayList<Command> commands = new ArrayList<>();
            @Override
            public void addCommand(Command command) {
                commands.add(command);
            }

            @Override
            public void execute() {
                for(Command command : commands){
                    command.execute();
                }
            }
        };
        MacroCommand macroCommand2 = new MacroCommand() {
            private ArrayList<Command> commands = new ArrayList<>();

            @Override
            public void addCommand(Command command) {
                commands.add(command);
            }

            @Override
            public void execute() {
                for (Command command : commands){
                    command.execute();
                }
            }
        };

        Command command1 = new Command() {
            @Override
            public void execute() {
                System.out.println("Sit");
            }
        };
        Command command2 = new Command() {
            @Override
            public void execute() {
                System.out.println("Stand up");
            }
        };
        Command command3 = new Command() {
            @Override
            public void execute() {
                System.out.println("Bark");
            }
        };
        Command command4 = new Command() {
            @Override
            public void execute() {
                System.out.println("Lie");
            }
        };
        macroCommand1.addCommand(command1);
        macroCommand1.addCommand(command2);
        macroCommand1.addCommand(macroCommand2);
        macroCommand2.addCommand(command3);
        macroCommand2.addCommand(command4);
        macroCommand1.execute();
    }
}
