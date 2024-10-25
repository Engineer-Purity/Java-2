java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelector extends JFrame {
    private JLabel imageLabel;
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ImageIcon birdIcon, catIcon, dogIcon, rabbitIcon, pigIcon;

    public PetSelector() {
        setTitle("Pet Selector");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load images
        birdIcon = new ImageIcon("bird.png");
        catIcon = new ImageIcon("cat.png");
        dogIcon = new ImageIcon("dog.png");
        rabbitIcon = new ImageIcon("rabbit.png");
        pigIcon = new ImageIcon("pig.png");

        // Create the radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add radio buttons to a panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Label to display the image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(300, 300));

        // Add radio buttons and image label to the frame
        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        // Add Action Listeners to the buttons
        birdButton.addActionListener(new PetActionListener("Bird", birdIcon));
        catButton.addActionListener(new PetActionListener("Cat", catIcon));
        dogButton.addActionListener(new PetActionListener("Dog", dogIcon));
        rabbitButton.addActionListener(new PetActionListener("Rabbit", rabbitIcon));
        pigButton.addActionListener(new PetActionListener("Pig", pigIcon));
    }

    // Inner class to handle radio button actions
    private class PetActionListener implements ActionListener {
        private String petType;
        private ImageIcon petImage;

        public PetActionListener(String petType, ImageIcon petImage) {
            this.petType = petType;
            this.petImage = petImage;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Update the label with the pet image
            imageLabel.setIcon(petImage);

            // Show a message box with the selected pet
            JOptionPane.showMessageDialog(null, "You selected: " + petType);
        }
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            PetSelector frame = new PetSelector();
            frame.setVisible(true);
        });
    }
}
