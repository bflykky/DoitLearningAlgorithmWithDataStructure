package chap10;

import java.util.Comparator;
import java.util.Stack;

public class BinTree<K, V> {
	private Node<K, V> root;
	private Comparator<? super K> comparator = null;

	public BinTree() {
		root = null;
	}

	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	static class Node<K, V> {
		private K key;
		private V data;
		private Node<K, V> left;
		private Node<K, V> right;

		Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		K getKey() {
			return key;
		}

		V getValue() {
			return data;
		}

		void print() {
			System.out.println(data);
		}
	}

	private int comp(K key1, K key2) {
		if (comparator == null)
			return ((Comparable<K>)key1).compareTo(key2);
		else
			return comparator.compare(key1, key2);
	}

	public V serach(K key) {
		Node<K, V> p = root;

		while (true) {
			if (p == null)
				return null;

			int cond = comp(key, p.getKey());
			if (cond > 0)
				p = p.right;
			else if (cond < 0)
				p = p.left;
			else
				return p.getValue();
		}
	}

	private void addNode(Node<K, V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond > 0) {
			if (node.right == null)
				node.right = new Node<>(key, data, null, null);
			else
				addNode(node.right, key, data);
		}
		else if (cond < 0) {
			if (node.left == null)
				node.left = new Node<>(key, data, null, null);
			else
				addNode(node.left, key, data);
		}
		else
			return;
	}

	public void add(K key, V data) {
		if (root == null)
			root = new Node<>(key, data, null, null);
		else
			addNode(root, key, data);
	}


	private void removeNodeWithTwoChild(Node<K, V> node) { //삭제해야 할 노드가 파라미터로 전달됨.
		Node<K, V> parent = node;
		Node<K, V> p = node.left;

		boolean isRightChild = false;
		while (p.right != null) {
			parent = p;
			p = p.right;
			isRightChild = true;
		}

		//삭제해야 할 노드에 좌측 서브 트리 중 가잔 큰 노드의 키, 값을 복사함.
		node.key = p.key;
		node.data = p.data;

		//p의 좌측 자식이 있다면 p의 부모 노드와 연결되고, p의 좌측 자식이 없다면 p의 부모 노드의 포인터가 null로 변경됨.
		if (isRightChild) //노드 p가 삭제된 노드의 위치로 이동되므로 그의 부모 노드의 right 또는 left 필드를 변경해줘야 함.
			parent.right = p.left;
		else
			parent.left = p.left;
	}

	public boolean remove(K key) {
		if (comp(key, root.getKey()) == 0) { //p가 루트일 때 우선 처리하는 if문 코드.
			if (root.left == null)
				root = root.right;
			else if (root.right == null)
				root = root.left;
			else //자식 2개를 갖고 있는 루트를 삭제해야 하는가?
				removeNodeWithTwoChild(root);

			return true;
		}

		Node<K, V> p = root;
		Node<K, V> parent = null;
		boolean isLeftChild = true;

		while (true) {
			if (p == null)
				return false;
			int cond = comp(key, p.getKey());

			if (cond == 0)
				break; //제거할 키 값을 가진 노드를 찾아서 while문을 빠져나감.
			else {
				parent = p; //노드를 제거한 후 부모 노드의 left 또는 right를 변경해야 하므로 parent 변수가 p의 부모노드를 참조하게 함.
				if (cond > 0) {
					isLeftChild = false;
					p = p.right;
				}
				else if (cond < 0) {
					isLeftChild = true;
					p = p.left;
				}
			}
		}

		if (p.left == null) { //삭제해야 할 노드가 왼쪽 자식이 없는가?
			if (isLeftChild) //삭제해야 할 노드가 부모의 왼쪽 자식인가?
				parent.left = p.right; //오른쪽 자식이 있다면 (자식 1개) 오른쪽 자식과 삭제 노드의 부모 노드와 연결함. 없다면(자식 0개) null이 대입됨.
			else //삭제해야 할 노드가 부모의 오른쪽 자식인가?
				parent.right = p.right; //오른쪽 자식이 있다면 (자식 1개) 오른쪽 자식과 삭제 노드의 부모 노드와 연결함. 없다면(자식 0개) null이 대입됨.
		}
		else if (p.right == null) {
			if (isLeftChild)
				parent.left = p.left;
			else
				parent.right = p.left;
		}
		else//삭제해야 할 노드가 왼쪽 오른쪽 자식 모두 가지고 있는가?(자식 2개)
			removeNodeWithTwoChild(p);

		return true;
	}

	private void printSubTree(Node<K, V> node) {
//		재귀적 구현
//		if (node != null) {
//			printSubTree(node.left);
//			System.out.println(node.key + " " + node.data);
//			printSubTree(node.right);
//		}

//----------------------------------------------------------------

//		비재귀적 구현
		Stack<Node> n = new Stack<>();

		while (true) {
			if (node != null) {
				n.push(node);
				node = node.left;
				continue;
			}

			if (!n.empty()) {
				node = n.pop();
				System.out.println(node.key + " " + node.data);
				node = node.right;
				continue;
			}
			break;
		}
	}

	public void print() {
		printSubTree(root);
	}

	//------------------------Q1---------------------------
	private void printSubTreeReverse(Node<K, V> node) {
//		재귀적 구현
//		if (node != null) {
//			printSubTreeReverse(node.right);
//			System.out.println(node.key + " " + node.data);
//			printSubTreeReverse(node.left);
//		}

		//----------------------------------------------------------------

//		비재귀적 구현
		Stack<Node> n = new Stack<>();

		while (true) {
			if (node != null) {
				n.push(node);
				node = node.right;
				continue;
			}

			if (!n.empty()) {
				node = n.pop();
				System.out.println(node.key + " " + node.data);
				node = node.left;
				continue;
			}
			break;
		}
	}

	public void printReverse() { //내림차순 출력
		//내림차순 출력이면, 중위 전회지만 우측 자식에 먼저 방문을 하는 형식이어야 함.
		printSubTreeReverse(root);
	}


	//-----------------------------Q2-----------------------------

	private Node<K, V> getMinNode() {
		if (root == null) {
			return null;
		}
		Node<K, V> p = root;
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}

	private Node<K, V> getMaxNode() {
		if (root == null) {
			return null;
		}
		Node<K, V> p = root;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}
	public K getMinKey() {
		Node<K, V> node = getMinNode();
		if (node == null)
			return null;
		else
			return node.getKey();
	}

	public V getDataWithMinKey() {
		Node<K, V> node = getMinNode();
		if (node == null)
			return null;
		else
			return node.getValue();
	}

	public K getMaxKey() {
		Node<K, V> node = getMaxNode();
		if (node == null)
			return null;
		else
			return node.getKey();
	}

	public V getDataWithMaxKey() {
		Node<K, V> node = getMaxNode();
		if (node == null)
			return null;
		else
			return node.getValue();
	}



}
