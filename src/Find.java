import java.math.BigInteger;

public abstract class Find {
	protected Function<Cantor2Bool, Boolean> forsome;
	protected Function<Cantor2Bool, Boolean> forevery;

	public Find() {
		this.forsome = new Function<Cantor2Bool, Boolean>() {
			@Override
			public Boolean call(final Cantor2Bool p) {
				return p.call(find(p));
			}
		};
		this.forevery = new Function<Cantor2Bool, Boolean>() {
			@Override
			public Boolean call(final Cantor2Bool p) {
				return !forsome.call(new Cantor2Bool() {
					@Override
					public Boolean call(Cantor a) {
						return !p.call(a);
					}
				});
			}
		};
	}

	public abstract Cantor find(Cantor2Bool p);

	public <Y> boolean equal(final Cantor2Any<Y> f, final Cantor2Any<Y> g) {
		return forevery.call(new Cantor2Bool() {
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
				return forevery.call(new Cantor2Bool() {					
					@Override
					public Boolean call(final Cantor a) {
						return forevery.call(new Cantor2Bool() {							
							@Override
							public Boolean call(final Cantor b) {
								return !eq(n,a,b) || f.call(a).equals(f.call(b));
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
}
