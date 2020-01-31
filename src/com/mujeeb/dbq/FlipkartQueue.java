package com.mujeeb.dbq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FlipkartQueue extends LinkedBlockingQueue<Integer>{

	ProcessQueue process = new ProcessQueue();

	@Override
	public boolean add(Integer e) {
		// TODO Auto-generated method stub
		return true;//process.putResource(e);
	}
}
