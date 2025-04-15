import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * [6b] luas poligon ini menggunakan Triangulasi & Shoelace Formula
     * @return luas poligon (non-negatif)
     */
    double area() {
        double area = 0.0;
        MyPoint pivot = Points.get(0); // Titik acuan (bisa titik mana saja di convex hull)
        
        for (int i = 1; i < Points.size() - 1; i++) {
            MyPoint b = Points.get(i);
            MyPoint c = Points.get(i + 1);
            // Hitung luas segitiga pivot-b-c menggunakan shoelace
            double subArea = Math.abs(pivot.x * (b.y - c.y) + b.x * (c.y - pivot.y) + c.x * (pivot.y - b.y)) / 2.0;
            area += subArea;
        }
        
        return area;
    }

    // double area() {
	// 	double area = 0.0;
    //     int n = this.Points.size();
    //     for (int i = 0; i < n; i++) {
    //         MyPoint current = this.Points.get(i);
    //         MyPoint next = this.Points.get((i + 1) % n);
    //         area += (current.x * next.y) - (current.y * next.x);
    //     }
    //     return Math.abs(area) / 2.0; // Ambil nilai absolut dan bagi 2
    // }

    /**
     * [7b] titik p di dalam atau di luar poligon (termasuk tepi)
     * @param p titik yang akan diperiksa
     * @return true jika di dalam atau pada tepi, false jika di luar
     */
    boolean isPointInside(MyPoint p) {
        int n = this.Points.size();
        boolean inside = false;
        
        for (int i = 0, j = n - 1; i < n; j = i++) {
            MyPoint a = this.Points.get(i);
            MyPoint b = this.Points.get(j);
            
            // Cek apakah titik berada tepat di tepi segmen
            MyLineSegment edge = new MyLineSegment(a, b);
            if (edge.distanceToPoint(p) <= 1e-9) {
                return true;
            }
            
            // Ray casting logic
            if ((a.y > p.y) != (b.y > p.y)) {
                double intersectX = (b.x - a.x) * (p.y - a.y) / (b.y - a.y) + a.x;
                if (p.x <= intersectX) {
                    inside = !inside;
                }
            }
        }
        return inside;
    }

}
