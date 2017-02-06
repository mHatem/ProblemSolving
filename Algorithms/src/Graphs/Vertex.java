/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.ArrayList;

/**
 *
 * @author MHatem
 */
public class Vertex {
    private int id;
    private int value;
    private Vertex parent;
    private int edgeWeight;
    private ArrayList<Vertex> neighbors;
    private boolean  visited;

    public Vertex() {
        neighbors = new ArrayList<>();
        edgeWeight = Integer.MAX_VALUE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLabel() {
        return value;
    }

    public void setLabel(int value) {
        this.value = value;
    }

    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getEdgeWeight() {
        return edgeWeight;
    }

    public void setEdgeWeight(int edgeWeight) {
        this.edgeWeight = edgeWeight;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null )
            return false;
        if(obj.getClass() != this.getClass())
            return false;
        Vertex o = (Vertex)obj;
        return o.value == this.value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }
    
    @Override
    public String toString() {
    return "" + value;
  }
}
