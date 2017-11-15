/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cornelius David
 */
public class Tree {
     State root;

    public Tree(Person[] arr) {
        root=new State(arr, false,0);
    }
    
}
