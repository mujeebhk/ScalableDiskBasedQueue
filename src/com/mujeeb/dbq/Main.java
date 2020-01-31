package com.mujeeb.dbq;

public class Main {

	public static void main(String[] args) {

		
		for( int i=0; i<5; i++) {
		  Producer producer = new Producer(); 
		  Thread producerThread = new
		  Thread(producer); 
		  producerThread.start();
		 
		}
		Consumer consumer = new Consumer();
		consumer.consume();
	}

}
