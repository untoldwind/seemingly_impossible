
public class Find1 extends Find {
	@Override
	public Cantor find(final Cantor2Bool p) {
		return new LazyCantor() {
			@Override
			protected Cantor getImpl() {
				Cantor2Bool startWithFalse = new Cantor2Bool() {
					@Override
					public Boolean call(Cantor a) {
						return p.call(new PrependOp(false, a));
					}
				};
				if (forsome(startWithFalse)) {
					return new PrependOp(false, find(startWithFalse));
				} else {
					Cantor2Bool startWithTrue = new Cantor2Bool() {
						@Override
						public Boolean call(Cantor a) {
							return p.call(new PrependOp(true, a));
						}
					};

					return new PrependOp(true, find(startWithTrue));
				}
			}
		};
	}
}
