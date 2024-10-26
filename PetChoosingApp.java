import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class that extends JFrame to create the application window
public class PetChoosingApp extends JFrame 
{
    private JRadioButton birdRadioButton, catRadioButton, dogRadioButton, rabbitRadioButton, pigRadioButton;
    private JLabel petImageLabel;
    private ButtonGroup radioButtonGroup;

    public PetChoosingApp() 
    {
        setTitle("Pet Selector"); // Set the title of the window
        setSize(700, 700); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close
        setLayout(new FlowLayout()); // Set the layout manager for the frame

        // Initialize radio buttons with pet names
        birdRadioButton = new JRadioButton("Bird");
        catRadioButton = new JRadioButton("Cat");
        dogRadioButton = new JRadioButton("Dog");
        rabbitRadioButton = new JRadioButton("Rabbit");
        pigRadioButton = new JRadioButton("Pig");

        // Group the radio buttons to ensure only one can be selected at a time
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(birdRadioButton);
        radioButtonGroup.add(catRadioButton);
        radioButtonGroup.add(dogRadioButton);
        radioButtonGroup.add(rabbitRadioButton);
        radioButtonGroup.add(pigRadioButton);

        // Add radio buttons to the frame
        add(birdRadioButton);
        add(catRadioButton);
        add(dogRadioButton);
        add(rabbitRadioButton);
        add(pigRadioButton);

        // Initialize the image label to display selected pet images
        petImageLabel = new JLabel();
        add(petImageLabel); // Add image label to the frame

        // Add action listeners to radio buttons to handle selection events
        birdRadioButton.addActionListener(new PetRadioButtonListener());
        catRadioButton.addActionListener(new PetRadioButtonListener());
        dogRadioButton.addActionListener(new PetRadioButtonListener());
        rabbitRadioButton.addActionListener(new PetRadioButtonListener());
        pigRadioButton.addActionListener(new PetRadioButtonListener());

        // Set the default selection to Pig and display the corresponding image
        pigRadioButton.setSelected(true);
        setPetImage("pig-image-file.png");
    }

    // Helper method to set the image on the label
    private void setPetImage(String imagePath) 
    {
        petImageLabel.setIcon(new ImageIcon(imagePath));
    }

    // Inner class to handle radio button selection events
    private class PetRadioButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            // Get the selected radio button's text
            JRadioButton source = (JRadioButton) e.getSource();
            String selection = source.getText();

            // Update the image label based on the selected pet
            if ("Bird".equals(selection)) 
            {
                setPetImage("bird-image-file.png");
            } 
            else if ("Cat".equals(selection)) 
            {
                setPetImage("cat-image-file.png");
            } 
            else if ("Dog".equals(selection)) 
            {
                setPetImage("dog-image-file.png");
            } 
            else if ("Rabbit".equals(selection)) 
            {
                setPetImage("rabbit-image-file.png");
            } 
            else if ("Pig".equals(selection)) 
            {
                setPetImage("pig-image-file.png");
            }
        }
    }

    // Main method to run the application
    public static void main(String[] args) 
    {
        // Ensure the GUI is created and updated in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new PetChoosingApp().setVisible(true);
            }
        });
    }
}
