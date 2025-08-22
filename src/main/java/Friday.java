import java.util.Scanner;

public class Friday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nHello! I'm Friday"); //Message sent when the bot is activated
        System.out.println("What can I do for you?");

        //to keep the system running
        while (true) {
            String input = sc.nextLine();

            if(input.equals("bye")) {
                System.out.println("\n  Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println("\n  " + input + "\n");
            }
        }

    }
}
