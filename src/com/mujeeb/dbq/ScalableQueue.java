package com.mujeeb.dbq;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ScalableQueue extends LinkedBlockingQueue<Integer>{

	ProcessQueue process = new ProcessQueue();

	@Override
	public boolean add(Integer e) {
		// TODO Auto-generated method stub
		try {
			process.putResource(e);
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return false;
			
		}
	}
	
	
	@Override
	public Integer take()  {
		// TODO Auto-generated method stub
		try {
			return process.getResource();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
}
