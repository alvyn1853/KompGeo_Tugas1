import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class MyPointSet {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * @return
     */
    public MyPointSet() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [8a] masukin titik
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        this.Points.add(p);
        return true;
    }

    /**
     * [8b] urutkan titik berdasarkan sudut relatif terhadap titik paling kiri bawah
     * @return list titik yang sudah terurut
     */
    List<MyPoint> sortByAngle() {
        if (Points.isEmpty()) return new ArrayList<>();

        // Temukan titik paling kiri bawah
        MyPoint reference = this.Points.get(0);
        for (MyPoint p : Points) {
            if (p.x < reference.x || (p.x == reference.x && p.y < reference.y)) {
                reference = p;
            }
        }

        final MyPoint finalRef = reference;

        // Urutkan berdasarkan sudut relatif terhadap referensi
        List<MyPoint> sorted = new ArrayList<>(Points);
        Collections.sort(sorted, new Comparator<MyPoint>() {
            @Override
            public int compare(MyPoint a, MyPoint b) {
                if (a.equals(finalRef)) return -1;
                if (b.equals(finalRef)) return 1;
                
                double angleA = Math.atan2(a.y - finalRef.y, a.x - finalRef.x);
                double angleB = Math.atan2(b.y - finalRef.y, b.x - finalRef.x);
                
                if (angleA < angleB) return -1;
                else if (angleA > angleB) return 1;
                else {
                    // Jika sudut sama, urutkan berdasarkan jarak
                    double distA = finalRef.distanceToOtherPoints(a);
                    double distB = finalRef.distanceToOtherPoints(b);
                    return Double.compare(distA, distB);
                }
            }
        });

        return sorted;
    }

}