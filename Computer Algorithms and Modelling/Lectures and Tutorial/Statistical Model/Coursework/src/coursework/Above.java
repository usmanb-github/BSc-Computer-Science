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
public class Above extends JFrame implements ActionListener {

    JFormattedTextField meanTxt = new JFormattedTextField(new DecimalFormat());
    JFormattedTextField sdTxt = new JFormattedTextField(new DecimalFormat());
    JFormattedTextField a = new JFormattedTextField(new DecimalFormat());
    JButton submit = new JButton("Submit");
    JButton backToMain = new JButton("Back to Main");
    ModelGraph aboveGraph = new ModelGraph();
    JLabel area = new JLabel("Your area will be displayed here...");
    String[] list = {" ", "Trapezoidal Method", "Rectangular Method"};
    JComboBox comboBox = new JComboBox(list);

    public Above() {
        setLayout(new FlowLayout());
        setSize(600, 380);
        setTitle("Area Calculation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding graph to jpanel
        JPanel addToGUI = aboveGraph;
        addToGUI.add(Box.createRigidArea(new Dimension(250, 0)));
        addToGUI.setBorder(BorderFactory.createEmptyBorder(250, 0, 0, 0));
        add(aboveGraph, BorderLayout.CENTER);
        
        meanTxt.setValue(new Double(0));
        meanTxt.setColumns(5);
        sdTxt.setValue(new Double(1));
        sdTxt.setColumns(5);
        a.setValue(new Double(1));
        a.setColumns(5);

        JPanel top = new JPanel();
        top.add(new JLabel("Mean:"));
        top.add(meanTxt);
        top.add(new JLabel("Standard Deviation:"));
        top.add(sdTxt);
        top.add(new JLabel("Value One:"));
        top.add(a);
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
        double secondValue = meanValue - (4.1 * sdValue);
        double strips = 1000;
//inputting value
        aboveGraph.setMean(meanValue);
        aboveGraph.setSD(sdValue);
        aboveGraph.setAbove(valueOne);
        aboveGraph.setOption("1");
//calling Option and shading the area using the values
        this.repaint();

        if (e.getSource() == submit) {
//Combo box to choose which Area the user wants 
            String msg = (String) comboBox.getSelectedItem();
            switch (msg) {
                case " ":
                    area.setText(" ");
                    break;
                case "Trapezoidal Method":
                    area.setText("Trapezoidal Area:" + " " + (1 - ModelCalculations.trapRule(secondValue, valueOne, strips, meanValue, sdValue)));
                    break;
                case "Rectangular Method":
                    area.setText("Rectangular Area:" + " " + (1 - ModelCalculations.rectRule(secondValue, valueOne, strips, meanValue, sdValue)));
                    break;
                default:
                    area.setText("Error, try again!");
            }
        }
        if(e.getSource() == backToMain) {
            //back to main menu button
            MainGUI back = new MainGUI();
            //setting this class to false so it closes once this button is pressed
                this.setVisible(false);
        }
    }
}
