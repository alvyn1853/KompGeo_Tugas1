public class CG {
    
    /**
     * Memeriksa apakah dari p ke q ke r berlawanan arah jarum jam atau tidak
     * @return >0 jika berlawanan arah jarum jam (belok kiri), 
	 * <0 jika searah jarum jam (belok kanan), dan 0 jika lurus (kolinear)
     */
    public static double ccw(MyPoint p, MyPoint q, MyPoint r) {
        MyPoint pq = new MyPoint((q.x-p.x),(q.y-p.y));
        MyPoint pr = new MyPoint((r.x-p.x),(r.y-p.y));
		double res = ((pq.x*pr.y)-(pq.y*pr.x));
		if (Math.abs(res)<=0.00000001) res = 0;
		//else res = res/Math.abs(res);
        return res;
    }

    /**
     * jika perlu
     * @return
     */
    public static double dot() {
        return 0;
    }

    /**
     * jika perlu
     * @return
     */
    public static MyPoint cross() {
        return new MyPoint(0,0);
    }

}
