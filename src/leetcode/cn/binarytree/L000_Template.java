package leetcode.cn.binarytree;

import leetcode.cn.binarytree.model.TreeNode;

public class L000_Template {
    public static void main(String[] args) {

    }

    public void traverse(TreeNode root) {
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
    }
}
