package coursework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ub2232e
 */
public class Table extends JFrame implements ActionListener {

    JButton backToMain = new JButton("Back to Main");
    JButton submit = new JButton("Submit");
    JButton reset = new JButton("Reset");
    DefaultTableModel main = new DefaultTableModel();
    JTable table = new JTable(main);
    JScrollPane scroll;
    NumberFormat decimal = new DecimalFormat("#0.0000");
    
    public Table() {
        setLayout(new FlowLayout());
        setBounds(100, 100, 800, 450);
        setTitle("ZTable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel top = new JPanel();
        //initialising formatted textfield to 0 and columns
        top.add(new JLabel("Click 'Submit' button to generate data:"));
        add("North", top);
        JPanel middle = new JPanel();
        middle.add(table);
        table.setForeground(Color.BLUE);
        //adding columns
        main.addColumn("Z");
        main.addColumn("0.00");
        main.addColumn("0.01");
        main.addColumn("0.02");
        main.addColumn("0.03");
        main.addColumn("0.04");
        main.addColumn("0.05");
        main.addColumn("0.06");
        main.addColumn("0.07");
        main.addColumn("0.08");
        main.addColumn("0.09");
        //adding scrollPane to class
        scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(700, 300));
        middle.add(scroll);
        add("Center", middle);
        JPanel bottom = new JPanel();
        bottom.add(submit);
        submit.addActionListener(this);
        bottom.add(reset);
        reset.addActionListener(this);
        bottom.add(backToMain);
        backToMain.addActionListener(this);
        add("South", bottom);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        //setting colours to the jpanels
        top.setBackground(Color.GREEN);
        bottom.setBackground(Color.GREEN);
        middle.setBackground(Color.GREEN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//Initialisation
        double Point = 1;
        double z = 0;
        double mean = 0;
        double sd = 1;
        double n = 1000;
        double cal = 10000;
        String z0, z1, z2, z3, z4, z5, z6, z7, z8, z9;
        
        if (e.getSource() == submit) {
            for (double i = 0; i <= Point; i += 0.1) {
                String mainStartMark = Double.toString(((double) Math.round((0 + z) * 10) / 10));
                z0 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.00), n, mean, sd)) * cal) / cal));
                z1 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.01), n, mean, sd)) * cal) / cal));
                z2 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.02), n, mean, sd)) * cal) / cal));
                z3 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.03), n, mean, sd)) * cal) / cal));
                z4 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.04), n, mean, sd)) * cal) / cal));
                z5 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.05), n, mean, sd)) * cal) / cal));
                z6 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.06), n, mean, sd)) * cal) / cal));
                z7 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.07), n, mean, sd)) * cal) / cal));
                z8 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.08), n, mean, sd)) * cal) / cal));
                z9 = decimal.format(((double) Math.round((ModelCalculations.belowZTable((0 + z + 0.09), n, mean, sd)) * cal) / cal));
//adds it to the jtable
                main.addRow(new String[]{mainStartMark, z0, z1, z2, z3, z4, z5, z6, z7, z8, z9});
                z += 0.1;
            }
        } else if (e.getSource() == reset) {
            //resets the table at users choice
            main.setRowCount(0);
        } else if (e.getSource() == backToMain) {
            //back to main menu button
            MainGUI back = new MainGUI();
            //setting this class to false so it closes once this button is presse
            this.setVisible(false);
        }
    }
}
