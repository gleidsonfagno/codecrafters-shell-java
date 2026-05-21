
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        String[] commands = {"ls", "cd", "mkdir", "rm", "touch", "cat", "echo", "pwd", "clear", "help"};

        do {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            System.out.println(input + ": command not found");
            for (String command : commands) {
                if (input.startsWith(command)){
                    System.out.println(input.substring(5));
                }
                
            }
        }
        while (true);
    }
}
