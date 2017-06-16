package dev.entity;
<<<<<<< HEAD

import java.util.Random;

public enum TypeAbsence {	
	CONGE_PAYE("Congés payés", true),
=======
import java.util.Random;
public enum TypeAbsence {   
    CONGE_PAYE("Congés payés", true),
>>>>>>> USGDA017 - Traitement de nuit #20 - US en review - correction
    RTT("RTT employé", true),
    CONGE_SANS_SOLDE("Congés sans solde", true),
    MISSION("MISSION", false);
    
    private String libelle;
    private boolean actif;
    
    private TypeAbsence(String libelle, boolean actif){
        this.libelle = libelle;
        this.actif = actif;
    }
    
    public boolean isActif() {
        return actif;
    }
    public void setActif(boolean actif) {
        this.actif = actif;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
<<<<<<< HEAD

	
	private static final TypeAbsence[] VALUES = values();
	  private static final int SIZE = VALUES.length;
	  private static final Random RANDOM = new Random();

	  public static TypeAbsence getRandomTypeAbsence()  {
	    return VALUES[RANDOM.nextInt(SIZE)];
	  }

}
=======
    
    private static final TypeAbsence[] VALUES = values();
      private static final int SIZE = VALUES.length;
      private static final Random RANDOM = new Random();
      public static TypeAbsence getRandomTypeAbsence()  {
        return VALUES[RANDOM.nextInt(SIZE)];
      }
}
>>>>>>> USGDA017 - Traitement de nuit #20 - US en review - correction
