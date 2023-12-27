package com.example.demo.DAOs;

import com.example.demo.Entities.AvaFolder;
import com.example.demo.Entities.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaFolderDAO {
    public static void ajouterDossierAva(AvaFolder avaFolder){
        String sql = "INSERT INTO avafolder (type,montantCalcul,droitInitial,soldeAva,DateDomiciliation,declarationFiscal,titulaire,status) VALUES (?,?,?,?,?,?,?,?)";
        Connection connect = Database.connectDb();
        try{
            PreparedStatement prepare = connect.prepareStatement(sql);
            prepare.setString(1,avaFolder.getType());
            prepare.setDouble(2,avaFolder.getMontantCalcul());
            prepare.setDouble(3,avaFolder.getDroitInitial());
            prepare.setDouble(4,avaFolder.getSoldeAva());
            prepare.setString(5,avaFolder.getDateDomiciliation());
            prepare.setString(6,avaFolder.getDeclarationFiscal());
            prepare.setInt(7,avaFolder.getTitulaire());
            prepare.setString(8,avaFolder.getStatus());
            prepare.executeUpdate();
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }
    public static ObservableList<AvaFolder> AvaList(){
        ObservableList<AvaFolder> data = FXCollections.observableArrayList();
        String sql = "SELECT * FROM avafolder";
        Connection connect = Database.connectDb();
        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                AvaFolder ava = new AvaFolder(result.getInt("id"), result.getString("type"), result.getInt("titulaire"),result.getDouble("montantCalcul"), result.getDouble("droitInitial"), result.getDouble("soldeAva"), result.getString("dateDomiciliation"),result.getString("declarationFiscal"), result.getString("status"));
                data.add(ava);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public static void ChangeStatus(int id,String status)
    {
        String sql = "UPDATE avafolder SET status = ? WHERE id = ?";
        Connection connect = Database.connectDb();
        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            prepare.setString(1,status);
            prepare.setInt(2,id);
            prepare.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
