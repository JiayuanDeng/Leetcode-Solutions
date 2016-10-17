/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> lenQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        lenQueue.offer(1);
        TreeNode node;
        int len, maxLen = 0;
        while(!nodeQueue.isEmpty()){
            node = nodeQueue.poll();
            len = lenQueue.poll();
            maxLen = len > maxLen ? len : maxLen;
            if (node.left != null){
                nodeQueue.offer(node.left);
                int leftLen = 1;
                if ((long)node.left.val == (long)node.val + 1){
                    leftLen = len + 1;
                }
                lenQueue.offer(leftLen);
            }
            if (node.right != null){
                nodeQueue.offer(node.right);
                int rightLen = 1;
                if ((long)node.right.val == (long)node.val + 1){
                    rightLen = len + 1;
                }
                lenQueue.offer(rightLen);
            }
        }
        return maxLen;
    }
}