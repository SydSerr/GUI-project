
import javax.swing.*;
import java.awt.*;

public class GuiProject extends JFrame {

    public GuiProject() {
        // Set the title of the form
        setTitle("Athlete Data App");

        // Set the size of the form
        setSize(800, 600);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold components
        JPanel panel = new JPanel(new GridBagLayout());

        //set constraints to start at the top of the
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST; // Align components to the left
        constraints.weightx = 1; // Let components grow horizontally if needed

        // Add the panel to the frame
        add(panel);

        constraints.gridy = 0;
        addComponent(panel, new JLabel("Name:"), 0, constraints);
        addComponent(panel, new JTextField(20), 1, constraints);

        constraints.gridy = 1;
        addComponent(panel, new JLabel("DOB:"), 0, constraints);
        addComponent(panel, new JTextField(20), 1, constraints);

        constraints.gridy = 2;
        addComponent(panel, new JLabel("Height (cm):"), 0, constraints);
        addComponent(panel, new JTextField(20), 1, constraints);

        constraints.gridy = 3;
        addComponent(panel, new JLabel("Weight (kg):"), 0, constraints);
        addComponent(panel, new JTextField(20), 1, constraints);

        // Add a filler component at the bottom to push everything up
        constraints.gridy = 4;
        constraints.weighty = 1;
        addComponent(panel, new JPanel(), 0, constraints);
        addComponent(panel, new JPanel(), 1, constraints);


        // Set the form visible
        setVisible(true);
    }

    private void addComponent(JPanel panel, JComponent component, int gridx, GridBagConstraints constraints) {
        constraints.gridx = gridx;
        panel.add(component, constraints);
    }

    public static void main(String[] args) {
        // Create an instance of the GuiProject class
        SwingUtilities.invokeLater(GuiProject::new);
    }
}

