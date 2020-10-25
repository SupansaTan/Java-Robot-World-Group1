package flowchart;

import java.util.*; 

public class Flowchart 
{
    private static ArrayQueue elements;

    public Flowchart()
    {
        elements = new ArrayQueue();
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for add the command in flowchart
    // 
    /////////////////////////////////////////////////////
    public void add(String command)
    {
        // add command
        elements.enqueue(command);
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for add if-else in flowchart (true and false condition have a command)
    // 
    /////////////////////////////////////////////////////
    public void ifStatement(String condition, String true_cmd, String false_cmd)
    {
        elements.enqueue(condition, true_cmd, false_cmd);
    }
    
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for add if-else in flowchart (true and false condition have many commands)
    // 
    /////////////////////////////////////////////////////
    public void ifStatement(String condition, String[] true_cmd,String[] false_cmd)
    {
        elements.enqueue(condition, true_cmd, false_cmd);
    }
    
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for display value (all command) in flowchart
    // 
    /////////////////////////////////////////////////////
    public void render()
    {
        // show all elements in flowchart
        elements.displayValue();
    }
    
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get command of flowchart (remove that command and return it value) (head of queue)
    // 
    /////////////////////////////////////////////////////
    public String getFlowchart()
    {
        return elements.dequeue();
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get amount of commands in flowchart
    // 
    /////////////////////////////////////////////////////
    public int getSize()
    {
        return elements.getSize();
    }
}

class ArrayQueue
{
    LinkedList<String> queue; 

    ArrayQueue()
    {
        queue = new LinkedList<String>();
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for get size of queue
    // 
    /////////////////////////////////////////////////////
    int getSize()
    {
        return queue.size();
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for show all values in queue but not remove
    // 
    /////////////////////////////////////////////////////
    void displayValue()
    {
        Iterator<String> value = queue.iterator();  
        while(value.hasNext()){  
            System.out.println(value.next());  
        }  
    }

    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for remove the head of queue and return its value after remove
    // 
    /////////////////////////////////////////////////////
    String dequeue()
    {
        // remove an item from the queue (front)
        return queue.poll();
    }
    
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for implement value in queue (implement to the rear of queue)
    // 
    /////////////////////////////////////////////////////
    void enqueue(String item)
    {
        // add an item to the queue (rear)
        queue.add(item);
    }
    
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description: for implement value in queue (for if-else statement)
    // 
    /////////////////////////////////////////////////////
    void enqueue(String if_condition, String true_cmd, String false_cmd)
    {
        queue.add("[" + if_condition + "," + true_cmd + "," + false_cmd + "]");
    }
    
    /////////////////////////////////////////////////////
    //
    // Programmer: Supansa Tantulset
    //
    // Description:  for implement value in queue (for if-else statement, true and false condition have many commands)
    // 
    /////////////////////////////////////////////////////
    void enqueue(String if_condition, String[] true_cmd, String[] false_cmd)
    {
        String true_statement = "", false_statement = "";
        
        for(int i=0; i<true_cmd.length; i++)
        {
            if(i == 0)
            {
                true_statement += true_cmd[i];
            }
            else
            {
                true_statement += "+" + true_cmd[i];
            }
        }
        
        for(int j=0; j<false_cmd.length; j++)
        {
            if(j == 0)
            {
                false_statement += false_cmd[j];
            }
            else
            {
                false_statement += "+" + false_cmd[j];
            }
        }
        
        queue.add("[" + if_condition + "," + true_statement + "," + false_statement + "]");
    }
}