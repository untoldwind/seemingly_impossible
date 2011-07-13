import java.math.BigInteger;


public class PrependOp extends Cantor {
	boolean x;
	Cantor a;

	public PrependOp(boolean x, Cantor a) {
		this.x = x;
		this.a = a;
	}

	@Override
	public Boolean call(BigInteger n) {
		return n.equals(BigInteger.ZERO) ? x : a.call(n.subtract(BigInteger.ONE));
	}

	public String toString() {
		return "[" + x + ", " + a + "]"; 
	}
}
