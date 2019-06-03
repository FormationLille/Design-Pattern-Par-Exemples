package com.inti.design.pattern.creation.singleton;

public class ThreadedTask extends Thread {
	private String taskName;

	public ThreadedTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		Singleton singleton = Singleton.getInstance();
		singleton.traiter(taskName);
	}
}
