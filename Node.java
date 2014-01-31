import java.util.ArrayList;



public class Node {

	private int Depth;
	private int fValue;
	private String state;
	
	public int alpha;
	public int beta;
	
	public ArrayList<Node> children;
    public Node parent;
	
    public Node(int de, int val, String name){
    	Depth = de;
    
    	fValue = val;
    	state = name;
    }
    
    
	//getters and setters
	
	
	


	public int getDepth()
	{
		return Depth;
	} public void setDepth(int depth){
		Depth = depth;
	}


	public int getfValue() {
		return fValue;
	} public void setfValue(int fValue) {
		this.fValue = fValue;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	
}
