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
        //poin r[p] ke segmen p[q l.start] q[r l.end]
        /*tulisan di rumus: p q r
         * tulisan kode: lineSegStart lineSegEnd p
         * maka: q r p => ditandakan dengan []
         * p => q [line seg start]
         * q => r [line seg end]
         * r => p [point]
         */
        //pq[qr]
        double qrx=this.end.x-this.start.x;
        double qry=this.end.y-this.start.y;
        //qr[rp]
        double rpx=p.x-this.end.x;
        double rpy=p.y-this.end.y;
        //qp[rq]
        double rqx=this.start.x-this.end.x;
        double rqy=this.start.y-this.end.y;
        //pr[qp]
        double qpx=p.x-this.start.x;
        double qpy=p.y-this.start.y;

        //if dot product pq qr>0 [qr rp => qrx*rpx+ qry*rpy]
        if((qrx*rpx)+(qry*rpy)>0){
            //dist=d(q,r) => d(r,p)
            dist=p.distanceToOtherPoints(this.end);
        }
        //if dot product qp pr>0 [rq qp]
        else if ((rqx*qpx)+(rqy*qpy)>0) {
            dist=p.distanceToOtherPoints(this.start);
        }
        //else distance to a line pq X pr/||pq|| => qr X qp/||qr||
        //cross prod
        //qr X qp/||qr||
        else{
            dist= Math.abs((qrx*qpy)-(qry*qpx))/this.start.distanceToOtherPoints(this.end);
        }
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
		boolean potong;
        double maxThisX= Math.max(this.start.x, this.end.x);
        double maxThisY= Math.max(this.start.y, this.end.y);
        double minThisX= Math.min(this.start.x, this.end.x);
        double minThisY= Math.min(this.start.y, this.end.y);
        //jika kedua nilai x segmen lebih besar dari x terbesar ini maka tak mungkin berpotongan
        if (other.start.x>maxThisX&&other.end.x>maxThisX) {
            potong=false;    
        }
        //jika kedua nilai x segmen lebih kecil dari x terkecil ini maka tak mungkin berpotongan
        else if (other.start.x<minThisX&&other.end.x<minThisX) {
            potong=false;    
        }
        //jika kedua nilai y segmen lebih besar dari y terbesar ini maka tak mungkin berpotongan
        if (other.start.y>maxThisY&&other.end.y>maxThisY) {
            potong=false;    
        }
        //jika kedua nilai y segmen lebih kecil dari y terkecil ini maka tak mungkin berpotongan
        else if (other.start.y<minThisY&&other.end.y<minThisY) {
            potong=false;    
        }
        //cek belok, bila arahnya berbeda berarti berpotongan
        else{
            double p1=leftTurnToPoint(other.start);
            double p2=leftTurnToPoint(other.end);
            if(p1==p2)potong=false;
            else potong=true;
        }
		
        return potong;
    }

}