package Collections_Practice;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class List {

    public static void main(String[] args) {
        /*  Ordered Collections
        *  - ArrayList
        *  - Vector
        *  - LinkedList
        *  - Stack
        */

        ArrayList<Integer> l = new ArrayList<>();
        l.add(22);
        l.add(45);
        l.add(1 , 34);
        l.add(67);
        System.out.println("List is : "+l);
    // Same for LinkList 
    
    //---------------------------------------------------------

    // Vector
    Vector<Integer> v = new Vector<Integer>();
    v.add(10);
    v.insertElementAt(111, 0);
    v.add(2, 41);
    
    System.out.println("Vector is : "+v);
    v.insertElementAt(131, 1);
    v.add(3, 12);
    System.out.println("Updated Vector is : "+v);

    Stack<Integer> s = new Stack<Integer>();
    s.push(10);
    s.push(20);
    s.push(30);
    s.push(40);
    System.out.println("Stack is : "+s);
    System.out.println(s.peek());
    s.pop();
    System.out.println("Stack After POP : "+s);
    }

}
