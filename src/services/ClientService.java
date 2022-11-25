package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Client;

public class ClientService implements IDao<Client> {

    public ClientService() {
    }

    @Override
    public boolean create(Client o) {
        try {
            String req = "insert into client values (null, ?, ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getEmail());
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int lastInserted = rs.getInt(1);
                o.setId(lastInserted);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Client o) {
        try {
            String req = "delete from client where id  = ?";
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
    public boolean update(Client o) {
        try {
            String req = "update client set nom = ? , telephone = ?, email = ? where id = ?";
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
    public Client findById(int id) {
        Client client = null;
        try {
            String sql = "select * from client where id=" + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                client = new Client(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("telephone"),
                        rs.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<Client>();
        try {
            String sql = "select * from client";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                clients.add(new Client(rs.getString("nom"), rs.getString("telephone"),
                        rs.getString("email")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

}
