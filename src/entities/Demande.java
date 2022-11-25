package entities;

import java.util.ArrayList;
import java.util.Date;

public class Demande {
    private int id;
    private Date date;
    private Fournisseur fournisseur;

    public Demande(int id, Date date, Fournisseur fournisseur) {
        this.id = id;
        this.date = date;
        this.fournisseur = fournisseur;
    }

    private ArrayList<LigneDemande> ligneDemandes;

    public Demande(int id, Date date, Fournisseur fournisseur, ArrayList<LigneDemande> ligneDemandes) {
        this.id = id;
        this.date = date;
        this.fournisseur = fournisseur;
        this.ligneDemandes = ligneDemandes;
    }

    public Demande(Date date, Fournisseur fournisseur) {
        this.date = date;
        this.fournisseur = fournisseur;
        this.ligneDemandes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public ArrayList<LigneDemande> getLigneDemandes() {
        return ligneDemandes;
    }

    public void setLigneDemandes(ArrayList<LigneDemande> ligneDemandes) {
        this.ligneDemandes = ligneDemandes;
    }

    @Override
    public String toString() {
        String info = " ** Demande id : " + id + ", date : " + date + ", Fournisseur Id : " + fournisseur.getId()
                + " \n\t --> ligneDemandes : \n";
        for (LigneDemande ligneDemande : ligneDemandes)
            info += "\t- " + ligneDemande.toString();
        float prixTotal = 0;
        for (LigneDemande ligneDemande : ligneDemandes)
            prixTotal += ligneDemande.getPrix() * ligneDemande.getQuantite();
        info += "\t- Total : " + prixTotal + "\n\n";
        return info;
    }
}
