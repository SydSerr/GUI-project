import javax.swing.*;

public class GuiProject extends JFrame {

    public GuiProject() {
        // Set the title of the form
        setTitle("Athlete Data App");

        // Set the size of the form
        setSize(800, 600);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();

        // Add the panel to the frame
        add(panel);

        // Set the form visible
        setVisible(true);

    }

    public static void main(String[] args) {
        // Create an instance of the BlankForm class
        new GuiProject();
    }
}
