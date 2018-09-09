package com.example.racheli.myapplication;



/**
 * Created by racheli on 10/06/2017.
 */

/**********************************************************
 *  the class called ToDoItem to represent a task.        *
 * The class will implement the Prioritize interface      *
 * because each task also has a priority between 0 and 10.*
 *The department will have the feature -                  *
 *********************************************************/

public class ToDoItem implements Prioritize  {

    private String description;//Task description, type String.
    private int  priority;

    /***********************************************************************************************
     * The constructor  get the job description and priority and  place them in attributes.*
     ***********************************************************************************************/
    public ToDoItem(String description, int priority)
    {
        this.description=description;
        this.priority=priority;
    }

    /**************************************
     * Implementation of interface methods*
     **************************************/
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(int p) {this.priority=p;}
    public int getPriority() {return this.priority;}

    /***********************************************************************************************************
     * The method returns the task in a string format, consisting of the task description, comma, and priority.*
     ***********************************************************************************************************/
    public String toString() {

        return  description + " "+ priority ;
    }

    /******************************************************************************************
     * The method  receive a task type object and return true if obj is equal to this.    *
     * Both tasks  be called equal if their descriptions are equal.                       *
     ******************************************************************************************/
    public boolean equals(Object obj)
    {
        if (obj instanceof ToDoItem)
        {
            if (((ToDoItem) obj).description==this.description)
                return true;
        }
        return false;
    }
}

