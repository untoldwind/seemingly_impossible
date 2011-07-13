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
}
