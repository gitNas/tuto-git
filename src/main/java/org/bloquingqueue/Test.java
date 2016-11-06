package org.bloquingqueue;

import java.time.Duration;
import java.time.Instant;

public class Test {

	private Instant starts = Instant.now();

	private int counter = 0;
	private int multi = 0;

	public void send() {
		long waiting = Duration.between(starts, Instant.now()).getSeconds() * 1000;
		if (waiting > 100 * multi) {
			counter = 0;
			multi = 0;
		}
		counter++;
		if (counter % 4 == 0) {
			multi++;
		}
		System.out.println("multi " + multi);
		System.out.println("waiting " + waiting);

		starts = Instant.now();
	}

	public Instant getStarts() {
		return starts;
	}

	public void setStarts(Instant starts) {
		this.starts = starts;
	}

}
