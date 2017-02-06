/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author MHatem
 * @param <T>
 */
public class BSTree {

    private BSTNode root;

    public BSTree(Integer rootData) {
        root = new BSTNode(rootData);
    }

    public boolean insert(Integer data) {
        BSTNode in = null;
        BSTNode tmp = root;
        while (tmp.getLeft() != null && tmp.getRight() != null) {
            if (data < tmp.getData()) {
                tmp = tmp.getLeft();
            } else if (data > tmp.getData()) {
                tmp = tmp.getRight();
            } else if (Objects.equals(data, tmp.getData())) {
                return false;
            }
        }
        in = new BSTNode(data);
        if (data > tmp.getData()) {
            tmp.setRight(in);
        } else {
            tmp.setLeft(in);
        }
        return true;
    }

    public void preOrderTraversal(BSTNode root) {
        BSTNode tmp = root;
        if (tmp == null) {
            return;
        }
        System.out.println(tmp.getData());
        preOrderTraversal(tmp.getLeft());
        preOrderTraversal(tmp.getRight());

    }

    public void postOrderTraversal(BSTNode root) {
        BSTNode tmp = root;
        if (tmp == null) {
            return;
        }
        
        postOrderTraversal(tmp.getLeft());
        postOrderTraversal(tmp.getRight());
        System.out.println(tmp.getData());

    }

    public void inOrderTraversal(BSTNode root) {
        BSTNode tmp = root;
        if (tmp == null) {
            return;
        }

        inOrderTraversal(tmp.getLeft());
        System.out.println(tmp.getData());
        inOrderTraversal(tmp.getRight());

    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    public int isBalanced(BSTNode a) {

        if (a == null) {
            return 0;
        }

        int left = isBalanced(a.getLeft());
        int right = isBalanced(a.getRight());

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }

    public void BFS(BSTNode root) {
        Queue q = new Queue();
        Queue qTmp = new Queue();
        BSTNode tmp = root;
        if (tmp != null) {
            q.enqueue(tmp);
            while (0 != q.size()) {
                BSTNode item = (BSTNode) q.dequeue();
                System.out.print(item.getData() + " ");
                if (item.getLeft() != null) {
                    qTmp.enqueue(item.getLeft());
                }
                if (item.getRight() != null) {
                    qTmp.enqueue(item.getRight());
                }
                if (q.size() == 0) {
                    q = qTmp;
                    qTmp = new Queue();
                }
            }
        }
    }
    /*
    Given a binary tree, return the level order traversal of its nodes’ values. 
    (ie, from left to right, level by level).
    */
    public ArrayList<ArrayList<Integer>> levelOrder(BSTNode a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> resTmp = new ArrayList<>();
        Queue q = new Queue();
        Queue qTmp = new Queue();
        BSTNode tmp = root;
        if (tmp != null) {
            q.enqueue(tmp);
            while (0 != q.size()) {
                BSTNode item = (BSTNode) q.dequeue();
                resTmp.add(item.getData());
                System.out.print(item.getData() + " ");
                if (item.getLeft() != null) {
                    qTmp.enqueue(item.getLeft());
                }
                if (item.getRight() != null) {
                    qTmp.enqueue(item.getRight());
                }
                if (q.isEmpty()) {
                    q = qTmp;
                    qTmp = new Queue();
                    res.add(resTmp);
                    resTmp =  new ArrayList<>();
                }
            }
        }

        return res;
    }

}
