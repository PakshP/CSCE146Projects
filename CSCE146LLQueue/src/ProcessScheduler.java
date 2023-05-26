//Paksh Patel

import java.util.LinkedList;
import java.util.Queue;

public class ProcessScheduler {
	// The process queue is implemented as a linked list.
	private Queue<Process> processQueue;
	// The current process that is being executed, if any.
	private Process currentProcess;

	public ProcessScheduler() {
		// Initializes the process queue and current process.
		processQueue = new LinkedList<Process>();
		currentProcess = null;
	}

	public void addProcess(Process p) {
		// Adds a new process to the queue.
		// If there is no current process, sets this process as the current one.
		// Otherwise, adds the process to the end of the queue.
		if (currentProcess == null) {
			currentProcess = p;
		} else {
			processQueue.offer(p);
		}
	}

	public void runNextProcess() {
		// Runs the next process in the queue, if any.
		currentProcess = processQueue.poll();
	}

	public void cancelCurrentProcess() {
		// Cancels the current process, if any.
		currentProcess = null;
	}

	public Process getCurrentProcess() {
		// Returns the current process, if any.
		return currentProcess;
	}

	public void printProcessQueue() {
		// Prints the process queue to the console.
		// If the queue is empty, prints "Empty".
		// Otherwise, prints each process's toString() representation.
		if (processQueue.isEmpty()) {
			System.out.println("Empty");
		} else {
			for (Process p : processQueue) {
				System.out.println(p.toString());
			}
		}
	}
}
