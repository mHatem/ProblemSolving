/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Mhatem
 */
public class Graph {
    private final int nodes, edges;
    private final boolean isDirected;
    private LinkedList<Integer> graph [] = null;

    public Graph(int n, int m,boolean isDirected) {
        nodes = n;
        edges = m;
        graph =  new LinkedList[n+1];
        this.isDirected = isDirected;
    }
    
    public void buildGraph(int [] n1 , int [] n2){
        for(int k = 0 ; k < edges ; k++) {
                graph[n1[k]].add(n2[k]);
                if(!isDirected)
                    graph[n2[k]].add(n1[k]);
            }
    }
    
    public void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
         boolean [] visited = new boolean[nodes];
         
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            System.out.print(node + " ");
            
            for (Integer adj : graph[node]) {
                if(!visited[adj] )
                    queue.add(adj);
            }
        }
    }
    
    public void DFS (int start){
        boolean [] visited = new boolean[nodes];
        DFS(start,visited);
    }
    private void DFS(int v,boolean visited[])
    {
        if(!visited[v]){
          visited[v] = true;
          System.out.print(v +" ");
          for(int i = 0 ; i <graph[v].size();i++){
              if(!visited[graph[v].get(i)]){
                  DFS(graph[v].get(i),visited);
              }
          }
        }
    }
    
    
    public void topoligicalSort(int start){
         boolean [] visited = new boolean[nodes];
        DFSForTopo(start,visited);
    }
    private void DFSForTopo(int v,boolean visited[])
    {
        if(!visited[v]){
          visited[v] = true;
          for(int i = 0 ; i <graph[v].size();i++){
              if(!visited[graph[v].get(i)]){
                  DFS(graph[v].get(i),visited);
                   System.out.print(v +" ");
              }
          }
        }
    }
    
    
    
    
}
