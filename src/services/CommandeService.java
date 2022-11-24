package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Commande;

public class CommandeService implements IDao<Commande> {

    private ClientService cs;

    public CommandeService() {
        cs = new ClientService();
    }

    @Override
    public boolean create(Commande o) {
        try {
            String req = "insert into commande values (null, ?, ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setDate(1, new Date(o.getDate().getTime()));
            ps.setInt(2, o.getClient().getId());
            if (ps.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Commande o) {
        try {
            String req = "delete from commande where id  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Commande o) {
        try {
            String req = "update commande set date = ?, client = ? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setDate(1, new Date(o.getDate().getTime()));
            ps.setInt(2, o.getClient().getId());
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Commande findById(int id) {

        return null;
    }

    @Override
    public List<Commande> findAll() {
        List<Commande> commandes = new ArrayList<Commande>();
        try {
            String sql = "select * from commande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                commandes.add(new Commande(rs.getInt("id"),
                        rs.getDate("date"), cs.findById(rs.getInt("client"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }

}
