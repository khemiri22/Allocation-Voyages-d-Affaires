package com.example.demo.DAOs;

import com.example.demo.Entities.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentDAO {
    public static String Login(String username,String password)
    {
        String sql = "SELECT * FROM agent WHERE username= ? and password = ?";
        Connection connect  = Database.connectDb();
        try {
            PreparedStatement prepare  = connect.prepareStatement(sql);
            prepare.setString(1,username);
            prepare.setString(2,password);
            ResultSet result = prepare.executeQuery();
            if(result.next())
                return result.getString("type");

        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
