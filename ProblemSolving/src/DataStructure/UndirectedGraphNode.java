/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MHatem
 */
public class UndirectedGraphNode {

   public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    public boolean  visited;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
