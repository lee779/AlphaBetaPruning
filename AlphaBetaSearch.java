
public class AlphaBetaSearch {

	private static final int NEGINF = -1000000000;
	private static final int POSINF = 1000000000;


	public int v;
	public int alpha = NEGINF;
	public int beta = POSINF;
	public static Tree<Node> maxMove;

	public int search(Tree<Node> tree){
		v = maxValue(tree, alpha, beta);
		
		for(int i = 0; i < tree.children.size(); i++){
			if(tree.children.get(i).data.beta == v){
				maxMove = tree.children.get(i);
			}
		}
		System.out.println("Expansion completed");
		return v;
		
	}

	public int maxValue(Tree<Node> tree, int alpha, int beta){
		System.out.println("Expanding node " + tree.data.getState() + ": alpha: "+ alpha + " beta: " + beta);
		tree.data.alpha = alpha;
		tree.data.beta = beta;
		int value; 
		if(tree.children.isEmpty()){ //terminal state
			
			return tree.data.getfValue();
		}
		else{ // expand node			
			value = NEGINF;
			//expand children
			for(int j = 0; j<  tree.children.size(); j++){
				value = Math.max(value, minValue(tree.children.get(j), alpha, beta));
				if(value >= beta){ // stops pruning
				//System.out.println("	Update    node " + tree.data.getState() +  ": alpha: " + alpha + " beta: " + value);
					if(j+1<tree.children.size()){
						for(int k = j+1; k < tree.children.size(); k++){
						System.out.println("Skipping expansion of Node: " +tree.children.get(k).data.getState() + " because it cannot make beta lower");
						}
						return value;}
				}
				else
				{
					alpha = Math.max(alpha, value);	
				}
				System.out.println("	Update    node " + tree.data.getState() +  ": alpha: " + alpha + " beta: " + beta);
				
				//update alpha beta values to the node to figure out best move for node A
				tree.data.alpha = alpha;
				tree.data.beta = beta;
			}
			return value;
		}
	}

	public int minValue(Tree<Node> tree, int alpha, int beta){
		System.out.println("Expanding node " + tree.data.getState() + ": alpha: "+ alpha + " beta: " + beta);
		tree.data.alpha = alpha;
		tree.data.beta = beta;
		int value; 
		if(tree.children.isEmpty()){ //terminal state
			
			return tree.data.getfValue();

		}
		else{ // expand node			
			value = POSINF;
			//expand children
			for(int i = 0; i < tree.children.size(); i++){
				value = Math.min(value, maxValue(tree.children.get(i), alpha, beta));
				
				if(value <= alpha){// stops pruning
					//System.out.println("	Update    node " + tree.data.getState() +  ": alpha: " + alpha + " beta: " + value);
					if(i+1<tree.children.size())
						for(int k = i+1; k < tree.children.size(); k++){
							System.out.println("Skipping expansion of Node: " +tree.children.get(k).data.getState() + " because it cannot make alpha higher");

						}
					return value;}
				else
				{
					beta = Math.min(beta, value);
				}
				System.out.println("	Update    node " + tree.data.getState() +  ": alpha: " + alpha + " beta: " + beta);
				tree.data.alpha = alpha;
				tree.data.beta = beta;
			}

			return value;

		}

	}
	public Tree<Node> createTree(){
		Tree<Node> a0 = new Tree<Node>(new Node(0,-1,"a0"));
		{
			Tree<Node> b0 = a0.addChild(new Node(1,-1,"b0"));
			{
				Tree<Node> c0 = b0.addChild(new Node(2,-1,"c0"));
				{
					Tree<Node> d0 = c0.addChild(new Node(3,-1,"d0"));
					{
						Tree<Node> e0 = d0.addChild(new Node(4,3,"e0"));
						Tree<Node> e1 = d0.addChild(new Node(4,-2,"e1"));
						Tree<Node> e2 = d0.addChild(new Node(4,1,"e2"));

					}
					Tree<Node> d1 = c0.addChild(new Node(3,-1,"d1"));
					{
						Tree<Node> e3 = d1.addChild(new Node(4,-6,"e3"));
					}
					Tree<Node> d2 = c0.addChild(new Node(3,-1,"d2"));
					{
						Tree<Node> e4 = d2.addChild(new Node(4,1,"e4"));
						Tree<Node> e5 = d2.addChild(new Node(4,-5,"e5"));
					}
				}
				Tree<Node> c1 = b0.addChild(new Node(2,5,"c1"));
				Tree<Node> c2 = b0.addChild(new Node(2,-1,"c2"));
				{
					Tree<Node> d3 = c2.addChild(new Node(3,-1,"d3"));
					{
						Tree<Node> e6 = d3.addChild(new Node(4,4,"e6"));
					}
					Tree<Node> d4 = c2.addChild(new Node(3,-1,"d4"));
					{
						Tree<Node> e7 = d4.addChild(new Node(4,2,"e7"));
						Tree<Node> e8 = d4.addChild(new Node(4,0,"e8"));
					}
				}

			}
			Tree<Node> b1 = a0.addChild(new Node(1,0,"b1"));
			{
				Tree<Node> c3 = b1.addChild(new Node(2,-1,"c3"));
				{
					Tree<Node> d5 = c3.addChild(new Node(3,-1,"d5"));
					{
						Tree<Node> e9 = d5.addChild(new Node(4,7,"e9"));
						Tree<Node> e10 = d5.addChild(new Node(4,2,"e10"));

					}
					Tree<Node> d6 = c3.addChild(new Node(3,-3,"d6"));

				}
				Tree<Node> c4 = b1.addChild(new Node(2,-1,"c4"));
				{
					Tree<Node> d7 = c4.addChild(new Node(3,-1,"d7"));
					{
						Tree<Node> e11 = d7.addChild(new Node(4,3,"e11"));
					}
					Tree<Node> d8 = c4.addChild(new Node(3,-1,"d8"));
					{
						Tree<Node> e12 = d8.addChild(new Node(4,6,"e12"));
						Tree<Node> e13 = d8.addChild(new Node(4,1,"e13"));
						Tree<Node> e14 = d8.addChild(new Node(4,2,"e14"));

					}
					Tree<Node> d9 = c4.addChild(new Node(3,8,"d9"));

				}
			}
			
		}
		return a0;
	}

	public static void main(String[] args)
	{
		AlphaBetaSearch absearch = new AlphaBetaSearch();
		System.out.println("\nValue of Max Node A0: " + absearch.search(absearch.createTree()));
		System.out.println("\nMove that Max Node A would make is: " + maxMove.data.getState());

	}
}
