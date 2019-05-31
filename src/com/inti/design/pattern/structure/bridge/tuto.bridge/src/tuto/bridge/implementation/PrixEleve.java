package tuto.bridge.implementation;

public class PrixEleve implements OrdrePrix { // classes de mise en œuvre du Bridge

	@Override
	public void assigner() {
		System.out.println(" prix elevé ");

	}

}