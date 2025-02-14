package BinPack.service.binpacking;

import java.util.Random;
import java.util.Scanner;

class PblBinPack{

  private int nbObjects;
  private int poids[];
  private int cap;
  private int nbSacs;

  public PblBinPack(int nbObjects,int poids[], int cap,int nbSacs){
    this.nbObjects = nbObjects;
    this.cap = cap;
    this.nbSacs = nbSacs;
    this.poids = new int[nbObjects];
    for(int i=0;i<nbObjects;i++){
      this.poids[i] = poids[i];
    }
  }
  
  //Si la configuration possede une solution, 
  //on genere tous les certificat jusqu'a en trouvé un qui est solution
  public boolean explorationExhaustive(){
    if(aUneSolution()){
      int[] currentCertificate = firstCertificate();
      while(!(comparerCertificat(currentCertificate,lastCertificate()))){
        if(verification(currentCertificate)){
          affichageCertificat(currentCertificate);
          return true;
        }
        currentCertificate = certificatSuivant(currentCertificate);
      }
      System.out.println("aucune solution possible");
      return verification(currentCertificate);
    }
    System.out.println("aucune solution possible");
    return false;
  }

  //génére un certificat aléatoire en fonction des attributs du binPack
  public int[] genereCertificatAlea(){
    int certificat[] = new int[this.nbObjects];
    for(int i=0;i<this.nbObjects;i++){
      certificat[i] = new Random().nextInt(nbSacs);
    }
    
    return certificat;
  }

  private int[] certificatSuivant(int []certificat){
    for(int i = certificat.length-1;i>-1 ;i--){
      if(certificat[i] != this.nbSacs-1 ){
        certificat[i]++;
        return certificat;
      }else{
        certificat[i] = 0;
      }
    }
    return null;
  }
  
  //Fonction qui genere le premier certificat
  private int[] firstCertificate(){
    int[] certificat = new int[this.nbObjects];
    for (int i =0;i < this.nbObjects ;i++){
      certificat[i] = 0;
    }
    return certificat;
  }

  //Fonction qui genere le dernier certificat
  private int[] lastCertificate(){
    int[] certificat = new int[this.nbObjects];
    for (int i =0;i < this.nbObjects ;i++){
      certificat[i] = 1;
    }
    return certificat;
  }

  //Fonction qui vérifie si le certificat est une solution
  public boolean verification(int[] certificat){
    int[] sacs = new int[nbSacs];
    for(int j=0;j<nbSacs;j++){
      sacs[j] = 0;
    }
    
    for(int i=0;i< certificat.length;i++){
      sacs[certificat[i]] += poids[i] ;
    }
    //si le poids des objets mis dans un sac est supérieur a la capacité d'un sac
    //alors on renvoie faux
    for(int k =0;k <sacs.length ;k++){
      if(sacs[k] > cap){
        return false;
      }
    }
    return true;
  }
  
  //Fonction qui vérifie si une configuration est possible à resoudre
  public boolean aUneSolution(){
    int poidsTotal =0;
    //si le poids d'un seul objet est superieur a la capacité d'un sac alors on renvoie faux
    for(int i = 0;i< poids.length;i++){
      if(poids[i] > cap){return false;}
      poidsTotal += poids[i];
    }
    //si le poids maximal des objets est superieur a la capacité de tous les sacs
    //alors on renvoie false
    if(poidsTotal> nbSacs* cap){
      return false;
    }
    return true;
  }
  
  
  //Affiche un certificat qui est donnée en parametre
  public void affichageCertificat(int[] certificat){
    System.out.print("[" + certificat[0]);
    for(int i=1;i<certificat.length;i++){
      System.out.print("," + certificat[i]);
    }
    System.out.println("]");
  }
  
  //Permet de comparer deux certificats
  public boolean comparerCertificat(int[] certificat1, int[] certificat2){
    for(int i =0; i< certificat1.length;i++){
      if(certificat1[i] != certificat2[i]){
        return false;
      }
    }  
    return true;
  }

  public void main(String arg){
    if(arg.equals("-nd")){
      int[] certificat = genereCertificatAlea();
      if(verification(certificat)){
        affichageCertificat(certificat);

      }else{
        System.out.println("certificat n'est pas bon");
      } 
    }else if(arg.equals("-exh")){
      explorationExhaustive();
    }else if(arg.equals("-ver")){
      int[] certificat = new int[this.nbObjects];

      Scanner reader = new Scanner(System.in);  // Reading from System.in
      System.out.println("Entrez " + this.nbObjects + " indices pour le certificat");
      for(int i=0;i < this.nbObjects;i++){
        System.out.println("Donnez l'indice du sac de l'objet : " + (i+1) + ". Valeur entre " + 0 + " et " + (this.nbSacs -1));
        certificat[i] = reader.nextInt();
      }
      reader.close();
      if(verification(certificat)){
        affichageCertificat(certificat);
      }else{
        System.out.println("certificat n'est pas bon");
      }
    }
  }
}
