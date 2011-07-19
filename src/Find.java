import java.math.BigInteger;
import java.util.List;

public abstract class Find {
	public Find() {
	}

	public abstract Cantor find(Cantor2Bool p);

	public boolean forsome(Cantor2Bool p) {
		return p.call(find(p));		
	}
	
	public boolean forevery(final Cantor2Bool p) {
		return !forsome(new Cantor2Bool() {
			@Override
			public Boolean call(Cantor a) {
				return !p.call(a);
			}
		});
	}
	
	public <Y> boolean equal(final Cantor2Any<Y> f, final Cantor2Any<Y> g) {
		return forevery(new Cantor2Bool() {
			@Override
			public Boolean call(Cantor a) {
				return f.call(a).equals(g.call(a));
			}
		});
	}

	public <Y> BigInteger modulus(final Cantor2Any<Y> f) {
		return least(new Cantor() {
			@Override
			public Boolean call(final BigInteger n) {
				return forevery(new Cantor2Bool() {
					@Override
					public Boolean call(final Cantor a) {
						return forevery(new Cantor2Bool() {
							@Override
							public Boolean call(final Cantor b) {
								return !eq(n, a, b)
										|| f.call(a).equals(f.call(b));
							}
						});
					}
				});
			}
		});
	}

	public BigInteger least(final Cantor p) {
		if (p.call(BigInteger.ZERO))
			return BigInteger.ZERO;
		else
			return BigInteger.ONE.add(least(new Cantor() {
				@Override
				public Boolean call(BigInteger n) {
					return p.call(n.add(BigInteger.ONE));
				}
			}));
	}

	public boolean eq(BigInteger n, Cantor a, Cantor b) {
		if (n.equals(BigInteger.ZERO))
			return true;
		n = n.subtract(BigInteger.ONE);
		return a.call(n) == b.call(n) && eq(n, a, b);
	}

	public Cantor2Bool pointwiseand(final List<BigInteger> a) {
		return new Cantor2Bool() {			
			@Override
			public Boolean call(Cantor b) {
				boolean result = true;
				
				for ( BigInteger n : a)
					result = result && b.call(n);
				
				return result;
			}
		};
	}
	
	public boolean sameelements(List<BigInteger> a, List<BigInteger> b) {
		return equal(pointwiseand(a), pointwiseand(b));
	}
}
