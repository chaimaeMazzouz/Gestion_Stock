package entities;

public class Produit {
    private int id;
    private String designation;
    private float prixAchat;

    private static int count = 0;

    public Produit(int id, String designation, float prixAchat) {
        this.id = id;
        this.designation = designation;
        this.prixAchat = prixAchat;
    }

    public Produit(String designation, float prixAchat) {
        this.id = ++count;
        this.designation = designation;
        this.prixAchat = prixAchat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

}
