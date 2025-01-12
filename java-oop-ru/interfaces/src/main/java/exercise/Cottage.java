package exercise;

// BEGIN
public  class Cottage implements Home{

    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount){
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea(){
        return area;
    }
    public int getFloorCount(){
        return floorCount;
    }

    @Override
    public String toString(){
        var s = getFloorCount() + " этажный коттедж площадью " + getArea() + " метров";
        return s;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

}
// END
