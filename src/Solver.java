
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

    public Solver(Tree tree) {
        this.pq = new PriorityQueue<>();
        this.tree = tree;
        this.stack = new Stack<>();
    }

    public State solve() {
        this.pq.offer(tree.root);
        while (!pq.isEmpty()) {
            State curState = pq.poll();
//            System.out.println(curState.getBitString());
            if (curState.isGoal()) {
                return curState;
            }
            LinkedList<State> children = curState.generateChild();
            Iterator<State> it = children.iterator();
            while (it.hasNext()) {
                State s = it.next();
//                System.out.println(s.getBitString());
//                pq.offer(s);
                if (!Tree.bitstringSet.contains(s.getBitString())) {
                    pq.offer(s);
                    Tree.bitstringSet.add(s.getBitString());
                } else {
                    for (State st : pq) {
                        if (st.getBitString().equals(s.getBitString())) {
                            if (s.getCost() < st.getCost()) {
                                pq.remove(st);
                                pq.offer(s);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getPath(State s) {
        String res = "";
        State current = s;
        while (current != null) {
            stack.push(current);
            current = current.getParent();
        }
        current = stack.pop();
        int total = 0;
        while (!stack.empty()) {
            State child = stack.empty() ? null : stack.peek();
            int max = Integer.MIN_VALUE;
            if (child != null) {
                for (int i = 0; i < current.getCurrent().length; i++) {
                    if (current.getCurrent()[i].getPosition() != child.getCurrent()[i].getPosition()) {
                        res += current.getCurrent()[i].getTime();
                        res += " ";
                        max = max < current.getCurrent()[i].getTime() ? current.getCurrent()[i].getTime() : max;
                    }
                }
                total += max;
            }
            current = stack.empty() ? null : stack.pop();
            res += "\n";
        }
        return total + "\n" + res;
    }

}
