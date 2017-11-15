
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cornelius David
 */
public class State implements Comparable<State>{

    private LinkedList<State> children;
    private Person[] current; //false:left, true:right
    private boolean lanternPos; //false:left, true:right
    private int cost;
    
    public State(Person[] current, boolean lanternPos, int cost) {
        this.children = new LinkedList<>();
        this.current = current;
        this.lanternPos = lanternPos;
        this.cost = cost;
    }

    public LinkedList<State> generateChild() {
        int len = current.length;
        for (int i = 0; i < len; i++) {
            if (!this.lanternPos) {
                for (int j = i + 1; j < len; j++) {
                    Person tmp[] = new Person[len];
                    for (int k = 0; k < len; k++) {
                        tmp[k] = new Person(current[k].getPosition(), current[k].getTime());
                    }
                    if (tmp[i].getPosition() == this.lanternPos
                            && tmp[j].getPosition() == this.lanternPos) {
                        tmp[i].move();
                        tmp[j].move();
                        this.children.add(new State(tmp, !lanternPos, Math.max(current[i].getTime(), current[j].getTime())+cost));
                    }
                }
            } else {
                Person tmp[] = new Person[len];
                for (int k = 0; k < len; k++) {
                    tmp[k] = new Person(current[k].getPosition(), current[k].getTime());
                }
                if (tmp[i].getPosition() == this.lanternPos) {
                    tmp[i].move();
                    this.children.add(new State(tmp, !lanternPos, current[i].getTime()+cost));
                }
            }

        }
        return this.children;
    }

    public LinkedList<State> getChildren() {
        return children;
    }

    public Person[] getCurrent() {
        return current;
    }

    public boolean isLanternPos() {
        return lanternPos;
    }

    @Override
    public int compareTo(State o) {
        return this.cost - o.cost;
    }
    
    public boolean isGoal(){
        for (int i = 0; i < current.length; i++) {
            if(current[i].getPosition()==false)return false;
        }
        return true;
    }

    public int getCost() {
        return cost;
    }
}
