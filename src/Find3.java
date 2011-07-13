import java.math.BigInteger;

public class Find3 extends Find {
	@Override
	public Cantor find(final Cantor2Bool p) {
		return new Cantor() {
			Cantor result;

			@Override
			public Boolean call(BigInteger param) {
				if (result == null)
					result = calcResult();

				return result.call(param);
			}

			private Cantor calcResult() {
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
