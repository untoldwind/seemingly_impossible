import java.math.BigInteger;


public class Proj extends Cantor2Any<Long> {
	BigInteger i;
	
	public Proj(long i) {
		this.i = BigInteger.valueOf(i);
	}
	
	public Proj(BigInteger i) {
		this.i = i;
	}
	
	long coerce(boolean b) {
		return b ? 1 : 0;
	}

	@Override
	public Long call(Cantor a) {
		return coerce(a.call(i));
	}

}
