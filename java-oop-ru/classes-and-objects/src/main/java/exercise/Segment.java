package exercise;

// BEGIN
public class Segment{
    private Point first;
    private Point second;
    public Segment(Point first,Point second){
        this.first = first;
        this.second = second;
    }
    public Point getBeginPoint(){
        return first;
    }
    public Point getEndPoint(){
        return second;
    }
    public Point getMidPoint(){
        var midX = (first.getX() + second.getX())/2;
        var midY = (first.getY() + second.getY())/2;
        var midPoint = new Point(midX,midY);
        return midPoint;
    }
}
// END
