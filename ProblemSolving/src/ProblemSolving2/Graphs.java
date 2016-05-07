/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemSolving2;

import DataStructure.UndirectedGraphNode;
import DataStructure.*;
import java.util.ArrayList;

/**
 * Graphs algorithms and  problems solving
 * @author MHatem
 */
public class Graphs {
    
    private UndirectedGraphNode getUnvisitedChild(UndirectedGraphNode node){
        ArrayList<UndirectedGraphNode> children = node.neighbors;
        
        for (UndirectedGraphNode child : children) {
            if(!child.visited)
                return child;
      }
        return null;
    }
    public void DFS(UndirectedGraphNode root){
        Stack s = new Stack();
        s.push(root);
        root.visited = true;
        // what you want to do in DFS
        System.out.print(root.label + " ");
        while(!s.isEmpty()){
            UndirectedGraphNode node =   (UndirectedGraphNode) s.top();
            UndirectedGraphNode child = getUnvisitedChild(node);
            if(child != null){
                child.visited = true;
                // what you want to do in DFS
                System.out.print(child.label+" ");
                s.push(child);
            }
            else
                s.pop();
        }
    }
    
    public void BFS(UndirectedGraphNode root){
        Queue q = new Queue();
        q.enqueue(root);
        root.visited = true;
        // what you want to do in BSF
        System.out.print(root.label + " ");
        while(!q.isEmpty()){
             UndirectedGraphNode node =   (UndirectedGraphNode) q.dequeue();
             UndirectedGraphNode child = null;
             while((child = getUnvisitedChild(node)) != null){
                  child.visited = true;
                // what you want to do in BSF
                System.out.print(child.label+" ");
                q.enqueue(child);
             }
        }
    }
    
}
