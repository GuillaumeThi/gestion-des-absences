package dev.entity;

public enum TypeAbsence {
	
	CONGES_PAYES("Congés payés", true),
    RTT_EMPLOYE("RTT employé", true),
    CONGES_SANSS("Congés sans solde", true),
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
}
