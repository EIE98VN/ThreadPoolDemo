
public class TestTask implements Runnable{
	private int number;

	public TestTask(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " Start executing of task number :" + number);
		try {
			// Simulating processing time
			// perform tasks
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ " End executing of task number :" + number);
	}
}
