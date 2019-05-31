package tuto.bridge.implementation;

public class PetitPrix implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" petit prix ");

	}

}