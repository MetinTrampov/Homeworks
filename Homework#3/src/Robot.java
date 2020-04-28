import java.util.Random;
import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int isCharged = 4;
        System.out.println("Enter objective : wall/chair/nothing ");
        String objectives = scanner.nextLine();
        String command = "";
        while (!objectives.equals("End")) {


            switch (objectives) {
                case "chair":
                    command = "Jump";
                    break;
                case "wall":
                    command = "Go Sideway";

                    break;
                case "nothing" :
                    command = "Forward";
                    break;

            }
            System.out.println(command);
            if (command.equals("Forward")) {
                int countOfHitsOnMouse = 0;
                System.out.println("Input pixels: ");
                    int pixels = Integer.parseInt(scanner.nextLine());
                    if (pixels % 2 == 0) {
                        System.out.println("Mouse is found! ...Prepare for battle");
                        if (isCharged != 0) {
                            isCharged--;
                            Random random = new Random();
                            int magicNum;
                            magicNum = random.nextInt(10) + 1;
                            if (magicNum == 5) {
                                System.out.println("Disaster in house");
                            } else {
                                System.out.println("Success attack");
                                countOfHitsOnMouse++;
                            }
                        } else {
                            Random random = new Random();
                            int firstNumber;
                            int secondNumber;
                            do {
                                firstNumber = random.nextInt(1000) + 1;
                                secondNumber = random.nextInt(1000) + 1;
                            } while (firstNumber == secondNumber);

                            if(countOfHitsOnMouse>4){
                              System.out.println("Go for charging");
                            }else {
                                System.out.println("Go for next target ");
                            }

                            if (firstNumber > secondNumber) {
                                isCharged=4;
                                System.out.println("Charger have electricity.Charging.....");
                            } else {
                                System.out.println("Socket doesn't have electricity");
                            }
                        }

                    }


            }
            System.out.println("Enter objective : wall/chair/nothing ");
        objectives=scanner.nextLine();
        }
        for (int i = 10; i > 1; i--) {
            if (i % 2 == 0) {
                System.out.println("I am a Robottttt");
                System.out.println("Current number is : " + i);
            }

        }
    }
}
