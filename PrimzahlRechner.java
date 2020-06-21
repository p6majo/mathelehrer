//Projekt im Rahmen des Videotutorials fuer meine Schueler
//Klasse 5 (weiterfuehrende Schule)

import java.util.*;


/**
 * Primzahlrechner. 
 * 
 * @author mathelehrer 
 * @version 1
 * @version 2
 *      Faktorisierung
 *      Goldbachvermutung
 *      Primzahlzerlegung in Quadratzahlen
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
    
    /**
     * Zerlegt alle Zahlen bis zu einer Grenzzahl in Primfaktoren
     * 
     * @param grenze die gr&ouml;&szligte zu zerlegende Zahl
     */
    public void primFaktorenBis(int grenze){
        berechnePrimzahlenBis(grenze);
        
        long start = System.currentTimeMillis();
        StringBuilder out = new StringBuilder();
        for (int zahl =2;zahl<=grenze;zahl++){
            List<Integer> faktoren = faktorisiere(zahl);
            out.append(zahl+"=");
            for(int f = 0; f<faktoren.size();f++){
                out.append(faktoren.get(f));
                if (f<faktoren.size()-1)
                    out.append("*");
                else
                    out=out.append("\n");
            }
        }
        long end =System.currentTimeMillis();
        System.out.println(out.toString()+"\n"+" in "+(end-start)+" ms.");
    }
    
    private List<Integer> faktorisiere(int zahl){
        List<Integer> faktoren = new ArrayList<>();
        for (int p = 0;p<primzahlListe.size();p++){
            int primzahl = primzahlListe.get(p);
            while(zahl%primzahl==0){
                zahl=zahl/primzahl;
                faktoren.add(primzahl);
            }
            if (zahl==1)
                break;
        }
        return faktoren;
    }
    
    /**
     * &Uuml;berpr&uuml;fe die Goldbachsche Vermutung, dass jede gerade Zahl als 
     * Summe zweier Primzahlen geschrieben werden kann, bis zu einer Grenzzahl.
     * 
     * @param grenze Grenzzahl
     */
    public void goldbach(int grenze){
        berechnePrimzahlenBis(grenze);
        
        StringBuilder out = new StringBuilder();
        for(int zahl=4;zahl<=grenze;zahl=zahl+2){
            out.append(zahl+"");
            for(int pos = 0;pos<primzahlListe.size();pos++){
                int primzahl = primzahlListe.get(pos);
                if (primzahl>zahl/2){
                    break;
                }
                int differenz = zahl -primzahl;
                if (primzahlListe.contains(differenz)){
                    out.append("="+primzahl+"+"+differenz);
                }
            }
            out.append("\n");
        }
        System.out.println(out.toString());
    }
    
    /**
     * Zerlege alle Primzahlen, die bei der Division durch 4 den Rest 1 lassen als 
     * Summe von zwei Quadratzahlen
     * 
     * @param grenze Grenzzahl
     */
    public void primzahlAlsSummeZweierQuadratzahlen(int grenze){
        berechnePrimzahlenBis(grenze);
        
        List<Integer> quadratzahlen = new ArrayList<>();
        for(int zahl = 0;zahl<=Math.sqrt(grenze);zahl++){
            quadratzahlen.add(zahl*zahl);
        }
        
        StringBuilder ausgabe = new StringBuilder();
        for(int pos = 0;pos<primzahlListe.size();pos++){
            int primzahl = primzahlListe.get(pos);
            if (primzahl%4==1){
                for(int q = 0;q<quadratzahlen.size();q++){
                    int quadratzahl = quadratzahlen.get(q);
                    Integer differenz = primzahl-quadratzahl;
                    if (quadratzahlen.contains(differenz)){
                        ausgabe.append(primzahl+"="+quadratzahl+"+"+differenz+"\n");
                        break;
                    }
                }
            }
        }
        
        System.out.println(ausgabe.toString());
    }
}

