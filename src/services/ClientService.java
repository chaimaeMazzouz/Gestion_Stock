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

    private List<Client> clients;

    public ClientService() {
        this.clients = new ArrayList<Client>();
    }

    @Override
    public boolean create(Client o) {
        try {
            String req = "insert into client values (null, ?, ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getEmail());
            if (ps.executeUpdate() == 1)
                return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
            // TODO Auto-generated catch block
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
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
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
