import java.math.BigInteger;

public class Main {
	Find find;

	public Main(Find find) {
		this.find = find;
	}

	long coerce(boolean b) {
		return b ? 1 : 0;
	}

	public void run() {
		Cantor2Any<Long> f, g, h;

		f = new Cantor2Any<Long>() {
			@Override
			public Long call(Cantor a) {
				return coerce(a.call(BigInteger.valueOf(7
						* coerce(a.call(BigInteger.valueOf(4L))) + 4
						* (coerce(a.call(BigInteger.valueOf(7L)))) + 4)));
			}
		};
		g = new Cantor2Any<Long>() {
			@Override
			public Long call(Cantor a) {
				return coerce(a.call(BigInteger.valueOf(coerce(a
						.call(BigInteger.valueOf(4L)))
						+ 11
						* (coerce(a.call(BigInteger.valueOf(7L)))))));
			}
		};
		h = new Cantor2Any<Long>() {
			@Override
			public Long call(Cantor a) {
				if (a.call(BigInteger.valueOf(7L)) == false)
					return a.call(BigInteger.valueOf(4L)) == false ? coerce(a
							.call(BigInteger.valueOf(4L))) : coerce(a
							.call(BigInteger.valueOf(11L)));
				else
					return a.call(BigInteger.valueOf(4L)) == true ? coerce(a
							.call(BigInteger.valueOf(15L))) : coerce(a
							.call(BigInteger.valueOf(8L)));
			}
		};

		System.out.println("------------------------------");
		System.out.println("Run 1: " + find.getClass().getName());
		long start = System.currentTimeMillis();
		System.out.println("equal f g = " + find.equal(f, g));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal f h = " + find.equal(f, h));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal g h = " + find.equal(g, h));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal f f = " + find.equal(f, f));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal g g = " + find.equal(g, g));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal h h = " + find.equal(h, h));
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}

	public void run2() {
		System.out.println("------------------------------");
		System.out.println("Run 2: " + find.getClass().getName());
		long start = System.currentTimeMillis();
		System.out.println("equal proj 10 proj 10 = "
				+ find.equal(new Proj(10), new Proj(10)));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal proj 10 proj 15 = "
				+ find.equal(new Proj(10), new Proj(15)));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal proj 10 proj 20 = "
				+ find.equal(new Proj(10), new Proj(20)));
		System.out.println((System.currentTimeMillis() - start) + " ms");

	}

	public void run3() {
		System.out.println("------------------------------");
		System.out.println("Run 3: " + find.getClass().getName());
		long start = System.currentTimeMillis();
		System.out.println("equal proj 1000 proj 1000 = "
				+ find.equal(new Proj(1000), new Proj(1000)));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal proj 600 proj 500 = "
				+ find.equal(new Proj(600), new Proj(500)));
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}

	public void run4() {
		System.out.println("------------------------------");
		System.out.println("Run 4: " + find.getClass().getName());
		long start = System.currentTimeMillis();
		System.out.println("equal proj 2^300 proj 2^300 = "
				+ find.equal(new Proj(BigInteger.valueOf(2).pow(300)),
						new Proj(BigInteger.valueOf(2).pow(300))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal proj 2^300 proj 2^400 = "
				+ find.equal(new Proj(BigInteger.valueOf(2).pow(300)),
						new Proj(BigInteger.valueOf(2).pow(400))));
		System.out.println((System.currentTimeMillis() - start) + " ms");

		Cantor2Any<Long> f, g, h;

		f = new Cantor2Any<Long>() {
			@Override
			public Long call(Cantor a) {
				return coerce(a.call(BigInteger.valueOf(10
						* coerce(a.call(BigInteger.valueOf(3).pow(80))) + 100
						* coerce(a.call(BigInteger.valueOf(4).pow(80))) + 1000
						* coerce(a.call(BigInteger.valueOf(5).pow(80))))));
			}
		};
		g = new Cantor2Any<Long>() {
			@Override
			public Long call(Cantor a) {
				return coerce(a.call(BigInteger.valueOf(10
						* coerce(a.call(BigInteger.valueOf(3).pow(80))) + 100
						* coerce(a.call(BigInteger.valueOf(4).pow(80))) + 1000
						* coerce(a.call(BigInteger.valueOf(6).pow(80))))));
			}
		};
		h = new Cantor2Any<Long>() {
			@Override
			public Long call(Cantor a) {
				int i = coerce(a.call(BigInteger.valueOf(5).pow(80))) == 0 ? 0
						: 1000;
				int j = coerce(a.call(BigInteger.valueOf(3).pow(80))) == 1 ? 10 + i
						: i;
				int k = coerce(a.call(BigInteger.valueOf(4).pow(80))) == 0 ? j
						: 100 + j;

				return coerce(a.call(BigInteger.valueOf(k)));
			}
		};

		start = System.currentTimeMillis();
		System.out.println("equal f' g' = " + find.equal(f, g));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal f' h' = " + find.equal(f, h));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal g' h' = " + find.equal(g, h));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal f' f' = " + find.equal(f, f));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal g' g' = " + find.equal(g, g));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("equal h' h' = " + find.equal(h, h));
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}

	public static void main(String[] args) {
		new Main(new Find1()).run();
		new Main(new Find2()).run();
		new Main(new Find3()).run();
		new Main(new Find1()).run2();
		new Main(new Find3()).run2();
		new Main(new Find3()).run3();

		new Main(new FindJ()).run();
		new Main(new FindJ()).run2();
		new Main(new FindJ()).run3();
		new Main(new FindJ()).run4();

	}
}
