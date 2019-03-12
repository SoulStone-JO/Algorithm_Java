package rb_tree;


public class TestMyRB_Tree {
	public static void main(String[] args) {
		RB_Tree rb_Tree = new RB_Tree();
		rb_Tree.addAll(3, 2, 4, 7, 6, 8, 1, 2, 3);
		System.out.println(rb_Tree);
		rb_Tree.del(3);
		System.out.println(rb_Tree);
		rb_Tree.del(2);
		rb_Tree.del(4);
		System.out.println(rb_Tree);
	}
}
