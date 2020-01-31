package com.mujeeb.dbq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class State {

	public static final int Q_SIZE = 100;
	public static final int NO_OF_FILES = 10000;
	
	public static BlockingQueue<Integer> DEFAULT_Q = new LinkedBlockingQueue<>(Q_SIZE);
	public static BlockingQueue<Integer> READ_Q = new LinkedBlockingQueue<>(Q_SIZE);
	public static BlockingQueue<Integer> WRITE_Q = new LinkedBlockingQueue<>(Q_SIZE);
	
	
	public static BlockingQueue<String> FILENAME_Q = new LinkedBlockingQueue<>(NO_OF_FILES);
	public static AtomicInteger FILENAME = new AtomicInteger(0);
	
	public static boolean MOVE_TO_DISK =  false;
	
}

