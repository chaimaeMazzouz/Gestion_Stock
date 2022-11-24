package entities;

public class LigneCommande {
    private int quantite;
    private float prixVente;
    private Commande command;
    private Produit produit;

    public LigneCommande(int quantite, float prixVente, Commande command, Produit produit) {
        this.quantite = quantite;
        this.prixVente = prixVente;
        this.command = command;
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public Commande getCommand() {
        return command;
    }

    public void setCommand(Commande command) {
        this.command = command;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "LigneCommande [quantite=" + quantite + ", prixVente=" + prixVente + ", commandId=" + command.getId()
                + ", produitId=" + produit.getId() + "]\n";
    }
}
