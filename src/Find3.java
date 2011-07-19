
public class Find3 extends Find {
	@Override
	public Cantor find(final Cantor2Bool p) {
		return new LazyCantor() {
			@Override
			protected Cantor getImpl() {
				final Function<Void, Boolean> h = new Function<Void, Boolean>() {
					Boolean result;

					@Override
					public Boolean call(Void param) {
						if (result == null)
							result = !p.call(new PrependOp(false,
									find(new Cantor2Bool() {
										@Override
										public Boolean call(Cantor a) {
											return p.call(new PrependOp(false,
													a));
										}
									})));

						return result;
					}
				};

				return new PrependOp2(h, find(new Cantor2Bool() {
					@Override
					public Boolean call(Cantor a) {
						return p.call(new PrependOp2(h, a));
					}
				}));
			}
		};
	}
}
