import java.util.ArrayList;
import java.util.List;

public class MyPolygon {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * @return
     */
    public MyPolygon() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [5a,6a,7a] masukin titik
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        this.Points.add(p);
        return true;
    }

    /**
     * [5b] konveks ato bukan
     * @return
     */
    boolean isConvex() {
		boolean convex = true;
        MyPoint p1,p2,p3;
        MyLineSegment l1;
		for(int i=0;i<this.Points.size();i++){
            p1 = this.Points.get(i);
            p2 = this.Points.get((i + 1) % this.Points.size());
            p3 = this.Points.get((i + 2) % this.Points.size());
            l1=new MyLineSegment(p1, p2);
            if(l1.leftTurnToPoint(p3)<0){
                convex=false;
                break;
            }
        }
        return convex;
    }

    /**
     * [6b] luas poligon ini
     * @return
     */
    double area() {
		double area = 0.0;
		
        return area;
    }

    /**
     * [7b] titik p di dalem ato luar,
     * jika berimpitan dengan titik atau segmen, di dalam 
     * @param p
     * @return
     */
    boolean isPointInside(MyPoint p) {
		boolean inside = true;
		
        return inside;
    }

}
