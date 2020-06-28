package leetcode.cn.binarytree;

import leetcode.cn.binarytree.model.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L124_二叉树中的最大路径和 {
    private static int result;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }


    public static int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        travel(root);
        return result;
    }

    private static int travel(TreeNode root) {
        // 后序遍历
        if (root == null) {
            return 0;
        }
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int left = Math.max(travel(root.left), 0);
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int right = Math.max(travel(root.right), 0);

        int value = root.val + left + right;
        //left->root->right 作为路径与历史最大值做比较
        result = Math.max(result, value);
        // 返回经过root的单边最大分支给上游
        return root.val + Math.max(left, right);
    }
}
