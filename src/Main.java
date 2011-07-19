import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

	public void runModulus() {
		System.out.println("------------------------------");
		System.out.println("Run Modulus: " + find.getClass().getName());
		
		long start = System.currentTimeMillis();
		System.out.println("modulus (a -> 45000) = "
				+ find.modulus(new Cantor2Any<BigInteger>() {
					@Override
					public BigInteger call(Cantor param) {
						return BigInteger.valueOf(45000);
					}
				}));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("modulus (proj 1) = "
				+ find.modulus(new Proj(BigInteger.valueOf(1))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("modulus (proj 2) = "
				+ find.modulus(new Proj(BigInteger.valueOf(2))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("modulus (proj 3) = "
				+ find.modulus(new Proj(BigInteger.valueOf(3))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("modulus (proj 4) = "
				+ find.modulus(new Proj(BigInteger.valueOf(4))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("modulus (proj 5) = "
				+ find.modulus(new Proj(BigInteger.valueOf(5))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		System.out.println("modulus (proj 6) = "
				+ find.modulus(new Proj(BigInteger.valueOf(6))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}
	
	public void runSameelements() {
		System.out.println("------------------------------");
		System.out.println("Run sameelements: " + find.getClass().getName());

		long start = System.currentTimeMillis();
		System.out.println("sameelements1 = "
				+ find.sameelements(
						mklist(BigInteger.valueOf(6).pow(60), BigInteger.valueOf(5).pow(50), 1, 5, 6, 6, 8, 9, 3, 4, 6, 2, 4,6, 1, BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(700), 1, 1, 1, 3, BigInteger.valueOf(3).pow(30)),
						mklist(1, 2, 3, 4, 5, 6, 7, 8, 9, BigInteger.valueOf(3).pow(30), BigInteger.valueOf(5).pow(50), BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(70))));
		System.out.println((System.currentTimeMillis() - start) + " ms");

		start = System.currentTimeMillis();
		System.out.println("sameelements2 = "
				+ find.sameelements(
						mklist(BigInteger.valueOf(6).pow(60), BigInteger.valueOf(5).pow(50), 1, 5, 6, 6, 8, 9, 3, 4, 6, 2, 4,6, 1, BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(70), 1, 1, 1, 3, BigInteger.valueOf(3).pow(30)),
						mklist(1, 2, 3, 4, 5, 6, 7, 8, 9, BigInteger.valueOf(3).pow(30), BigInteger.valueOf(5).pow(50), BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(70))));
		System.out.println((System.currentTimeMillis() - start) + " ms");

		start = System.currentTimeMillis();
		System.out.println("sameelements3 = "
				+ find.sameelements(
						mklist(BigInteger.valueOf(6).pow(60), BigInteger.valueOf(5).pow(50), 1, 5, 6, 6, 8, 9, 3, 4, 6, 2, 4,6, 1, BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(70), 1, 1, 1, 3, BigInteger.valueOf(3).pow(30)),
						mklist(1, 2, 3, 4, 5, 6, 8, 9, BigInteger.valueOf(3).pow(30), BigInteger.valueOf(5).pow(50), BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(70))));
		System.out.println((System.currentTimeMillis() - start) + " ms");

		start = System.currentTimeMillis();
		System.out.println("sameelements3 = "
				+ find.sameelements(
						mklist(BigInteger.valueOf(6).pow(60), BigInteger.valueOf(5).pow(50), 1, 5, 6, 6, 8, 9, 3, 4, 6, 2, 4,6, 1, BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(70), 1, 1, 1, 3, BigInteger.valueOf(3).pow(30)),
						mklist(1, 2, 3, 4, 5, 6, 8, 9, BigInteger.valueOf(3).pow(30), BigInteger.valueOf(5).pow(50), BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(700))));
		System.out.println((System.currentTimeMillis() - start) + " ms");

		start = System.currentTimeMillis();
		System.out.println("sameelements3 = "
				+ find.sameelements(
						mklist(BigInteger.valueOf(6).pow(60), BigInteger.valueOf(5).pow(50), 1, 5, 6, 6, 8, 9, 3, 4, 6, 2, 4,6, 1, BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(700), 1, 1, 1, 3, BigInteger.valueOf(3).pow(30)),
						mklist(1, 2, 3, 4, 5, 6, 8, 9, BigInteger.valueOf(3).pow(30), BigInteger.valueOf(5).pow(50), BigInteger.valueOf(6).pow(60), BigInteger.valueOf(7).pow(700))));
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}

	List<BigInteger> mklist(Object... elements) {
		List<BigInteger> result = new ArrayList<BigInteger>(elements.length);
		
		for ( Object element : elements)
			if ( element instanceof BigInteger)
				result.add((BigInteger)element);
			else if ( element instanceof Integer)
				result.add(BigInteger.valueOf((Integer)element));
			else
				throw new RuntimeException("Unknown element type: " + element.getClass());
		return result;
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

		new Main(new Find1()).runModulus();
		new Main(new FindJ()).runModulus();

		new Main(new FindJ()).runSameelements();
	}
}
