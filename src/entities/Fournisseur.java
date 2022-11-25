package entities;

import java.util.ArrayList;

public class Fournisseur {
    private int id;
    private String nom;
    private String telephone;
    private String email;

    public Fournisseur(int id, String nom, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }

    private ArrayList<Demande> demandes;

    public Fournisseur(int id, String nom, String telephone, String email, ArrayList<Demande> demandes) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.demandes = demandes;
    }

    public Fournisseur(String nom, String telephone, String email) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.demandes = new ArrayList<Demande>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(ArrayList<Demande> demandes) {
        this.demandes = demandes;
    }

    @Override
    public String toString() {
        String demandeIds = "";
        for (Demande demande : this.demandes)
            demandeIds += demande.getId() + " ";
        return "**Fournisseur id : " + id + ", nom : " + nom + ", telephone : " + telephone + ", email : " + email
                + ", demandeID : " + demandeIds;
    }

}
