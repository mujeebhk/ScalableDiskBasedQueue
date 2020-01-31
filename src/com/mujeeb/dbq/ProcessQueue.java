package com.mujeeb.dbq;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class ProcessQueue {

	
	public int getResource () throws Exception {
		
		if (State.MOVE_TO_DISK) {
			if (State.READ_Q.isEmpty()) {
				populateReadQWithDataInFile();
			}
			return State.READ_Q.take();
			
		} else {
			return State.DEFAULT_Q.take();
		}
		
	}
	
	public void putResource (int num) throws IOException {
		
		if (State.MOVE_TO_DISK) {
			
			if (State.WRITE_Q.size() == State.Q_SIZE) {
				writeQueueToFile (State.WRITE_Q);
				State.WRITE_Q.clear();
			}
			State.WRITE_Q.add(num);
			
		} else {
			if (State.DEFAULT_Q.size()== State.Q_SIZE) {
				State.DEFAULT_Q.drainTo(State.READ_Q);
				State.WRITE_Q.add(num);
				State.MOVE_TO_DISK = true;
			}
			State.DEFAULT_Q.add(num);
		}
	}
	
	
	void writeQueueToFile(BlockingQueue<Integer> q) throws IOException {
		int filename = State.FILENAME.getAndIncrement();
		Util.writeQueueToFile(Integer.toString(filename), q);
		State.FILENAME_Q.add(Integer.toString(filename));
	}
	
	void populateReadQWithDataInFile () throws Exception {
		System.out.println("populateReadQWithDataInFile ");
		String filename = State.FILENAME_Q.take();
		State.READ_Q = Util.getQueueFromFile(filename);
		Util.deleteFile(filename);
	}
	
}
