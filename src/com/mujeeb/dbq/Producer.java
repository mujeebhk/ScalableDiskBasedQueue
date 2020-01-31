package com.mujeeb.dbq;

import java.util.Random;

public class Producer implements Runnable 
{
 
    Producer() {
    }
 
    @Override
    public void run() 
    {
        try
        {
            while (true) 
            {
                int justProduced = getResource();
                System.out.println("Produced  :  " + justProduced);
                ProcessQueue process = new ProcessQueue();
                process.putResource(justProduced);
            }
        } 
        catch (Exception ex) 
        {
            System.out.println("Producer error : "+ ex.getMessage());
        }
    }
 
    
    
    
    private static final Random RANDOM = new Random();
    int getResource() 
    { 
        return RANDOM.nextInt();
    }
    
    
}