package coursework;

/**
 *
 * @author ub2232e
 */
class ModelCalculations {
    //pdf method
    public static double f(double a, double mean, double sd) {
        double f = 1 / (sd * (Math.sqrt(2 * Math.PI))) * Math.exp(-(Math.pow((a - mean), 2)) / (2 * Math.pow(sd, 2)));
        return f;
    }
//trapeziodal method
    public static double trapRule(double a, double b, double strips, double mean, double sd) {
        double delta = (b - a) / strips;
        double a1 = f(a, mean, sd);
        double b1 = f(b, mean, sd);
        double finalResult = 0.5 * (a1 + b1);

        for (double i = 1; i < strips; i++) {
            finalResult = finalResult + f((a + (i * delta)), mean, sd);
        }
        finalResult = delta * finalResult;
        return finalResult;
    }
//Rectangular method
    public static double rectRule(double a, double b, double strips, double mean, double sd) {
        double delta = (b - a) / strips;
        double finalResult = 0.5;
        
        for (double i = 1; i < strips; i++) {
            finalResult = finalResult + f((a + (i - 1) * delta), mean, sd);
        }
        finalResult = delta * finalResult;
        return finalResult;
    }

//ZTable method
    public static double belowZTable(double a, double strips, double mean, double sd) {
        double b = mean + (4.1 * sd);
        double below = trapRule(b, a, strips, mean, sd);
        return 1 + below;
    }
}
