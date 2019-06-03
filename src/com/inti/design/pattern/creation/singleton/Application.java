package com.inti.design.pattern.creation.singleton;

public class Application {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			Singleton singleton = Singleton.getInstance();
			singleton.traiter("T" + i);
		}
	}
}
