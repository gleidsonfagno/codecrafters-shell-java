
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] commands = {"exit", "ls", "cd", "rm", "touch", "type", "echo", "pwd", "clear", "help"};
        String pathCommands = System.getenv("PATH");
        String[] pathDirs = pathCommands.split(File.pathSeparator);

        do {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.startsWith("type ")) {

                String commandToCheck = input.substring(5).trim();
                boolean found = false;

                // Check if it's a shell builtin
                for (String command : commands) {
                    if (commandToCheck.equalsIgnoreCase(command)) {
                        System.out.println(command + " is a shell builtin");
                        found = true;
                        break;
                    }
                }
                // If not a builtin, check if it's an executable in the PATH
                if (!found) {
                    for (String pathDir : pathDirs) {
                        File file = new File(pathDir, commandToCheck);
                        if (file.exists() && file.canExecute()) {
                            System.out.println(commandToCheck + " is " + file.getAbsolutePath());
                            found = true;
                            break;
                        }
                    }
                }
                // If still not found, print not found message
                if (!found) {
                    System.out.println(commandToCheck + ": not found");
                }

            } else if (input.startsWith("echo ")) {
                commandEcho(input);
            } else if (input.equalsIgnoreCase("help")) {
                System.out.println("Available commands: " + String.join(", ", commands));
            } else {
                System.out.println(input + ": command not found");
            }
        } while (true);
    }

    public static void commandEcho(String input) {
        System.out.println(input.substring(5));
    }
}
