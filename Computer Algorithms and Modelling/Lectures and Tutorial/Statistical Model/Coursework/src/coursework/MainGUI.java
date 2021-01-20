package coursework;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author ub2232e
 */
public class MainGUI extends JFrame implements ActionListener {

    JButton submitBtn = new JButton("Submit");
    JButton tableBtn = new JButton("ZTable");
    JButton exitBtn = new JButton("Exit");
    JRadioButton above = new JRadioButton();
    JRadioButton below = new JRadioButton();
    JRadioButton between = new JRadioButton();
    JRadioButton outside = new JRadioButton();
    ButtonGroup buttonGroup = new ButtonGroup();

    public static void main(String[] args) {
        MainGUI open = new MainGUI();
    }

    public MainGUI() {
        setLayout(new FlowLayout());
        setSize(1250, 260);
        setTitle("Statistical Model Using Numerical Integration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Select one of the following graphs:"));
        //adding buttons to main menu
        JPanel middle = new JPanel();
        buttonGroup.add(above);
        middle.add(above);
        ImageIcon icon = new ImageIcon("Images/one.jpg");
        JLabel label = new JLabel(icon);
        middle.add(label);
        buttonGroup.add(below);
        middle.add(below);
        ImageIcon iconOne = new ImageIcon("Images/two.jpg");
        JLabel labelOne = new JLabel(iconOne);
        middle.add(labelOne);
        buttonGroup.add(between);
        middle.add(between);
        ImageIcon iconTwo = new ImageIcon("Images/three.jpg");
        JLabel labelTwo = new JLabel(iconTwo);
        middle.add(labelTwo);
        buttonGroup.add(outside);
        middle.add(outside);
        ImageIcon iconThree = new ImageIcon("Images/four.jpg");
        JLabel labelThree = new JLabel(iconThree);
        middle.add(labelThree);
        add("Center", middle);
        JPanel bottom = new JPanel();
        bottom.add(submitBtn);
        submitBtn.addActionListener(this);
        bottom.add(tableBtn);
        tableBtn.addActionListener(this);
        bottom.add(exitBtn);
        exitBtn.addActionListener(this);
        add("South", bottom);

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //buttons set to all each classes once clicked using Radio Button
        if (e.getSource() == submitBtn) {
            if (above.isSelected()) {
                Above object = new Above();
                this.setVisible(false);
            } else if (below.isSelected()) {
                Below object = new Below();
                this.setVisible(false);
            } else if (between.isSelected()) {
                Between object = new Between();
                this.setVisible(false);
            } else if (outside.isSelected()) {
                Outside object = new Outside();
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "You have not selected one of the graphs");
            }
        } else if (e.getSource() == tableBtn) {
            Table object = new Table();
            this.setVisible(false);
        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }
}
