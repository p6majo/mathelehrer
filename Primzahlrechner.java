import java.util.*;

/**
 * Primzahlrechner
 * 
 * @author mathelehrer 
 * @version 1
 */
public class PrimzahlRechner
{
    private List<Integer> primzahlListe;
   
    public PrimzahlRechner()
    {
        primzahlListe = new ArrayList<>();
    }

    public void berechnePrimzahlenBis(int grenze)
    {
        primzahlListe.clear();
        long start = System.currentTimeMillis();
        
        for(int zahl=2;zahl<=grenze;zahl++){
            boolean prim = true;
            for(int teiler=2;teiler<=Math.sqrt(zahl);teiler++){
                if (zahl%teiler==0){
                    prim = false;
                    break;
                }
            }

            if (prim){
                primzahlListe.add(zahl);
            }
        }
        
        long end = System.currentTimeMillis();
        ausgabe(end-start);
    }
    
    private void ausgabe(long dauer){
        for(int p=0;p<primzahlListe.size();p++){
            System.out.print(primzahlListe.get(p)+"\t");
            if ((p+1)%5==0){
                System.out.println();
            }
        }
        System.out.println("\n"+primzahlListe.size()+" Primzahlen gefunden in "
        + dauer + " ms.");
    }
}

