public class ProcessScheduler {
    private LLQueue<Process> processQueue = new LLQueue<>();
    private Process currentProcess = null;

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void addProcess(Process process) {
        if (currentProcess == null) {
            currentProcess = process;
        } else {
            processQueue.enqueue(process);
        }
    }

    public void runNextProcess() {
        currentProcess = processQueue.dequeue();
    }

    public void cancelCurrentProcess() {
        currentProcess = processQueue.dequeue();
    }

    public void printProcessQueue() {
        processQueue.print();
    }
}
