import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalcuator {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        DecimalFormat oneDecimal = new DecimalFormat("#.0");

        System.out.println("Enter height:");
        String heightInput = input.nextLine();

        double height;
        while (true) {
            try {
                height = Double.parseDouble(heightInput);
                break;
            } catch (Exception e)  {
                System.out.println("Invalid response. Enter height:");
                input = new Scanner(System.in);
                heightInput = input.nextLine();
            }
        }

        System.out.println("Enter weight:");
        input = new Scanner(System.in);
        String weightInput = input.nextLine();

        double weight;
        while (true) {
            try {
                weight = Double.parseDouble(weightInput);
                break;
            } catch (Exception e)  {
                System.out.println("Invalid response. Enter weight:");
                input = new Scanner(System.in);
                weightInput = input.nextLine();
            }
        }
        double bmi = weight + height;
        System.out.println("BMI is " + oneDecimal.format(bmi) + " kg/m^2");
    }
}
