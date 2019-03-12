package linkedlist;

public class MyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedList myLL = new DoublyLinkedList();
		myLL.addLast("hello");
		System.out.println(myLL.Getfirst());
		System.out.println(myLL.GetLast());
		myLL.addLast("my");
		myLL.addLast("MyLinkedList");
		System.out.println(myLL.searchByIndex(2));
		myLL.printAllStrs();
	}
}
