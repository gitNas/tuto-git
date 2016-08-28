package org.bloquingqueue;

import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerCallable implements Runnable {
	public WorkerCallable(BlockingQueue<String> blokingQueue, AtomicInteger atomic) {
		this.blokingQueue = blokingQueue;
		this.atomic = atomic;
	}

	AtomicInteger atomic;
	BlockingQueue<String> blokingQueue;

	@Override
	public void run() {
		long timer = Instant.now().getEpochSecond();
		while (true) {
			if (blokingQueue.size() < 1000004) {
				int integer = atomic.incrementAndGet();
				if (integer == 1000000) {
					System.out.println("Elapsed time in seconds: " + (Instant.now().getEpochSecond() - timer));
					System.out.println();
				}
				String value = String.valueOf(integer);
				try {
					blokingQueue.put(value);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
