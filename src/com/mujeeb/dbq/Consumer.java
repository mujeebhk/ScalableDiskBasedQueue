package com.mujeeb.dbq;

public class Consumer {

	public void consume () {
		
		while (true) {
			ProcessQueue process = new ProcessQueue();
			try {
				int val = process.getResource();
				System.out.println( "Consumed : " + val);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception in consumer : "+e.getMessage());
			}
		}
	}
}
