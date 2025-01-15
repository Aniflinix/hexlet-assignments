package exercise;

// BEGIN
public class Circle{
    protected Point point;
    protected int radius;

    public Circle(Point point,int radius){
        this.point = point;
        this.radius = radius;
    }
    public int getRadius(){
        return radius;
    }
    public double getSquare() throws NegativeRadiusException{
        if(radius < 0){
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
            double result = Math.PI * (radius*radius);
            return result;


    }
}
// END
