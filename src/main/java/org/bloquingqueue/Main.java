package org.bloquingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(500);
		BlockingQueue<String> blokingQueue = new LinkedBlockingQueue<>(1000007);
		ConcurrentHashMap<String, String> concurentHshMap = new ConcurrentHashMap<>();
		AtomicInteger atomic = new AtomicInteger(0);
		atomic.set(0);
		Runnable worker = null;
		for (int i = 0; i < 1; i++) {

			worker = new WorkerCallable(blokingQueue, atomic);
			executor.execute(worker);
		}
		ExecutorService executor1 = Executors.newFixedThreadPool(1000);
		for (int i = 0; i < 200; i++) {
			worker = new WorkerThread(blokingQueue, concurentHshMap);
			executor1.execute(worker);
		}

	}

}