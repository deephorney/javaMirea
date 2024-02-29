package practiceFourth;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private final int numThreads;
    private final List<WorkerThread> threads;
    private final BlockingQueue<Runnable> taskQueue;

    public Main(int numThreads) {
        this.numThreads = numThreads;
        this.threads = new ArrayList<>(numThreads);
        this.taskQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < numThreads; i++) {
            WorkerThread workerThread = new WorkerThread();
            workerThread.start();
            threads.add(workerThread);
        }
    }

    public void submit(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void shutdown() {
        for (WorkerThread thread : threads) {
            thread.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main executorService = new Main(5);

        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Работа " + taskNumber + " выполнился поток " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
