package entities;

import java.util.ArrayList;

public class Client {
    private int id;
    private String nom;
    private String telephone;
    private String email;
    private ArrayList<Commande> commandes;

    public Client(int id, String nom, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }

    public Client(String nom, String telephone, String email) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.commandes = new ArrayList<Commande>();
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

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        String commandPass = "";
        for (Commande commande : this.commandes)
            commandPass += "\n\t ** " + commande.getId() + " " + commande.getDate() + "\n";
        return "--> Client \n\t\tnom : " + nom + ", telephone : " + telephone + ", email : " + email +
                "\n\t\t  les commandes effectue : " + commandPass;
    }
}
