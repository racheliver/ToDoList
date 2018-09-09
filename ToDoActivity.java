package com.example.racheli.myapplication;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**************************************************************************************************
 *      An Android app for task maintenance.  activity called ToDoActivity.             *
 * The ActiveType  contain EditText to enter task description, and EditText to enter priority.*
 The active  also have two buttons - one button called Add  add a new task to the list.
 A button called Remove  remove the task that appears in EditText from the list and output a T
 oast that says which task has been removed from the list.*
 **************************************************************************************************/
public class ToDoActivity extends AppCompatActivity implements View.OnClickListener {


    private Button cmdAddClick;       //Variable type Button  That represented the button on the screen
    private Button cmdRemoveClick2;       //Variable type Button  That represented the button on the screen
    private EditText edtPriortyID;   //Variable type EditText That represented the Priorty on the screen
    private EditText edtDescriptioID;    //Variable type EditTextThat represented the descrption on the screen
    private ToDoItem toDoItem;
    private ToDoList toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

/**********************************************************
 * Making the connection to      the button on the screenn*
 **********************************************************/
        cmdAddClick = (Button) findViewById(R.id.cmdAddClick);
        cmdRemoveClick2 = (Button) findViewById(R.id.cmdRemoveClick2);
        edtDescriptioID = (EditText) findViewById(R.id.edtDescriptioID);
        edtPriortyID = (EditText) findViewById(R.id.edtPriortyID);

        cmdAddClick.setOnClickListener(this);
        cmdRemoveClick2.setOnClickListener(this);

        toDoList = new ToDoList();
    }

    public void onClick(View v)
    {

        String description = edtDescriptioID.getText().toString();//Retrieving information from the screen
        String priorty = edtPriortyID.getText().toString();

        if (v.getId() == R.id.cmdAddClick) {
            if (description.equals("") || priorty.equals("") || description.equals(null) || priorty.equals(null))
            {
                Toast.makeText(ToDoActivity.this, "Please enter a valid number", Toast.LENGTH_LONG).show();
            } else {
                int priortyToNumber = Integer.parseInt(priorty);
                if ((priortyToNumber < Prioritize.MIN_P) || (priortyToNumber > Prioritize.MAX_P)) {
                    Toast.makeText(ToDoActivity.this, "Please enter a valid number to priorty", Toast.LENGTH_LONG).show();
                } else {
                    toDoItem = new ToDoItem(description, priortyToNumber);
                    toDoList.insert(toDoItem);
                    Toast.makeText(ToDoActivity.this, description + " is add with priority " + priortyToNumber, Toast.LENGTH_LONG).show();

                }
            }
        }
            else
            {

                if (toDoList.firstInLine() != null)
                {
                    Toast.makeText(ToDoActivity.this, toDoList.firstInLine().getDescription() + " removed", Toast.LENGTH_LONG).show();
                    toDoList.remove();

                }
                else
                {
                    Toast.makeText(ToDoActivity.this, "the list is empty", Toast.LENGTH_LONG).show();
                }
            }
        }
    }



