/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author MHatem
 */
public class BSTNode {
    
    private Integer data;
    private BSTNode left;
    private BSTNode right;
    
    public BSTNode() {
        data = null;
        left = right = null;
    }
    public BSTNode(Integer data){
        left = right = null;
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
    
}
