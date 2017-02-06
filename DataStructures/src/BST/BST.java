/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author Mhatem
 */
public class BST {

    public TreeNode root;
    public int size = 0;

    public BST(Integer rootVal) {
        root = new TreeNode(rootVal);
        size = 1;
    }

    public void addNode(Integer val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        }

        TreeNode current = root;
        TreeNode parent = null;
        size++;
        while (true) {
            parent = current;
            if (val <= current.val) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }

            }
        }

    }

    public void deleteNode(int val) {
        if(root != null)
           root=  deleteNode(root,val);
    }
    private TreeNode deleteNode(TreeNode root,int val){
        if(val < root.val){
            root.left = deleteNode(root.left, val);  
        }else if(val > root.val){
            root.right = deleteNode(root.right, val);
        }else{
            if(root.left == null){
              return root.right;  
            }else if(root.right == null){
                return root.left;
            }
        TreeNode minNode = findMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, root.val);
        }
       return root; 
    }

    public TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public boolean find(Integer val) {
        if (root == null) {
            return false;
        }
        TreeNode tmp = root;
        while (tmp != null) {
            if (val == tmp.val) {
                return true;
            }
            if (val < tmp.val) {
                tmp = tmp.left;
            } else if (val > tmp.val) {
                tmp = tmp.right;
            }

        }
        return false;

    }

    public void display() {
        if (root != null) {
            print(root);
            System.out.println();
        }
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }
}
