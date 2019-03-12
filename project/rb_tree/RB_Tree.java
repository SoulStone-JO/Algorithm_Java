package rb_tree;

public class RB_Tree {
	RBTNode rootNode;
	int size = 0;
	
	//constructor生成空树
	public RB_Tree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// left-mid-right,左中右遍历返回一个StringBuffer类型的有序数列
	public StringBuffer traversal(RBTNode temp, StringBuffer sb) {
		if(temp.leftChild != null) {
			traversal(temp.leftChild, sb);
		}
		sb.append(temp.element).append("  ");		
		if (temp.rightChild != null) {
			traversal(temp.rightChild, sb);
		}
		return sb;
	}

	//查，返回满二叉树所在的index，没有返回-1
	public int research(int ele) {
		if (rootNode == null) 
			return -1;//根为空
		RBTNode temp = rootNode;
		int index = 0;
		while (temp != null && temp.element != ele) {
			if (ele - temp.element < 0) {
				temp = temp.leftChild;
				index = 2 * index + 1;
			} 
			else if(ele - temp.element > 0){
				temp = temp.rightChild;
				index = 2 * index + 2;
			} 
				
		}
		if (temp == null) 
			return -1;
		else
			return index;
	}
	
	//查，返回值所在节点的引用
	private RBTNode researchNode(int ele) {
		if (rootNode == null) 
			return null;//根为空
		RBTNode temp = rootNode;
		while (temp != null && temp.element != ele) {
			if (ele - temp.element < 0) 
				temp = temp.leftChild;
			else if(ele - temp.element > 0)
				temp = temp.rightChild;
		}
		if (temp == null) 
			return null;
		else
			return temp;
	}
	
	//增
	public void add(int ele) {
		insert(ele);
		size++;
	}
	
	//多个增加
	public void addAll(int... ele) {
		for (int i : ele) {
			add(i);
		}
	}
	
	//插入，也是生成的方法
	private boolean insert(int ele) {
		RBTNode tempNode = rootNode;
		RBTNode newNodeParent = null;//存放要插入节点处的parent节点
		RBTNode newNode = new RBTNode(null, null, null, ele, Color.RED);//构造新节点
		
		while(tempNode != null) {
			newNodeParent = tempNode;
			if (ele - tempNode.element < 0)
				tempNode = tempNode.leftChild;
			else if (ele - tempNode.element > 0)
				tempNode = tempNode.rightChild;
			else {
				size--;
				return false;		
			}
		}
		if (newNodeParent != null) {
			if (ele - newNodeParent.element < 0 ) 
				newNodeParent.leftChild = newNode;
			else if (ele - newNodeParent.element > 0) 
				newNodeParent.rightChild = newNode;
		}else {
			rootNode = newNode;
		}
		
		newNode.parentNode = newNodeParent;
		// 此处需要insert_fix操作insertFix()
		return true;	
	}
	
	//转移一棵子树v到另一棵u上
	private void transplant(RBTNode u, RBTNode v) {
		if(u.parentNode == null) 
			rootNode = v;
		else if (u.parentNode.leftChild == u) 
			u.parentNode.leftChild = v;
		else 
			u.parentNode.rightChild = v;
		if(v != null) 
			v.parentNode = u.parentNode;	
	}
	
	//最小数，返回子树，最小节点
	public RBTNode treeMinimum(RBTNode x) {
		while(x.leftChild != null)
			x = x.leftChild;
		return x;
	}

	//节点的删除
	private void delete(RBTNode z) {
		RBTNode y = new RBTNode();
		if (z.leftChild == null) 
			transplant(z, z.rightChild);
		else if (z.rightChild == null) 
			transplant(z, z.leftChild);
		else {
			y = treeMinimum(z.rightChild);
			if (y.parentNode != z) {
				transplant(y, y.rightChild);
				y.rightChild = z.rightChild;
				y.rightChild.parentNode = y;
			}
			transplant(z, y);
			y.leftChild = z.leftChild;
			y.leftChild.parentNode = y;
		} 
		//需要 fix
	}

	//按照value删除
	public void del(int value) {
		RBTNode tempNode = researchNode(value);
		if (tempNode == null) {
			System.out.println("删除失败，原因你自己清楚。");
		}else {
			delete(tempNode);
			size--;
		}
	}

	//左旋
	private void left_rotate() {
		
	}
	
	//右旋
	private void right_rotate() {
		
	}
	
	//插入调整颜色
	private void RB_InsertFixup() {
		
	}
	
	//删除重新编写
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		return traversal(rootNode, sb).toString();
	}

	//私有内部类存放RBTNode节点
	private class RBTNode{
		RBTNode parentNode;
		RBTNode leftChild;
		RBTNode rightChild;
		int element;
		Color color;
		//constructor
		public RBTNode() {
			// TODO Auto-generated constructor stub
		}
		public RBTNode(RBTNode parentNode, RBTNode leftChild, RBTNode rightChild, int element, Color color) {
			super();
			this.parentNode = parentNode;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.element = element;
			this.color = color;
		}
			
	}
	
}

enum Color{
	RED,BLACK;
}