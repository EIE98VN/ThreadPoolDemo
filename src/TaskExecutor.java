
public class TaskExecutor implements Runnable {
	BlockingQueue<Runnable> queue;

	public TaskExecutor(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String name = Thread.currentThread().getName();
				Runnable task = queue.dequeue();
				//System.out.print(name+ " Start");
				task.run();
				//System.out.print(name + "Finish");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
