package com.example.demo.DAOs;

import com.example.demo.Entities.Agent;
import com.example.demo.Entities.Client;
import com.example.demo.Entities.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AgentDAOTest {
    @NotNull
    public static ArrayList<Agent> getAgents(){
            ArrayList<Agent> data = new ArrayList<Agent>();
            String sql = "SELECT * FROM agent";
            Connection connect = Database.connectDb();
            try {
                PreparedStatement prepare = connect.prepareStatement(sql);
                ResultSet result = prepare.executeQuery();
                while (result.next()) {
                    Agent agent = new Agent(result.getString("username"),result.getString("password"),result.getString("type"));
                    data.add(agent);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return data;

    }

    @Test
    void loginTestEmptyFields() {
        assertNull(AgentDAO.Login("", ""));
    }
    @Test
    void loginTestEmptyUsername() {
        ArrayList<Agent> agents = getAgents();
        for(Agent agent : agents){
            assertNull(AgentDAO.Login("", agent.getPassword()));
        }

    }
    @Test
    void loginTestEmptyPassword() {
        ArrayList<Agent> agents = getAgents();
        for(Agent agent : agents){
            assertNull(AgentDAO.Login(agent.getUsername(), ""));
        }
    }
    @Test
    void loginTestWrongUsernameAndPassword() {
        assertNull(AgentDAO.Login("this_username_can't_be_used in the username_field","this_password_can't_be_used in the username_field"));
    }
    @Test
    void loginTestWrongUsername() {
        ArrayList<Agent> agents = getAgents();
        for(Agent agent : agents){
            assertNull(AgentDAO.Login("this_username_can't_be_used in the username_field", agent.getPassword()));
        }
    }
    @Test
    void loginTestWrongPassword() {
        ArrayList<Agent> agents = getAgents();
        for(Agent agent : agents){
            assertNull(AgentDAO.Login(agent.getUsername(),"this_password_can't_be_used in the username_field"));
        }
    }
    @Test
    void loginInternAgentTest() {
        List<Agent> agents =getAgents().stream().filter(a -> a.getType().equals("in")).collect(Collectors.toList());
        for(Agent agent : agents){
            assertEquals("in",AgentDAO.Login(agent.getUsername(),agent.getPassword()));
        }
    }
    @Test
    void loginExternAgentTest() {
        List<Agent> agents =getAgents().stream().filter(a -> a.getType().equals("out")).collect(Collectors.toList());
        for(Agent agent : agents){
            assertEquals("out",AgentDAO.Login(agent.getUsername(),agent.getPassword()));
        }
    }
}