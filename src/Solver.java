
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cornelius David
 */
public class Solver {
    private PriorityQueue<State> pq;
    private Tree tree;
    
    public Solver(Tree tree){
        this.pq = new PriorityQueue<>();
        this.tree = tree;
    }
    
    public int solve(){
        this.pq.add(tree.root);
        while(!pq.isEmpty()){
            State curState = pq.poll();
            if(curState.isGoal()){
                return curState.getCost();
            }
            LinkedList<State> children = curState.generateChild();
            Iterator<State> it=children.iterator();
            while(it.hasNext()){
                pq.add(it.next());
            }
        }
        return -1;
    }
}
