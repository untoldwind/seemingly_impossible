import java.math.BigInteger;


public class PrependOp2 extends Cantor {
	Function<Void, Boolean> x;
	Cantor a;

	public PrependOp2(Function<Void, Boolean> x, Cantor a) {
		this.x = x;
		this.a = a;
	}

	@Override
	public Boolean call(BigInteger n) {
		return n.equals(BigInteger.ZERO) ? x.call(null) : a.call(n.subtract(BigInteger.ONE));
	}

	public String toString() {
		return "[" + x + ", " + a + "]"; 
	}
}
