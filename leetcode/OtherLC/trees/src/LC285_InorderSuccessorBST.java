/*
Q-https://leetcode.com/problems/inorder-successor-in-bst/description/
**Approaches**
Idea - the basic idea is that if the given node p has a right subtree, the inorder successor of p will be the left most non-null node in the right subtree, if it doesn't have a right subtree, we have to search for the successor in the ancestors using the root pointer. For the second case there are two approaches, we can consider the tree as a normal binary tree in which case we would have to search the entire tree to find the successor. The second approach is to use the BST property and compare p.val with root.val and either search in the left subtree or the right subtree based on this property thereby pruning the search space.

1. DFS without using BST property
* if p.right is not null, keep moving left until node.left is not null then return node.
* if p.right is null, invoke the dfs method by passing the root, p, and previous node as null
* Within the recursive function, if root is null we return null, if root is equal to p, the previous node will be the successor so return it
* We then invoke the recursive function for the left subtree by passing in the previous node as root (because the successor of a node in the left subtree will be the first parent from which we moved left and found p), we pass previous as the same for the right subtree because in the inorder traversal, root will already be visited and when we find p in the right subtree, its successor will come later and not the ancestor. We store the return values in left and right variables.
* We then return whichever of the two left and right is not null, null if both are null

*Time complexity* - O(N), we traverse the entire tree in the worst case
*Space complexity* - O(H), where H is the height of the tree (for recursive call stack) -> if tree is balanced this is O(logN) else O(N) for a skewed tree.

2. DFS using BST property
* if p.right is not null, keep moving left until node.left is not null then return node.
* if p.right is null, invoke the dfs method by passing the root, p, and previous node as null
* Within the recursive function, if root is null we return null, if root is equal to p, the previous node will be the successor so return it
* if root.val > p.val invoke the recursive call on left subtree, else recurse on the right subtree by passing previous as root for the left subtree and previous as previous unchanged for the right subtree
* return whatever the recursive calls return

*Time complexity* - O(H), where H is the height of the tree -> O(logN) if BST is balanced, O(N) if skewed
*Space complexity* - O(H) -> recursive call stack

 */
public class LC285_InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p == null)return null;

        // if node p has a right subtree
        if(p.right != null)return findSuccessor(p.right);

        // if node p doesn't have a right subtree
        return findAncestor(root, p, null);
    }

    private TreeNode findSuccessor(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    // doesn't use the BST property, considers the tree as a normal binary tree
    private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode previous){
        if(root == null)return null;
        if(root == p)return previous;

        TreeNode left = findAncestor(root.left, p, root);
        TreeNode right = findAncestor(root.right, p, previous);

        return left != null ? left : right;
    }

    // using the BST property
    private TreeNode findAncestorBST(TreeNode root, TreeNode p, TreeNode previous){
        if(root == null)return null;
        if(root == p)return previous;

        if(root.val > p.val){
            return findAncestorBST(root.left, p, root);
        }else{
            return findAncestorBST(root.right, p, previous);
        }
    }
}
