import java.util.*;
/**
 * Klasse Primzahlrechner.
 * 
 * @author mathelehrer 
 * @version 1
 */
public class Primzahlrechner
{
   
    private List<Integer> primzahlliste;
    
    public Primzahlrechner()
    {
        primzahlliste=new  ArrayList<>();
    }

   
    public void berechnePrimzahlenBis(int grenze)
    {
        primzahlliste.clear();
        int count = 0;
        long start =System.currentTimeMillis();
        for(int i=2;i<=grenze;i++){
            boolean prim = true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if (i%j==0){
                    prim  = false;
                    break;
                }
            }
            if (prim){
                count++;
                primzahlliste.add(i);
            }
        }
        long end= System.currentTimeMillis();
        
        System.out.println(primzahlliste.size()+" Primzahlen gefunden");
        /*
        for(int i=0;i<primzahlliste.size();i++){
            System.out.print(primzahlliste.get(i)+"\t");
            if ((i+1)%5==0)
            System.out.println();
        }
        */
       System.out.println((end-start)+" ms.");
    }
}
