package solution.microsoft;

import common.TreeNode;

public class NO68lowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.getVal() < p.getVal() && root.getVal() < q.getVal()) {
            return lowestCommonAncestor(root.getRight(), p, q);
        } else if (root.getVal() > p.getVal() && root.getVal() > q.getVal()) {
            return lowestCommonAncestor(root.getLeft(), p, q);
        }
        return root;
    }
}
