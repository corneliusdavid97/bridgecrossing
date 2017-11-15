/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cornelius David
 */
public class Person {
    private boolean position; //false:kiri, true:kanan
    private int time;

    public Person(boolean position, int time) {
        this.position = position;
        this.time = time;
    }

    public boolean getPosition() {
        return position;
    }

    public int getTime() {
        return time;
    }
    
    public void move(){
        this.position=!this.position;
    }
}
