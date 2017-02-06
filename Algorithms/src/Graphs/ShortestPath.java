/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author MHatem
 */
public class ShortestPath {
    PriorityQueue<Vertex> spt = new PriorityQueue<>();
    
    public void dijkstra(Vertex root){
        
        spt.add(root);
        
        ArrayList<Vertex> neighbors = root.getNeighbors();
        
        for(int i = 0 ; i < neighbors.size(); i ++){
            
        }
    }
}
