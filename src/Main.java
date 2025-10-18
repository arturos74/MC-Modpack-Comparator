import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    createAndShowGUI();

}

String toStringList(Modpack modpack) {
    String modsText = "";

    for(int i = 0; i < modpack.getModAmount(); i++) {
        modsText = modsText + modpack.listMods(i);
    }

    return modsText;
}

void createAndShowGUI() {

    JFrame frame = new JFrame("Modpack Comparator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 650);
    frame.setLayout(new BorderLayout(10, 10));

    // === TOP PANEL: two input fields with browse buttons ===
    JPanel inputPanel = new JPanel(new GridLayout(3, 3, 5, 5));
    inputPanel.setBorder(BorderFactory.createTitledBorder("Modpack Paths"));

    JLabel packA_Label = new JLabel("Modpack A Path:");
    JTextField packA_Field = new JTextField("C:\\Users\\redtr\\AppData\\Roaming\\ATLauncher\\instances\\MCEternal2\\mods");
    JButton browseA_Button = new JButton("Browse");

    JLabel packB_Label = new JLabel("Modpack B Path:");
    JTextField packB_Field = new JTextField("C:\\Users\\redtr\\AppData\\Roaming\\ATLauncher\\instances\\AlltheMods10ATM10\\mods");
    JButton browseB_Button = new JButton("Browse");

    JButton compareButton = new JButton("Compare");

    inputPanel.add(packA_Label);
    inputPanel.add(packA_Field);
    inputPanel.add(browseA_Button);
    inputPanel.add(packB_Label);
    inputPanel.add(packB_Field);
    inputPanel.add(browseB_Button);
    inputPanel.add(compareButton);

    // === CENTER PANEL: three display boxes ===
    JPanel displayPanel = new JPanel(new GridLayout(2, 2, 10, 10));
    displayPanel.setBorder(BorderFactory.createTitledBorder("Results"));

    JTextArea box1 = new JTextArea("Modpack 1 Mods");
    JTextArea box2 = new JTextArea("Modpack 2 Mods");

    JTextArea box3 = new JTextArea("Modpack 1 Differences");
    JTextArea box4 = new JTextArea("Modpack 2 Differences");



    for (JTextArea box : new JTextArea[]{box1, box2, box3, box4}) {
        box.setEditable(false);
        box.setLineWrap(true);
        box.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(box);
        displayPanel.add(scroll);
    }

    // === File Chooser Logic ===
    browseA_Button.addActionListener(e -> {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // choose folders
        int result = chooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            packA_Field.setText(selectedFile.getAbsolutePath());
        }
    });

    browseB_Button.addActionListener(e -> {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // choose folders
        int result = chooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            packB_Field.setText(selectedFile.getAbsolutePath());
        }
    });

    compareButton.addActionListener(e -> {
        if(!Objects.equals(packA_Field.getText(), ""))
        {
            if(!Objects.equals(packB_Field.getText(), "")) {
                Modpack modpack1 = new Modpack("Modpack 1", packA_Field.getText());
                Modpack modpack2 = new Modpack("Modpack 2", packB_Field.getText());

                box1.setText(toStringList(modpack1));
                box2.setText(toStringList(modpack1));

                box3.setText(modpack1.getDifferences(modpack2));
                box4.setText(modpack2.getDifferences(modpack1));

            }
            else  {
                JOptionPane.showMessageDialog(frame,"Please pick a path");
            }
        }
        else {
            JOptionPane.showMessageDialog(frame,"Please pick a path");
        }
    });

    // === Add panels to frame ===
    frame.add(inputPanel, BorderLayout.NORTH);
    frame.add(displayPanel, BorderLayout.CENTER);

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
