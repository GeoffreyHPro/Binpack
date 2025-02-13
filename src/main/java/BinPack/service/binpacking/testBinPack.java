package BinPack.service.binpacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class testBinPack {
    
    public static PblBinPack lireFichier(String fichier,int nbSacs){
      try{
      // Le fichier d'entrée
      File file = new File(fichier);    
      // Créer l'objet File Reader
      FileReader fr = new FileReader(file);  
      // Créer l'objet BufferedReader        
      BufferedReader br = new BufferedReader(fr);    
      String line;
      int cap = Integer.parseInt(br.readLine());
      
      line = br.readLine();
      int nb = Integer.parseInt(line);

      int[] produits = new int[nb];
      for(int i=0;i<nb;i++){
        line = br.readLine();
        produits[i] = Integer.parseInt(line);
        //System.out.println(line);    
      }
      return new PblBinPack(nb, produits, cap, nbSacs);
    }catch(IOException e){
      e.printStackTrace();
      return null;
    }
   }


    public static void main(String[] args){
      
      int nbSacs = Integer.parseInt(args[2]);

      PblBinPack pb = lireFichier(args[0],nbSacs);
      pb.main(args[1]);
    }
}
