import java.util.Random;
import java.util.Scanner;

public class AttackingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int countOfHitsOnMouse = 0;
        boolean isCharged = true;
        while (countOfHitsOnMouse<5) {
            int pixels = Integer.parseInt(scanner.nextLine());
            if (pixels % 2 == 0) {
                System.out.println("Mouse is found! ...Prepare for battle");
                if(isCharged){
                    Random random = new Random();
                    int magicNum ;
                        magicNum = random.nextInt(10)+1;
                    if(magicNum==5){
                        System.out.println("Disaster in house");
                    }else {
                        System.out.println("Success attack");
                        countOfHitsOnMouse ++;
                    }
                }
            }

        }
        if(countOfHitsOnMouse<5){
            System.out.println("Go for next target ");
        }else {
            System.out.println("Go for charging");
        }

    }
}
