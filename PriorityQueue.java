package com.example.racheli.myapplication;

import java.util.ArrayList;

/**
 * Created by racheli on 11/06/2017.
 */

/****************************************************************************************************************
 * The class called PriorityQueue <E extends Prioritize>.                                                       *
 * The department represent a queue of priorities, that is, organs arranged in line according to their priority,*
 * with the higher priority organs at the beginning of the queue, even if they came last.                       *
 ****************************************************************************************************************/

public class PriorityQueue <E extends Prioritize>
{
    /***************************************************************
     *   An empty constructor to the class to initialize the queue.*
     ***************************************************************/
    public ArrayList<E> heapArray ;
    public static  final int MIN_VALUE_HEAPLIST=1;
    public PriorityQueue()
    {
        heapArray = new ArrayList<>();
        heapArray.add(null);
    }

    /*********************************************************************************************
     * The method remove from the queue the object of the highest priority and return it.        *
     * If the queue is empty the method returns null.                                            *
     * The efficiency of the method is O (logn).                                                 *
     *********************************************************************************************/
    public E remove(){
        if (heapArray.size()<=MIN_VALUE_HEAPLIST)
            return null;
        E heapmax= (heapArray.get(heapArray.size()-1));
        swap(heapArray, 1,heapArray.size()-1);
        heapArray.remove((heapArray.get(heapArray.size()-1)));
        makeHeap(heapArray);
        return heapmax;
    }

    /*******************************************************************************************************
     * This function uses a stack algorithm and executes to the PriorityQueue.
     * A binary stack(maximum stack) is a data structure that can be likened to a nearly full binary tree, *
     * where the value of each node is greater than or equal to its boys' value.                           *
     *                                                                                                     *
     *                              *
     *The idea of the heapify function is to decide which of the three - father,                           *
     *son of a leftist and right-handed son is the greatest, and put him as father.                        *
     *We take the "problematic" node down and take care of it there.
     *                                             *
     *******************************************************************************************************/

    void makeHeap(ArrayList<E> heapArray)
    {
        heapify(heapArray, 1);
    }
    public  void  heapify(ArrayList<E> heapArray, int i){
        while(true) {
            int max = i;
            if (2*i <heapArray.size() && heapArray.get(2*i).getPriority() > heapArray.get(max).getPriority())
                max = 2*i;
            if (2*i+1 < heapArray.size() && heapArray.get(2*i+1).getPriority() >heapArray.get(max).getPriority())
                max = 2*i + 1;
            if (max == i)
                return;
            swap(heapArray, i, max);
            i=max;
        }
    }

    public  void swap(ArrayList<E> heapArray, int index1, int index2)
    {
        E temp = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, temp);
    }

    /*************************************************************************************************
     * The method  receive an E-type object and place it in the queue according to its priority.     *
     * The efficiency of the method should be O (logn).                                              *
     * We'll add the new value as a cost.                                                            *
     *As long as the new value is greater than the value of his father, we will replace their sons   *
     *************************************************************************************************/
    public void insert(E x)
    {
        int i  = heapArray.size();
        heapArray.add(i, x);
        while(i > 1 && heapArray.get(i).getPriority() > heapArray.get(i/2).getPriority()) {
            swap(heapArray, i, i/2);
            i = i/2;
        }

        /**********************************************************************************************
         * The method returns the object at the top of the queue (with the highest priority)          *
         * without deleting it from the queue. If there are several objects with the same priority,   *
         * the method will return one of them. The efficiency of the method is O (1).                 *
         *********************************************************************************************/
    }
    public E firstInLine()
    {
        if(heapArray.size()<=MIN_VALUE_HEAPLIST)
            return null;
        E 	maxHeap=heapArray.get(MIN_VALUE_HEAPLIST);
        return maxHeap;
    }
    private boolean isEqual(E x)
    {
        for (int i = 0; i < heapArray.size(); i++)
        {
            if (x.equals(heapArray.get(i)))
            {
                return true;
            }
        }
        return false;
    }

    /*********************************************************************************************************
     * The method receive as parameters an object of type E that represents an existing element in the queue,*
     * and a priority p. The method  change the priority of x to p.                                          *
     * The efficiency of the method is O (logn).                                                             *
     * If organ x does not exist as the method will do nothing.                                              *
     *********************************************************************************************************/
    public void changePriority(E x, int p)
    {
        if (isEqual(x))
        {
            E temp = x;
            temp.setPriority(p);
            heapArray.remove(x);
            insert(temp);
        }
    }

    /***********************************************************************
     * The method returns true if the queue is empty and otherwise false   *
     ***********************************************************************/
    public boolean isEmpty()
    {
        if(heapArray.size()<=MIN_VALUE_HEAPLIST)
            return true;
        return false;
    }




}
