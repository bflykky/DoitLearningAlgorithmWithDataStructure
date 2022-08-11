package chap09;

import java.util.Comparator;

public class LinkedList<E> {
	class Node<E> {
		private E data;
		private Node<E> next;

		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;
	private Node<E> current;

	public LinkedList() {
		head = current = null;
	}

	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {
				current = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}

		return null;
	}

	public void addFirst(E obj) {
		Node<E> ptr = head;
		head = current = new Node<E>(obj, ptr);
	}

	public void addLast(E obj) {

		if (head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			while (ptr.next != null)
				ptr = ptr.next;

			ptr.next = current = new Node<E>(obj, null);
		}
	}

	public void removeFirst() {
		if (head != null)
			head = current = head.next;
	}

	public void removeLast() {
		if (head != null) {
			Node<E> priorPtr = head;
			Node<E> ptr = head.next;

			if (ptr == null)
				removeFirst();

			while(ptr.next != null) {
				priorPtr = ptr;
				ptr = ptr.next;
			}

			priorPtr.next = null;
			current = priorPtr;
		}
	}

	public void remove(Node p) {
		if (head != null) {
			Node<E> ptr = head;

			if (p == head)
				removeFirst();
			else {
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr.next == null)
						return;
				}
					ptr.next = p.next;
					current = ptr;
			}

		}
	}

	public void removeCurrentNode() {
		remove(current);
	}

	public void clear() {
		while (head != null)
			removeFirst();
		current = null;
	}

	public boolean next() {
		if (current == null || current.next == null)
			return false;
		else {
			current = current.next;
			return true;
		}
	}

	public void printCurrentNode() {
		if (current == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(current.data);
	}

	public void dump() {
		System.out.println("dump() 메소드 호출됨");
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}

	//----------------------------------Q1------------------------
	public void purge(Comparator<? super E> c) {
		if (head == null || head.next == null) {
			System.out.println("노드가 비었거나 머리 노드 1개밖에 존재하지 않습니다."); //지워 테스트 후에
			return;

		}
		Node<E> exteriorPtr = head;
		Node<E> ptr;
		E tmpData;
		boolean flag = false;

		while (exteriorPtr.next != null) {
			System.out.println("while문 실행됨");
			flag = false;
			tmpData = exteriorPtr.data;
			ptr = exteriorPtr.next;
			while (ptr != null) {
				if (c.compare(tmpData, ptr.data) == 0) {
					remove(ptr);
					flag = true;
				}
				ptr = ptr.next;
			}

			if (flag)
				remove(exteriorPtr);

			exteriorPtr = exteriorPtr.next;
		}
	}

	//-----------------------------Q2------------------------
	public E retrieve(int n) {
		Node<E> ptr = head;

		if (head == null || n < 0)
			return null;
		else {
			while (n >= 0) {
				if (n == 0)
					return ptr.data;
				else {
					if (ptr.next == null)
						return null;
					n--;
					ptr = ptr.next;
				}
			}
		}

		return null;
	}

	//------------------------------Q3-------------------------------


}
