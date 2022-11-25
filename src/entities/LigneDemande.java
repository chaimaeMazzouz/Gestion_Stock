package entities;

public class LigneDemande {
    private int quantite;
    private float prix;
    private Demande demande;
    private Produit produit;

    public LigneDemande(int quantite, float prix, Demande demande, Produit produit) {
        this.quantite = quantite;
        this.prix = prix;
        this.demande = demande;
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "LigneDemande quantite : " + quantite + ", prix : " + prix + ", demande : " + demande + ", produit : "
                + produit;
    }

}
