package com.example.racheli.myapplication;


/**
 * Created by racheli on 10/06/2017.
 */

/*****************************************************************************************************************
 * the     class called ToDoList. The class      represent a list of tasks to perform.                           *
 * The class manages the task list and therefore contains a PriorityQueue object that contains ToDoItem objects. *
 *****************************************************************************************************************/

public class ToDoList
{
    private PriorityQueue<Prioritize> priorityQueue= new PriorityQueue<>();

    /************************************************************
     * All methods are implemented from the class  PriorityQueue*
     ************************************************************/
    public ToDoItem remove()
    {
        if(priorityQueue.isEmpty()==true)
            return null;
        return (ToDoItem)priorityQueue.remove();
    }

    public void insert(ToDoItem  x) {
        priorityQueue.insert(x);
    }


    public ToDoItem firstInLine(){
        if (priorityQueue.isEmpty()==true)
            return null;
        return (ToDoItem) priorityQueue.firstInLine();
    }


    public void changePriority(Prioritize x, int p) {
        priorityQueue.changePriority(x, p);
    }



}

