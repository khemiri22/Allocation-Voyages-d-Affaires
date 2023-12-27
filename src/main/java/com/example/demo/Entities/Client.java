package com.example.demo.Entities;

public class Client {
    private Integer ID;
    private String Nom;
    private String Adresse;
    private String Residence;
    private String Secteur;
    private String Agence;

    public Client(Integer ID, String nom, String adressse, String residence, String secteur, String agence) {
        this.ID = ID;
        Nom = nom;
        Adresse = adressse;
        Residence = residence;
        Secteur = secteur;
        Agence = agence;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getResidence() {
        return Residence;
    }

    public void setResidence(String residence) {
        Residence = residence;
    }

    public String getSecteur() {
        return Secteur;
    }

    public void setSecteur(String secteur) {
        Secteur = secteur;
    }

    public String getAgence() {
        return Agence;
    }

    public void setAgence(String agence) {
        Agence = agence;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", Nom='" + Nom + '\'' +
                ", Adressse='" + Adresse + '\'' +
                ", Residence='" + Residence + '\'' +
                ", Secteur='" + Secteur + '\'' +
                ", Agence='" + Agence + '\'' +
                '}';
    }

}
