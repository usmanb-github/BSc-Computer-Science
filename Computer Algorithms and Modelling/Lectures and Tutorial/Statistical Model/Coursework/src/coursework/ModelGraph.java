package coursework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.*;

/**
 *
 * @author ub2232e
 */
public class ModelGraph extends JPanel {
//variables
    double mean;
    double sd;
    double above;
    double below;
    double betweenValueOne;
    double betweenValueTwo;
    double outsideValueOne;
    double outsideValueTwo;
    String option;

    public ModelGraph() {
        //setting sizes and visibility
        setSize(500, 500);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.darkGray);
        Graphics2D g2D = (Graphics2D) g;
        Line2D x = new Line2D.Double(80, 210, 320, 210);
        g2D.draw(x);
//draws X Axis
        double start = mean - (sd * 4);
        double sdDouble = sd;
//draw x values and the 10 labels of the x axis
        for (int i = 0; i <= 6; i++) {
            g2D.draw(new Line2D.Double(i * 24 + 80, 210, i * 24 + 80, 215));
            if (i % 2 == 0) {
                g2D.drawString(" " + (((double) Math.round((start + sdDouble) * 10) / 10)), i * 24 + 70, 230);
            } else {
                g2D.drawString(" " + (((double) Math.round((start + sdDouble) * 10) / 10)), i * 24 + 70, 240);
            }
            sdDouble += sd;
        }

        double xInc = ((mean + (sd * 5)) - (mean - (sd * 5))) / 230;
        double a = start;
//draws the curve
        for (int i = 70; i <= 310; i++) {
            double xValue = i;
            double c = 212 - (212 * (ModelCalculations.f(a, mean, sd) / 100) * 212);
            g2D.drawLine((int) xValue + (int) 1, (int) c, (int) xValue, (int) c);
            g2D.setColor(Color.darkGray);
            
//calls this for Above to shade it in
            if ("1".equals(option)) {
                double xInterAbove = (62 + (above - start) / xInc);
                if (i >= xInterAbove) {
                    g2D.setColor(Color.red);
                    g2D.draw(new Line2D.Double(xValue, 210, xValue, c));
                }
            }
//calls this for Below to shade it in
            if ("2".equals(option)) {
                double xInterBelow = (62 + (below - start) / xInc);
                if (i <= xInterBelow) {
                    g2D.setColor(Color.red);
                    g2D.draw(new Line2D.Double(xValue, 210, xValue, c));
                }
            }
//calls this for Between to shade it in            
            if ("3".equals(option)) {
                double xInterBetweenOne = (62 + (betweenValueOne - start) / xInc);
                double xInterBetweenTwo = (62 + (betweenValueTwo - start) / xInc);
                
                if (i >= xInterBetweenOne && i <= xInterBetweenTwo) {
                    g2D.setColor(Color.red);
                    g2D.draw(new Line2D.Double(xValue, 210, xValue, c));
                }
            }
//calls this for Outside to shade it in
            if ("4".equals(option)) {
                double xInterOutsideOne = (62 + (outsideValueOne - start) / xInc);
                double xInterOutsideTwo = (62 + (outsideValueTwo - start) / xInc);

                if (!(i >= xInterOutsideOne && i <= xInterOutsideTwo)) {
                    g2D.setColor(Color.red);
                    g2D.draw(new Line2D.Double(xValue, 210, xValue, c));
                }
            }
            a = a + xInc;
        }
    }
//methods to call from other classes
    public void setMean(double m) {
        this.mean = m;
    }

    public void setSD(double s) {
        this.sd = s;
    }
    
    public void setOption(String s) {
        this.option = s;
    }

    public void setAbove(double a) {
        this.above = a;
    }

    public void setBelow(double b) {
        this.below = b;
    }

    public void setBetweenValueOne(double b1) {
        this.betweenValueOne = b1;
    }

    public void setBetweenValueTwo(double b2) {
        this.betweenValueTwo = b2;
    }

    public void setOutsideValueOne(double o1) {
        this.outsideValueOne = o1;
    }

    public void setOutsideValueTwo(double o2) {
        this.outsideValueTwo = o2;
    }
}
