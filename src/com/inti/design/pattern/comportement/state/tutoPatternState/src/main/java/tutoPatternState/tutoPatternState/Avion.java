package tutoPatternState.tutoPatternState;

public class Avion {
	
	private EtatAvion etatAvion;
	
	public Avion() {
		
		etatAvion = new AuGarage();
	}

	public void entrerAuGarage() {
		etatAvion.entrerAuGarage();
	}

	public void sortirDuGarage() {
		etatAvion.sortirDuGarage();
	}

	public void decoller() {
		etatAvion.decoller();
	}

	public void atterir() {
		etatAvion.atterir();
	}
	
	public void doAction() {
		etatAvion.doAction();
	}

	interface EtatAvion{
		
		public void entrerAuGarage();
		public void sortirDuGarage();
		public void decoller();
		public void atterir();
		public void doAction();
	}
	
	class AuGarage implements EtatAvion{

		public void entrerAuGarage() {
			System.out.println("Je suis deja au garage");
			
		}

		public void sortirDuGarage() {
			System.out.println("Transition d'etat du garage vers la piste");
			etatAvion = new EnPiste();
			
		}

		public void decoller() {
			System.out.println("Impossible de decoller");
			
		}

		public void atterir() {
			System.out.println("Impossible d'atterrir");
			
		}

		public void doAction() {
			System.out.println("Action relative à l'etat au garage...");
			
		}
		
		
	}
	
	class EnPiste implements EtatAvion{

		public void entrerAuGarage() {
			System.out.println("Transition de la piste verss le garage");
			etatAvion = new AuGarage();
		}

		public void sortirDuGarage() {
			System.out.println("Je suis deja en piste");
			
		}

		public void decoller() {
			System.out.println("Transition de piste vers en l'air");
			etatAvion= new EnLAir();
		}

		public void atterir() {
			System.out.println("Impossible je suis en piste");
			
		}

		public void doAction() {
			System.out.println("Action relative à l'etat en piste");
			
		}
	}
		
		class EnLAir implements EtatAvion{

			public void entrerAuGarage() {
				System.out.println("Impossible de passer de l'etat en l'air vers le garage");
				
			}

			public void sortirDuGarage() {
				System.out.println("Impossible");
				
			}

			public void decoller() {
				System.out.println("Impossible");
				
			}

			public void atterir() {
				System.out.println("Transition de l'air vers la piste");
				etatAvion = new EnPiste();
			}

			public void doAction() {
				System.out.println("Action d'aterrissage");
				
			}
			
			
		}

	}
	


