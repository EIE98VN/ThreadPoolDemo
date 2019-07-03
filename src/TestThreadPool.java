
public class TestThreadPool {
	public static int maxThread = 8;
	public static void main(String[] args) throws InterruptedException {
		// create queue size - 3
		// Number of min threads - 4
		// Number of max threads -6

		ThreadPool threadPool = new ThreadPool(20, 5, maxThread);
		// Created 15 Tasks and submit to pool
		for (int taskNumber = 1; taskNumber <= 100; taskNumber++) {
			TestTask task = new TestTask(taskNumber);
			threadPool.submitTask(task);
		}
	}
}
