package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Fournisseur;

public class FournisseurService implements IDao<Fournisseur> {
    private ArrayList<Fournisseur> fournisseurs;

    public FournisseurService() {
        this.fournisseurs = new ArrayList<>();
    }

    @Override
    public boolean create(Fournisseur o) {
        try {
            String req = "insert into fournisseur values (null, ?, ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getEmail());
            if (ps.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Fournisseur o) {
        try {
            String req = "delete from fournisseur where id  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Fournisseur o) {
        try {
            String req = "update fournisseur set nom = ? , telephone = ?, email = ? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            if (ps.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Fournisseur findById(int id) {
        for (Fournisseur c : this.fournisseurs)
            if (c.getId() == id)
                return c;
        return null;
    }

    @Override
    public List<Fournisseur> findAll() {
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        try {
            String sql = "select * from fournisseur";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                fournisseurs.add(new Fournisseur(rs.getString("nom"), rs.getString("telephone"),
                        rs.getString("email")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fournisseurs;
    }

    @Override
    public String toString() {
        String info = "";
        for (Fournisseur c : this.fournisseurs)
            info += c.toString();
        return info;
    }

}
