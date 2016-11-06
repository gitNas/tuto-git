package org.bloquingqueue;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	static Instant starts = Instant.now();
	static Test test = new Test();

	public static void main(String[] args) throws Exception {
		// Thread.sleep(4000);
		// System.out.println(Duration.between(starts,
		// Instant.now()).getSeconds() * 1000);
		for (int i = 0; i < 50; i++) {
			test.send();
			Thread.sleep(i * 100);

		}
	}

}