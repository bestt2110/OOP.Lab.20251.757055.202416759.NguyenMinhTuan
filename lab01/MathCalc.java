package lab01;
import javax.swing.JOptionPane;

public class MathCalc {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "Result:\n";

        // Input first number
        strNum1 = JOptionPane.showInputDialog(null,
            "Please input the first number:", "Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        // Input second number
        strNum2 = JOptionPane.showInputDialog(null,
            "Please input the second number:", "Input the second number",
            JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        // Perform calculations
        strNotification += "Sum: " + (num1 + num2) +
                           "\nDiff: " + Math.abs(num1 - num2);

        if (num2 == 0) {
            strNotification += "\nProduct: " + (num1 * num2) +
                               "\nCan't divide by zero.";
        } else {
            strNotification += "\nProduct: " + (num1 * num2) +
                               "\nQuotient: " + (num1 / num2);
        }

        // Show result
        JOptionPane.showMessageDialog(null, strNotification,
            "Show results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
