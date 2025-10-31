package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class SolveEquation {
    public static void main(String[] args) {
        while (true) {
            String[] options = {
                "Solve linear equation (1 variable)",
                "Solve system of 2 linear equations (2 variables)",
                "Solve quadratic equation (1 variable)",
                "Exit"
            };

            int choice = JOptionPane.showOptionDialog(
                null,
                "Choose the type of equation you want to solve:",
                "Equation Solver",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice == -1 || choice == 3) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            }

            switch (choice) {
                case 0:
                	JOptionPane.showMessageDialog(null, "Solve Linear equation: ax + b = 0");
                    solveLinearEquationOneVar();
                    break;
                case 1:
                	JOptionPane.showMessageDialog(null, "Solve System of 2 linear equations: a11*x + a12*y = b1   a21*x + a22*y = b2");
                    solveSystemOfTwoLinearEquations();
                    break;
                case 2:
                	JOptionPane.showMessageDialog(null, "Solve Quadratic Equation: a^2*x + bx + c = 0");
                    solveQuadraticEquation();
                    break;
            }
        }
    }

    private static void solveLinearEquationOneVar() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient b:"));

        if (a == 0) {
            if (b == 0)
                JOptionPane.showMessageDialog(null, "Infinite solutions.");
            else
                JOptionPane.showMessageDialog(null, "No solution.");
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Solution: x = " + x);
        }
    }

    private static void solveSystemOfTwoLinearEquations() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0)
                JOptionPane.showMessageDialog(null, "Infinite solutions.");
            else
                JOptionPane.showMessageDialog(null, "No solution.");
        } else {
            double x = D1 / D;
            double y = D2 / D;
            JOptionPane.showMessageDialog(null, "Solution: x = " + x + ", y = " + y);
        }
    }

    private static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        if (a == 0) {
            if (b == 0)
                JOptionPane.showMessageDialog(null, (c == 0) ? "Infinite solutions." : "No solution.");
            else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "Linear case: x = " + x);
            }
            return;
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0)
            JOptionPane.showMessageDialog(null, "No real solutions.");
        else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Double root: x = " + x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Two distinct roots:\n x₁ = " + x1 + "\n x₂ = " + x2);
        }
    }
}
