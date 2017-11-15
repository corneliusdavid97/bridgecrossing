
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cornelius David
 */
public class Tester {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Person[] arr=new Person[n];
        for (int i = 0; i < n; i++) {
            arr[i]=new Person(false, sc.nextInt());
        }
        Tree t=new Tree(arr);
        Solver s=new Solver(t);
        System.out.println(s.solve());
    }
}
