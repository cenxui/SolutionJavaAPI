package map;


public class SolutionTreeNode<K, V> {
	private TreeNode<K, V> treeNode;
	
	public void put(K k,V v) {
		if (treeNode == null) {
			treeNode = new TreeNode<>();	
			treeNode.key = k;
			treeNode.val = v;
			return;
		}
		
		addNode(k, v, treeNode);
		
	}
	
	public V get(K k) {
		return getNode(k, treeNode);
	}
	
	private V getNode(K k, TreeNode<K, V> treeNode) {
		if (treeNode == null) return null;
		
		if (k == treeNode.key) {
			return treeNode.val;
		}else if (k.hashCode() < treeNode.key.hashCode()) {
			return getNode(k, treeNode.left);
		}else {
			return getNode(k, treeNode.right);
		}	
	}
	
	private void addNode(K k, V v, TreeNode<K,V> treeNode) {
		
		if (k.hashCode() < treeNode.key.hashCode()) {
			if (treeNode.left == null ) {
				treeNode.left = new TreeNode<>();
				treeNode.left.key = k;
				treeNode.left.val = v;
			}else {
				addNode(k, v, treeNode.left);
			}			
		}else {
			if (treeNode.right == null) {
				treeNode.right = new TreeNode<>();
				treeNode.right.key = k;
				treeNode.right.val = v;
				
			}else {
				addNode(k, v, treeNode.right);
			}
		}
	}
	
	private static class TreeNode<K, V> {
		TreeNode<K, V> left;
		TreeNode<K, V> right;
		
		V val;
		K key;
	}

	public static void main(String[] args) {
		SolutionTreeNode<String, Integer> treeNode = new SolutionTreeNode<>();
		
		treeNode.put("F", 6);
		treeNode.put("D", 4);
		treeNode.put("B", 2);
		treeNode.put("E", 5);
		treeNode.put("A", 1);
		treeNode.put("C", 3);
		
		System.out.println(treeNode.get("F") == 6);
		System.out.println(treeNode.get("D") == 4);
		System.out.println(treeNode.get("B") == 2);
		System.out.println(treeNode.get("E") == 5);
		System.out.println(treeNode.get("A") == 1);
		System.out.println(treeNode.get("C") == 10);

	}

}
