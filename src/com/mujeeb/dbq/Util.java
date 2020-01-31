package com.mujeeb.dbq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.BlockingQueue;

public class Util {

	
	public static void writeQueueToFile (String filename, BlockingQueue<Integer> q) throws IOException {
		
		try
        {
            //FileOutputStream fos = new FileOutputStream("listData");
			FileOutputStream fos = new FileOutputStream(filename);
			
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(q);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
        	ioe.printStackTrace();
            throw ioe;
        }
	}
	
	@SuppressWarnings("unchecked")
	public static BlockingQueue<Integer> getQueueFromFile (String filename) throws IOException, ClassNotFoundException {
		BlockingQueue<Integer> q = null;
		try
        {
			FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            q = (BlockingQueue<Integer>) ois.readObject();
 
            ois.close();
            fis.close();
            deleteFile(filename);
        } 
        catch (IOException ioe) 
        {
        	ioe.printStackTrace();
            throw ioe;
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
		if (q == null) {
			System.out.println("Error reading from file ");
		}
		
		return q;
	}

	public static void deleteFile(String filename) {
		// TODO Auto-generated method stub
		File file = new File(filename);
        if(file.delete()){
            System.out.println(filename + " File deleted");
        }else System.out.println(filename + " File doesn't exist");
		
	}

}
