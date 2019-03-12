package linkedlist;

public class DoublyLinkedList {
	private int size;
	private Node firstNode;
	private Node lastNode;
	
	//constructor
	public DoublyLinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	//method
	/**
	 * 得到第一个节点存储的string值
	 * @return string
	 * */
	public String Getfirst() {
		return firstNode.str;
	}
	
	/**
	 * 得到最后一个节点存储的string值
	 * @return string
	 * */
	public String GetLast() {
		return lastNode.str;
	}
	/**
	 * 从最后一个节点向后存放值
	 * 
	 * */
	public void addLast(String str) {
		final Node tempNode = lastNode;
		final Node newNode = new Node(tempNode, str, null);
		lastNode = newNode;
		if (tempNode == null)// tempNode 存放原来 lastNode的地址
			firstNode = newNode;
		else
			tempNode.rightNode = newNode;
		size++;
	}
	/**
	 * 按索引查找对应的String字符串
	 * 
	 * */
	public String searchByIndex(int index) {
		//index 超出范围异常 
		Node tempNode = firstNode;
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.rightNode;
		}
		return tempNode.str;
	}
	/**
	 * 打印所有节点上的String字符串
	 * 
	 * */
	public void printAllStrs() {
		Node tempNode = firstNode;
		for (;tempNode.rightNode != null;tempNode = tempNode.rightNode) {
			System.out.print(tempNode.str+"  ");
		}
		System.out.println(tempNode.str);
	}
	class Node{
		Node leftNode;
		Node rightNode;
		String str;

		//constructor
		public Node(Node leftNode, String str, Node rightNode) {
			super();
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.str = str;
		}
		
		
	}
}
