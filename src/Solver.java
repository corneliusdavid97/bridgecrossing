
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

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
    private Stack<State> stack;
    
    public Solver(Tree tree){
        this.pq = new PriorityQueue<>();
        this.tree = tree;
        this.stack= new Stack<>();
    }
    
    public State solve(){
        this.pq.add(tree.root);
        while(!pq.isEmpty()){
            State curState = pq.poll();
            if(curState.isGoal()){
                return curState;
            }
            LinkedList<State> children = curState.generateChild();
            Iterator<State> it=children.iterator();
            while(it.hasNext()){
                pq.add(it.next());
            }
        }
        return null;
    }
    
    public String getPath(State s){
        String res="";
        State current=s;
        while(current!=null){
            stack.push(current);
            current=current.getParent();
        }
        current=stack.pop();
        int total=0;
        while(!stack.empty()){
            State child=stack.empty()?null:stack.peek();
            int max=Integer.MIN_VALUE;
            if(child!=null){
                for (int i = 0; i < current.getCurrent().length; i++) {
                    if(current.getCurrent()[i].getPosition()!=child.getCurrent()[i].getPosition()){
                        res+=current.getCurrent()[i].getTime();
                        res+=" ";
                        max=max<current.getCurrent()[i].getTime()?current.getCurrent()[i].getTime():max;
                    }
                }
                total+=max;
            }
            current=stack.empty()?null:stack.pop();
            res+="\n";
        }
        return total+"\n"+res;
    }
        
}
