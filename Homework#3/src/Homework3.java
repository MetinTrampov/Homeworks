import java.util.Scanner;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String objectives = scanner.nextLine();
        String command ;
        switch (objectives) {
            case "chair":
                command = "Jump";
                break;
            case "wall":
                command = "Go Sideway";

                break;
            default:
                command = "Forward";
                break;

        }
        System.out.println(command);
    }
}
