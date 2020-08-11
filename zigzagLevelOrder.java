/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> dq = new LinkedList<>();
        int lvl = 1;
        dq.add(root);
        while (!(dq.isEmpty())) {
            int count = dq.size();
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < count; i++) {
                if (lvl % 2 != 0) {
                    TreeNode temp = dq.poll();
                    list.add(temp.val);
                        
                    if (temp.left != null) {
                        dq.addLast(temp.left);
                    }
                    if (temp.right != null) {
                        dq.addLast(temp.right);
                    }
                }
                else {
                    TreeNode temp = dq.pollLast();
                    list.add(temp.val);
                    
                    if (temp.right != null) {
                        dq.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        dq.addFirst(temp.left);
                    }
                }     
            }
            lvl++;
            result.add(list);
        }
        return result;
    }
}