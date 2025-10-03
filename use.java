import javax.swing.JOptionPane;

public class use {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "Result: \n";

        strNum1 = JOptionPane.showInputDialog(null,
            "Please input the first number: ","Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null,
            "Please input the second number: ","Input the second number",
            JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        strNotification += "Sum: " + (num1 + num2) +
                           "\nDiff: " + Math.abs(num1 - num2);

        if (num2 == 0) {
            strNotification += "\nProduct: " + (num1 * num2) +
                               "\nQuotient: undefined (division by zero)";
        } else {
            strNotification += "\nProduct: " + (num1 * num2) +
                               "\nQuotient: " + (num1 / num2);
        }

        JOptionPane.showMessageDialog(null, strNotification,
            "Show results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
