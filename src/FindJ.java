import java.math.BigInteger;

public class FindJ extends Find {

	@Override
	public Cantor find(Cantor2Bool p) {
		CantorTree tree = new CantorTree();

		while (!p.call(tree)) {
			if (!tree.nextState())
				break;
		}

		return tree;
	}

	class CantorTree extends Cantor {
		Node root;

		@Override
		public Boolean call(BigInteger param) {
			if (root == null) {
				root = new Node(param);

				return root.getResult();
			} else {
				Node last = root;
				Node next;

				while (!last.getValue().equals(param)
						&& (next = last.getNextActive()) != null) {
					last = next;
				}

				if (last.getValue().equals(param))
					return last.getResult();
				else {
					next = new Node(param);

					last.addActive(next);

					return next.getResult();
				}
			}
		}

		public boolean nextState() {
			Node last = root;

			while (last != null && last.getNextActive() != null) {
				last = last.getNextActive();
			}

			if (last == null)
				return false;

			while (last != null && !last.nextState()) {
				last = last.getParent();
			}

			return last != null;
		}
	}

	class Node {
		Node parent;
		Node left;
		Node right;
		BigInteger value;
		boolean result;

		public Node(BigInteger value) {
			this.value = value;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public BigInteger getValue() {
			return value;
		}

		public boolean getResult() {
			return result;
		}

		public Node getNextActive() {
			return result ? right : left;
		}

		public void addActive(Node next) {
			if (result) {
				if (right != null)
					throw new RuntimeException("Right node alread present for "
							+ value);
				right = next;
				right.setParent(this);
			} else {
				if (left != null)
					throw new RuntimeException("Left node alread present for "
							+ value);
				left = next;
				left.setParent(this);
			}
		}

		public boolean nextState() {
			if (!result) {
				result = true;

				return true;
			}

			return false;
		}
	}

}
