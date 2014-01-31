import java.util.ArrayList;


public class Tree<T> {

	    T data;
	    Tree<T> parent = null;
	    ArrayList<Tree<T>> children;

	    public Tree(T data) {
	        this.data = data;
	        this.children = new ArrayList<Tree<T>>();
	    }

	    public Tree<T> addChild(T child) {
	        Tree<T> childNode = new Tree<T>(child);
	        childNode.parent = this;
	        this.children.add(childNode);
	        return childNode;
	    }
	    
	    
	   
}
