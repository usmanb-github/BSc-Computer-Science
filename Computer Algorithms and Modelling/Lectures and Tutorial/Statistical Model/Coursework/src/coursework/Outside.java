package coursework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ub2232e
 */
public class Outside extends JFrame implements ActionListener {
//variables

    JFormattedTextField meanTxt = new JFormattedTextField(new DecimalFormat());
    JFormattedTextField sdTxt = new JFormattedTextField(new DecimalFormat());
    JFormattedTextField a = new JFormattedTextField(new DecimalFormat());
    JFormattedTextField b = new JFormattedTextField(new DecimalFormat());
    JButton backToMain = new JButton("Back to Main");
    JButton submit = new JButton("Submit");
    ModelGraph OutsideGraph = new ModelGraph();
    String[] list = {"Trapezoidal Method", "Rectangular Method"};
    JComboBox comboBox = new JComboBox(list);
    JLabel area = new JLabel("Your area will be displayed here...");

    public Outside() {
        setLayout(new FlowLayout());
        setSize(720, 380);
        setTitle("Area Calculation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding graph to this class
        JPanel addToGUI = OutsideGraph;
        addToGUI.add(Box.createRigidArea(new Dimension(250, 0)));
        addToGUI.setBorder(BorderFactory.createEmptyBorder(250, 0, 0, 0));
        add(OutsideGraph, BorderLayout.CENTER);
        
        meanTxt.setValue(new Double(0));
        meanTxt.setColumns(5);
        sdTxt.setValue(new Double(1));
        sdTxt.setColumns(5);
        a.setValue(new Double(-1));
        a.setColumns(5);
        b.setValue(new Double(1));
        b.setColumns(5);

        JPanel top = new JPanel();
        top.add(new JLabel("Mean:"));
        top.add(meanTxt);
        top.add(new JLabel("Standard Deviation:"));
        top.add(sdTxt);
        top.add(new JLabel("Value One:"));
        top.add(a);
        top.add(new JLabel("Value Two:"));
        top.add(b);
        top.add(submit);
        submit.addActionListener(this);
        top.add(backToMain);
        backToMain.addActionListener(this);
        add("North", top);

        JPanel bottom = new JPanel();
        comboBox.setSelectedIndex(1);
        comboBox.addActionListener(this);
        bottom.add(comboBox);
        bottom.add(area);
        add("South", bottom);

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double meanValue = Double.parseDouble(meanTxt.getText());
        double sdValue = Double.parseDouble(sdTxt.getText());
        double valueOne = Double.parseDouble(a.getText());
        double valueTwo = Double.parseDouble(b.getText());
        double strips = 1000;

        if (e.getSource() == submit) {
            //inputting values
            OutsideGraph.setMean(meanValue);
            OutsideGraph.setSD(sdValue);
            OutsideGraph.setOutsideValueOne(valueOne);
            OutsideGraph.setOutsideValueTwo(valueTwo);
            OutsideGraph.setOption("4");
            //calling Option and shading the area using the values
            this.repaint();

            String message = (String) comboBox.getSelectedItem();
            switch (message) {
                case "Trapezoidal Method":
                    area.setText("Trapezoidal Area:" + "" + (1 - ModelCalculations.trapRule(valueOne, valueTwo, strips, meanValue, sdValue)));
                    break;
                case "Rectangular Method":
                    area.setText("Rectangular Area:" + "" + (1 - ModelCalculations.rectRule(valueOne, valueTwo, strips, meanValue, sdValue)));
                    break;
                default:
                    area.setText("Error, try again!");
            }
        }
        if (e.getSource() == backToMain) {
            //back to main menu button
            MainGUI back = new MainGUI();
            //setting this class to false so it closes once this button is presse
            this.setVisible(false);
        }
    }
}
