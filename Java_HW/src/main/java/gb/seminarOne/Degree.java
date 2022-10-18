package gb.seminarOne;

public class Degree {
    private double degree;
    private double number;

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public double getDegree() {
        return degree;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getResult() {
        return Math.pow(number, degree);
    }
}
