package entities;

import java.util.ArrayList;
import java.util.Date;

public class Commande {
    private int id;
    private Date date;
    private Client client;

    private ArrayList<LigneCommande> ligneCommandes;

    private static int count;

    public Commande(int id, Date date, Client client) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.ligneCommandes = new ArrayList<>();
    }

    public Commande(Date date, Client client) {
        this.id = ++count;
        this.date = date;
        this.client = client;
        this.ligneCommandes = new ArrayList<>();
    }

    public Commande(int id, Date date, Client client, ArrayList<LigneCommande> ligneCommandes) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.ligneCommandes = ligneCommandes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(ArrayList<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    @Override
    public String toString() {
        String txt = "Commande id=" + id + ", date=" + date + ", ClientId=" + client.getId()
                + " \nligneCommandes : ";
        for (LigneCommande ligneCommande : ligneCommandes)
            txt += ligneCommande.toString();
        return txt;
    }

}
