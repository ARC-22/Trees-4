// Time Complexity : O(K)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

// recursive TC O(k), SC O(h)
// class Solution {
//     int cnt, answer;
//     public int kthSmallest(TreeNode root, int k) {
//         if(root == null){
//             return -1;
//         }
//         cnt = k;
//         answer = -1;
//         inorder(root);
//         return answer;
//     }
//     private void inorder(TreeNode root){
//         if(root == null || answer != -1){ // optimization
//             return;
//         }
//         inorder(root.left);
//         cnt--;
//         if(cnt == 0){
//             answer = root.val;
//             return;
//         }
//         inorder(root.right);
//     }
// }
// iterartive TC O(k), SC O(h)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }

        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k==0){
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}