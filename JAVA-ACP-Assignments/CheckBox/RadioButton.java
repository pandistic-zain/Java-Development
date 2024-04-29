import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkboxes as Radio Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        JPanel panel = new JPanel(new GridLayout(2, 3)); // 2 rows, 3 columns

        JCheckBox checkBox1 = new JCheckBox("badam");
        JCheckBox checkBox2 = new JCheckBox("Pista");
        JCheckBox checkBox3 = new JCheckBox("Kaju");
        JCheckBox checkBox4 = new JCheckBox("Moong Phalli");
        JCheckBox checkBox5 = new JCheckBox("Akhroot");
        JCheckBox checkBox6 = new JCheckBox("Chalghoza");

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(checkBox4);
  panel.add(checkBox5);
        panel.add(checkBox6);

        // Create an ItemListener for checkbox group behavior
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox source = (JCheckBox) e.getItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Unselect other checkboxes when a new one is selected
                    for (Component component : panel.getComponents()) {
                        if (component instanceof JCheckBox && component != source) {
                            ((JCheckBox) component).setSelected(false);
                        }
                    }
                }
            }
        };

        checkBox1.addItemListener(itemListener);
        checkBox2.addItemListener(itemListener);
        checkBox3.addItemListener(itemListener);
        checkBox4.addItemListener(itemListener);
        checkBox5.addItemListener(itemListener);
        checkBox6.addItemListener(itemListener);

        frame.add(panel);
        frame.setVisible(true);
    }
}