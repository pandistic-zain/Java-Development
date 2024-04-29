import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();

        JRadioButton ARadioButton = new JRadioButton("A-Button");
        JRadioButton BRadioButton = new JRadioButton("B-Button");
        JRadioButton CRadioButton = new JRadioButton("C-Button");

        ButtonGroup Group = new ButtonGroup();
        Group.add(ARadioButton);
        Group.add(BRadioButton);
        Group.add(CRadioButton);

        ARadioButton.setSelected(true); 

        panel.add(ARadioButton);
        panel.add(BRadioButton);
        panel.add(CRadioButton);

        frame.add(panel);

        ActionListener radioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ARadioButton.isSelected()) {
                    System.out.println("Selected: A-Button");
                } else if (BRadioButton.isSelected()) {
                    System.out.println("Selected: B-Button");
                } else if (CRadioButton.isSelected()) {
                    System.out.println("Selected: C-Button");
                }
            }
        };
        ARadioButton.addActionListener(radioListener);
        BRadioButton.addActionListener(radioListener);
        CRadioButton.addActionListener(radioListener);
        frame.setVisible(true);
    }
}