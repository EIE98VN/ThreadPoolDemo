import java.util.ArrayList;

public class ThreadPool {
	BlockingQueue<Runnable> queue;
	public static ArrayList<Thread> threadList = new ArrayList<Thread>();
	
	public ThreadPool(int queueSize, int minThread, int maxThread) {
		queue = new BlockingQueue<>(queueSize);
		String threadName = null;
		TaskExecutor task = null;
		for (int count = 0; count < maxThread; count++) {
			threadName = "Thread-" + count;
			task = new TaskExecutor(queue);
			Thread thread = new Thread(task, threadName);
			threadList.add(thread);
		}
		for (int i = 0; i < minThread; i++)
			threadList.get(i).start();
	}

	public void submitTask(Runnable task) throws InterruptedException {
		queue.enqueue(task);
	}
}
