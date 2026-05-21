
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        String[] commands = {"exit", "ls", "cd", "mkdir", "rm", "touch", "type", "echo", "pwd", "clear", "help"};

        do {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("ls")) {
                // Implement ls command
            } else if (input.startsWith("cd ")) {
                // Implement cd command
            } else if (input.startsWith("mkdir ")) {
                // Implement mkdir command
            } else if (input.startsWith("rm ")) {
                // Implement rm command
            } else if (input.startsWith("touch ")) {
                // Implement touch command
            } else if (input.startsWith("type ")) {
                for (String command: commands) {
                    if (input.substring(5).trim().equalsIgnoreCase(command)) {
                        System.out.println(command + " is a shell builtin");
                        break;
                    }else{
                        System.out.println(input.substring(5).trim() + ": not found");
                    }
                }

            } else if (input.startsWith("echo ")) {
                // Implement echo command
                System.out.println(input.substring(5));
                continue;

            } else if (input.equalsIgnoreCase("pwd")) {
                // Implement pwd command
            } else if (input.equalsIgnoreCase("clear")) {
                // Implement clear command
            } else if (input.equalsIgnoreCase("help")) {
                System.out.println("Available commands: " + String.join(", ", commands));
            } else {
               System.out.println(input + ": command not found");
            }

            // System.out.println(input + ": command not found");
        }
        while (true);
    }
}
