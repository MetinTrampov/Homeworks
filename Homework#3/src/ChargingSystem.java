import java.util.Random;
public class ChargingSystem {
    public static void main(String[] args) {

        Random random = new Random();
        int firstNumber ;
        int secondNumber ;
        do {
            firstNumber = random.nextInt(1000) + 1;
            secondNumber = random.nextInt(1000) + 1;
        } while (firstNumber==secondNumber);

        if(firstNumber>secondNumber){
            System.out.println("Charger have electricity.Charging.....");
        }else {
            System.out.println("No more electricity");
        }
    }
}
