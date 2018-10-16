public class RationalNumber extends RealNumber {
        private int num;
        private int den;

        public RationalNumber(int x, int y) {
                num = x;
                den = y;
        }
	public int getNumerator(){
        	return num;
	}
   	public int getDenominator(){
	        return den;
    	}
        public double getValue() {
                return (num * 1.0) / den;
        }

        public String toString() {
                return "Numerator: " + num + "/" + den;
        }
}

