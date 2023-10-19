package class09;

import java.io.*;
import java.util.ArrayList;

/**
 * 链表中点
 */
public class Code01_LinkedListMid {

	public static class Node {
		public int value;
		public Node next;

		public Node(int v) {
			value = v;
		}
	}
    //中点或者上中位点
	// head 头
	public static Node midOrUpMidNode(Node head) {
		//1个节点,2个节点,都是头
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		// 链表有3个点或以上
		Node slow = head.next;
		Node fast = head.next.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
    //中点或者下中位点
	public static Node midOrDownMidNode(Node head) {
		//1个节点是头
		if (head == null || head.next == null) {
			return head;
		}
		//2个或者2个以上
		Node slow = head.next;
		Node fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
    //中点或者上中位点前面一个节点
	public static Node midOrUpMidPreNode(Node head) {
		//1个节点,2个节点,都没有
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node slow = head;
		Node fast = head.next.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
    //中点或者下中位点前面一个节点,如果是偶数,则也是上中位数
	public static Node midOrDownMidPreNode(Node head) {
		//如果1个节点
		if (head == null || head.next == null) {
			return null;
		}
		//如果2个节点,则前1个节点是head
		if (head.next.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/**
	 * 停在中点后一个节点或者下中位点
	 * @param head
	 * @return
	 */
	public static Node myMidOrUpMidNextNode(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		//2个节点以上
		Node slow = head;
		Node fast = head;
		Node next = null;
		slow = head;
		fast = head;
		next = slow.next;//保持这个序的特性
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			next = slow.next;
		}
		return next;
	}




	/**
	 * 停在中点后一个节点或者下中位点后一个节点
	 * @param head
	 * @return
	 */
	public static Node myMidOrDownMidNextNode(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		if (head.next.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
        return slow;
	}

	public static Node myMidOrUpmidPreNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		//3个节点以上
		Node slow = head;
		Node fast = head;
		Node pre = null;
		slow = head.next;
		fast = head.next.next;
		pre = head;
		while (fast.next != null && fast.next.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return pre;
	}

	public static Node myMidOrDownmidPreNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		//3个节点以上
		Node slow = head;
		Node fast = head;
		Node pre = null;
		slow = head.next;
		fast = head.next;
		pre = head;
		while (fast.next != null && fast.next.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return pre;
	}

	public static Node right1(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arr = new ArrayList<>();
		while (cur != null) {
			arr.add(cur);
			cur = cur.next;
		}
		return arr.get((arr.size() - 1) / 2);
	}

	public static Node right2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arr = new ArrayList<>();
		while (cur != null) {
			arr.add(cur);
			cur = cur.next;
		}
		return arr.get(arr.size() / 2);
	}

	public static Node right3(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arr = new ArrayList<>();
		while (cur != null) {
			arr.add(cur);
			cur = cur.next;
		}
		return arr.get((arr.size() - 3) / 2);
	}

	public static Node right4(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arr = new ArrayList<>();
		while (cur != null) {
			arr.add(cur);
			cur = cur.next;
		}
		return arr.get((arr.size() - 2) / 2);
	}

	public static Node right5(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node cur = head;
		ArrayList<Node> arr = new ArrayList<>();
		while (cur != null) {
			arr.add(cur);
			cur = cur.next;
		}
		//
		return arr.get((arr.size() +1) / 2);
	}


	public static void main(String[] args) {
		Node test =  new Node(0);;
		testEven(test);
		Node ans1 = null;
		Node ans2 = null;

		ans1 = midOrUpMidNode(test);
		ans2 = right1(test);
		System.out.println(ans1 != null ? ans1.value : "无");
		System.out.println(ans2 != null ? ans2.value : "无");

		ans1 = midOrDownMidNode(test);
		ans2 = right2(test);
		System.out.println(ans1 != null ? ans1.value : "无");
		System.out.println(ans2 != null ? ans2.value : "无");

		ans1 = midOrUpMidPreNode(test);
		ans2 = right3(test);
		System.out.println(ans1 != null ? ans1.value : "无");
		System.out.println(ans2 != null ? ans2.value : "无");

		ans1 = midOrDownMidPreNode(test);
		ans2 = right4(test);
		System.out.println(ans1 != null ? ans1.value : "无");
		System.out.println(ans2 != null ? ans2.value : "无");


		//my test
		System.out.println("MYTest");
		ans1 = myMidOrUpmidPreNode(test);
		ans2 = right3(test);
		System.out.println(ans1 != null ? ans1.value : "无");
		System.out.println(ans2 != null ? ans2.value : "无");

		ans1 = myMidOrDownmidPreNode(test);
		ans2 = right4(test);
		System.out.println(ans1 != null ? ans1.value : "无");
		System.out.println(ans2 != null ? ans2.value : "无");

		ans1 = myMidOrUpMidNextNode(test);
		ans2 = right5(test);
		System.out.println(ans1 != null ? ans1.value : "无");
		System.out.println(ans2 != null ? ans2.value : "无");
	}
	//奇数
	public static void testOdd(Node test){
		test.next = new Node(1);
		test.next.next = new Node(2);
		test.next.next.next = new Node(3);
		test.next.next.next.next = new Node(4);
		test.next.next.next.next.next = new Node(5);
		test.next.next.next.next.next.next = new Node(6);
		test.next.next.next.next.next.next.next = new Node(7);
		test.next.next.next.next.next.next.next.next = new Node(8);
	}
	//偶数
	public static void testEven(Node test){
		test.next = new Node(1);
		test.next.next = new Node(2);
		test.next.next.next = new Node(3);
		test.next.next.next.next = new Node(4);
		test.next.next.next.next.next = new Node(5);
		test.next.next.next.next.next.next = new Node(6);
		test.next.next.next.next.next.next.next = new Node(7);
	}
}
