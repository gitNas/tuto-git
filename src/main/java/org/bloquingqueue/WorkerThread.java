package org.bloquingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class WorkerThread implements Runnable {

	private String command;
	BlockingQueue<String> blokingQueue;
	ConcurrentHashMap<String, String> concurentHshMap;

	public WorkerThread(BlockingQueue<String> blokingQueue, ConcurrentHashMap<String, String> concurentHshMap) {
		this.blokingQueue = blokingQueue;
		this.concurentHshMap = concurentHshMap;
	}

	@Override
	public void run() {
		while (true) {
			String value = null;
			value = blokingQueue.peek();
			// System.out.println(Thread.currentThread().getName() + " Start.
			// Command = " + value);
			String get = concurentHshMap.get(value);
			if (get != null) {
				throw new RuntimeException(value + " exist" + Thread.currentThread().getName() + "get " + get);
			}
			concurentHshMap.put(value, Thread.currentThread().getName());
			processCommand();
			// System.out.println("concurentHshMap " + concurentHshMap.size());
		}

	}

	private void processCommand() {

	}

	@Override
	public String toString() {
		return this.command;
	}
}