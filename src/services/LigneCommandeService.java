package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.LigneCommande;

public class LigneCommandeService implements IDao<LigneCommande> {

    @Override
    public boolean create(LigneCommande o) {
        try {
            String req = "insert into lignecommande values (?, ?, ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getQuantite());
            ps.setFloat(2, o.getPrixVente());
            ps.setInt(3, o.getCommand().getId());
            ps.setInt(4, o.getProduit().getId());
            if (ps.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(LigneCommande o) {
        try {
            String req = "delete from lignecommande where commande = ? and produit = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getCommand().getId());
            ps.setInt(2, o.getProduit().getId());
            if (ps.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(LigneCommande o) {
        return false;
    }

    @Override
    public LigneCommande findById(int id) {
        return null;
    }

    @Override
    public List<LigneCommande> findAll() {
        CommandeService commandeService = new CommandeService();
        ProduitService produitService = new ProduitService();
        List<LigneCommande> ligneCommandes = new ArrayList<LigneCommande>();
        try {
            String sql = "select * from lignecommande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                ligneCommandes.add(new LigneCommande(rs.getInt("quantite"), rs.getFloat("prixVente"),
                        commandeService.findById(rs.getInt("commande")),
                        produitService.findById(rs.getInt("produit"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ligneCommandes;
    }

}
