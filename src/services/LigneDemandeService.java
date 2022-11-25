package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.LigneDemande;

public class LigneDemandeService implements IDao<LigneDemande> {

    @Override
    public boolean create(LigneDemande o) {
        try {
            String req = "insert into lignedemande values (?, ?, ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getQuantite());
            ps.setFloat(2, o.getPrix());
            ps.setInt(3, o.getDemande().getId());
            ps.setInt(4, o.getProduit().getId());
            if (ps.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(LigneDemande o) {
        try {
            String req = "delete from lignecommande where demande = ? and produit = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getDemande().getId());
            ps.setInt(2, o.getProduit().getId());
            if (ps.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(LigneDemande o) {
        return false;
    }

    @Override
    public LigneDemande findById(int id) {
        return null;
    }

    @Override
    public List<LigneDemande> findAll() {
        DemandeService demandeService = new DemandeService();
        ProduitService produitService = new ProduitService();
        List<LigneDemande> ligneDemandes = new ArrayList<LigneDemande>();
        try {
            String sql = "select * from lignedemande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                ligneDemandes.add(new LigneDemande(rs.getInt("quantite"), rs.getFloat("prix"),
                        demandeService.findById(rs.getInt("demande")),
                        produitService.findById(rs.getInt("produit"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ligneDemandes;
    }

}
