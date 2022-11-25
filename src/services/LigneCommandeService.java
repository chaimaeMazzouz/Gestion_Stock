package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            String req = "delete from lignecommande where command = ? and produit = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getCommand().getId());
            if (ps.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(LigneCommande o) {
        try {
            String req = "update lignecommande set quantite = ? , prixvente = ? where command = ? and produit = ?";
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
    public LigneCommande findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<LigneCommande> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
