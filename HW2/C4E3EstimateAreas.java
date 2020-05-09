public class C4E3EstimateAreas {
    public static void main(String[] args) {
        //input the latitudes and longitudes of the four cities
        double xAtlantaGA = 33.7489954;
        double yAtlantaGA = -84.3879824;
        double xOrlandoFL = 28.5383355;
        double yOrlandoFL = -81.3792365;
        double xSavannahGA = 32.0835407;
        double ySavannahGA = -81.0998342;
        double xCharlotteNC = 35.2270869;
        double yCharlotteNC = -80.8431267;

        //calculate five edges
        double A_C = distance(xAtlantaGA, yAtlantaGA, xCharlotteNC, yCharlotteNC);
        double C_S = distance(xCharlotteNC, yCharlotteNC, xSavannahGA, ySavannahGA);
        double S_A = distance(xSavannahGA, ySavannahGA, xAtlantaGA, yAtlantaGA);
        double S_O = distance(xSavannahGA, ySavannahGA, xOrlandoFL, yOrlandoFL);
        double O_A = distance(xOrlandoFL, yOrlandoFL, xAtlantaGA, yAtlantaGA);

        //calculate two triangle areas
        double area1 = area(A_C, C_S, S_A);
        double area2 = area(S_A, S_O, O_A);

        double totalArea = area1 + area2;

        //output the result
        System.out.println("The estimate area enclosed by these four cities is " + totalArea);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);
        double distance = 6371.01 * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
        return distance;
    }

    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.pow( s * (s - side1) * (s - side2) * (s - side3), 0.5);
        return area;
    }
}
