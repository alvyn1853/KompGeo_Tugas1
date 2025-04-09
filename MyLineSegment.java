public class MyLineSegment {
    /** ``vektor'' dari start ke end */
    MyPoint start;
    /** komen di sini */
    MyPoint end;

    /**
     * konstruktor
     * @param start
     * @param end
     */
    MyLineSegment(MyPoint start, MyPoint end) {
        this.start = start;
        this.end = end;
    }

    /**
     * [2a] jarak ke titik
     * @param p
     * @return
     */
    double distanceToPoint(MyPoint p) {
		double dist = 0.0;	//menyimpan jarak
        //poin r[p] ke segmen p[q] q[r]
        double pq,qr,qp,pr;
        //if dot product pq qr>0 [qr rp]
        //if dot product qp pr>0 [rq q p]
        //else distance to a line
        return dist;
    }

    /**
     * [3] dari start ke end ke target belok kiri, kanan, atao lurus
     * @param target
     * @return
     */
    double leftTurnToPoint(MyPoint target) {
		double res = 0.0;
		res = CG.ccw(this.start, this.end, target);
        return res; //return 0 jika lurus, plus/minus jika belok kanan/kiri,  
    }
    
    /**
     * [4] motong segmen laen?
     * @param other
     * @return
     */
    boolean isIntersect(MyLineSegment other) {
		boolean potong = false;
		
        return potong;
    }

}