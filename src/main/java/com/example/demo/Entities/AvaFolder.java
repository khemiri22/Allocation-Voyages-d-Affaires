package com.example.demo.Entities;

public class AvaFolder {
    private Integer ID;
    private String Type;
    private Integer Titulaire;
    private Double MontantCalcul;
    private Double DroitInitial;
    private Double SoldeAva;
    private String DateDomiciliation;
    private String DeclarationFiscal;
    private String Status;

    public AvaFolder(Integer ID, String type, Integer titulaire, Double montantCalcul, Double droitInitial, Double soldeAva, String dateDomiciliation, String declarationFiscal, String status) {
        this.ID = ID;
        Type = type;
        Titulaire = titulaire;
        MontantCalcul = montantCalcul;
        DroitInitial = droitInitial;
        SoldeAva = soldeAva;
        DateDomiciliation = dateDomiciliation;
        DeclarationFiscal = declarationFiscal;
        Status = status;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Integer getTitulaire() {
        return Titulaire;
    }

    public void setTitulaire(Integer titulaire) {
        Titulaire = titulaire;
    }

    public Double getMontantCalcul() {
        return MontantCalcul;
    }

    public void setMontantCalcul(Double montantCalcul) {
        MontantCalcul = montantCalcul;
    }

    public Double getDroitInitial() {
        return DroitInitial;
    }

    public void setDroitInitial(Double droitInitial) {
        DroitInitial = droitInitial;
    }

    public Double getSoldeAva() {
        return SoldeAva;
    }

    public void setSoldeAva(Double soldeAva) {
        SoldeAva = soldeAva;
    }

    public String getDateDomiciliation() {
        return DateDomiciliation;
    }

    public void setDateDomiciliation(String dateDomiciliation) {
        DateDomiciliation = dateDomiciliation;
    }

    public String getDeclarationFiscal() {
        return DeclarationFiscal;
    }

    public void setDeclarationFiscal(String declarationFiscal) {
        DeclarationFiscal = declarationFiscal;
    }

    @Override
    public String toString() {
        return "AvaFolder{" +
                "ID=" + ID +
                ", Type=" + Type +
                ", Titulaire=" + Titulaire +
                ", MontantCalcul=" + MontantCalcul +
                ", DroitInitial=" + DroitInitial +
                ", SoldeAva=" + SoldeAva +
                ", DateDomiciliation='" + DateDomiciliation + '\'' +
                ", DeclarationFiscal='" + DeclarationFiscal + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
