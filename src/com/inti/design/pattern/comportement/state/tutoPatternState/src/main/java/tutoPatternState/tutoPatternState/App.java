package tutoPatternState.tutoPatternState;

public class App 
{
    public static void main( String[] args )
    {
       Avion avion = new Avion();
       
       avion.doAction();
       avion.decoller();
       avion.doAction();
       avion.sortirDuGarage();
       avion.doAction();
       avion.atterir();
       avion.entrerAuGarage();
       avion.decoller();
       avion.sortirDuGarage();
       avion.decoller();
       avion.doAction();
          
    }
}
