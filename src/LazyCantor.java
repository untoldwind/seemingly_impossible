import java.math.BigInteger;

public abstract class LazyCantor implements Cantor {
	Cantor impl;

	@Override
	public Boolean call(BigInteger param) {
		if (impl == null)
			impl = getImpl();

		return impl.call(param);
	}

	protected abstract Cantor getImpl();
}
