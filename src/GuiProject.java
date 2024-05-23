import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuiProject extends JFrame {
    private JTextField name, dob, height, weight, sportName, teamName, positionField, seasonsPlayed, avgGoalsScored, avgGoalsBlocked;
    private JTextArea injuryHistory;
    private JCheckBox currentlyHurt;
    private JSpinner agility, speed, strength;

    public GuiProject() {
        // Setting panel title, sizing and close operation
        setTitle("Athlete Data App");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main content panel with grid layout
        JPanel contentPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Player Info questions
        contentPanel.add(new JLabel("Player Info", SwingConstants.CENTER));
        contentPanel.add(new JLabel("")); // Empty cell for spacing

        // Text fields for input questions
        contentPanel.add(new JLabel("Name:"));
        name = new JTextField();
        contentPanel.add(name);

        contentPanel.add(new JLabel("DOB (MM/DD/YY):"));
        dob = new JTextField();
        contentPanel.add(dob);

        contentPanel.add(new JLabel("Height (in):"));
        height = new JTextField();
        contentPanel.add(height);

        contentPanel.add(new JLabel("Weight (lbs):"));
        weight = new JTextField();
        contentPanel.add(weight);

        // Athletic Overview questions
        contentPanel.add(new JLabel("Athletic Overview", SwingConstants.CENTER));
        contentPanel.add(new JLabel(""));

        // Add text area for injury history
        contentPanel.add(new JLabel("Injury History:"));
        injuryHistory = new JTextArea(3, 20);
        contentPanel.add(new JScrollPane(injuryHistory));

        // Check box for currently hurt question
        contentPanel.add(new JLabel("Currently Hurt?"));
        currentlyHurt = new JCheckBox();
        contentPanel.add(currentlyHurt);

        // 1-10 ranking of athletic skills with JSpinner
        contentPanel.add(new JLabel("Agility (1-10):"));
        agility = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        contentPanel.add(agility);

        contentPanel.add(new JLabel("Speed (1-10):"));
        speed = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        contentPanel.add(speed);

        contentPanel.add(new JLabel("Strength (1-10):"));
        strength = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        contentPanel.add(strength);

        // Sport Specifications questions
        contentPanel.add(new JLabel("Sport Specifications", SwingConstants.CENTER));
        contentPanel.add(new JLabel(""));

        contentPanel.add(new JLabel("Sport Name:"));
        sportName = new JTextField();
        contentPanel.add(sportName);

        contentPanel.add(new JLabel("Team Name:"));
        teamName = new JTextField();
        contentPanel.add(teamName);

        contentPanel.add(new JLabel("Position:"));
        positionField = new JTextField();
        contentPanel.add(positionField);

        contentPanel.add(new JLabel("Seasons Played:"));
        seasonsPlayed = new JTextField();
        contentPanel.add(seasonsPlayed);

        contentPanel.add(new JLabel("Avg Goals Scored/Game:"));
        avgGoalsScored = new JTextField();
        contentPanel.add(avgGoalsScored);

        contentPanel.add(new JLabel("Avg Goals Blocked/Game:"));
        avgGoalsBlocked = new JTextField();
        contentPanel.add(avgGoalsBlocked);

        // Submit and Clear Buttons
        JButton submitButton = new JButton("Submit");
        contentPanel.add(submitButton);

        JButton clearButton = new JButton("Clear");
        contentPanel.add(clearButton);

        submitButton.addActionListener(e -> handleSubmit());
        clearButton.addActionListener(e -> handleClear());

        // Add padding around the content panel
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        outerPanel.add(contentPanel, BorderLayout.CENTER);

        // Add outer panel to frame
        add(outerPanel);
    }

    private void saveToCSV() {
        // Set the default file path to athlete_data.csv file
        String filePath = "C:\\Users\\sserrano2024\\IdeaProjects\\GuiProject\\athlete_data.csv";
        //automatically saves to csv file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("athlete_data.csv",true));

            // Write the form data to the CSV file
            writer.write(name.getText() + ",");
            writer.write(dob.getText() + ",");
            writer.write(height.getText() + ",");
            writer.write(weight.getText() + ",");
            writer.write(injuryHistory.getText().replace("\n", " ") + ",");
            writer.write(currentlyHurt.isSelected() + ",");
            writer.write(agility.getValue() + ",");
            writer.write(speed.getValue() + ",");
            writer.write(strength.getValue() + ",");
            writer.write(sportName.getText() + ",");
            writer.write(teamName.getText() + ",");
            writer.write(positionField.getText() + ",");
            writer.write(seasonsPlayed.getText() + ",");
            writer.write(avgGoalsScored.getText() + ",");
            writer.write(avgGoalsBlocked.getText());

            //pop up message when successfully saved
            writer.close();
            JOptionPane.showMessageDialog(this, "Data saved to " + filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data to CSV file.");
        }
    }

    private void handleSubmit() {
        // Shows pop-up message with question name and user input when Submit is pressed
        String message = "Player data submitted:\n" +
                "Name: " + name.getText() + "\n" +
                "DOB: " + dob.getText() + "\n" +
                "Height: " + height.getText() + "\n" +
                "Weight: " + weight.getText() + "\n" +
                "Injury History: " + injuryHistory.getText() + "\n" +
                "Currently Hurt: " + currentlyHurt.isSelected() + "\n" +
                "Agility: " + agility.getValue() + "\n" +
                "Speed: " + speed.getValue() + "\n" +
                "Strength: " + strength.getValue() + "\n" +
                "Sport Name: " + sportName.getText() + "\n" +
                "Team Name: " + teamName.getText() + "\n" +
                "Position: " + positionField.getText() + "\n" +
                "Seasons Played: " + seasonsPlayed.getText() + "\n" +
                "Avg Goals Scored/Game: " + avgGoalsScored.getText() + "\n" +
                "Avg Goals Blocked/Game: " + avgGoalsBlocked.getText();

        JOptionPane.showMessageDialog(this, message);

        // Automatically save the data to a CSV file
        saveToCSV();
    }

    private void handleClear() {
        // Clear button method that resets everything
        name.setText("");
        dob.setText("");
        height.setText("");
        weight.setText("");
        injuryHistory.setText("");
        currentlyHurt.setSelected(false);
        agility.setValue(1);
        speed.setValue(1);
        strength.setValue(1);
        sportName.setText("");
        teamName.setText("");
        positionField.setText("");
        seasonsPlayed.setText("");
        avgGoalsScored.setText("");
        avgGoalsBlocked.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuiProject().setVisible(true));
    }
}
