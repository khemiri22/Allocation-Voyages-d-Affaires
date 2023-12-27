package com.example.demo.DAOs;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
*  private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

*/

public class ClientDAO {
    public static ObservableList<Client> CLientList(){
        ObservableList<Client> data = FXCollections.observableArrayList();
        String sql = "SELECT * FROM client";
        Connection connect = Database.connectDb();
        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                Client client = new Client(result.getInt("id"), result.getString("nom"), result.getString("adresse"), result.getString("residence"), result.getString("secteur"), result.getString("agence"));
                data.add(client);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }
}

