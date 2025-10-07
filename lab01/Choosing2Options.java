package lab01;
import javax.swing.JOptionPane;

public class Choosing2Options {
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(
                null,
                "Do you want to change to the first class ticket?",
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        if (option == JOptionPane.YES_OPTION) {JOptionPane.showMessageDialog(null, "You've chosen: Yes");
        } else if (option == JOptionPane.NO_OPTION) {JOptionPane.showMessageDialog(null, "You've chosen: No");
        } else JOptionPane.showMessageDialog(null, "You haven't chosen yet.");
                
        System.exit(0);
    }
}
