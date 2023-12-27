package com.example.demo.Controllers;

import com.example.demo.DAOs.ClientDAO;
import com.example.demo.Entities.Client;
import com.example.demo.Entities.SharedData;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientManagerView implements Initializable {

    @FXML
    private TableColumn<Client, String> clientAdresse_col;

    @FXML
    private TableColumn<Client, String> clientAgence_col;

    @FXML
    private TableColumn<Client, Integer> clientID_col;

    @FXML
    private TableColumn<Client, String> clientNom_col;

    @FXML
    private TableColumn<Client, String> clientResidence_col;

    @FXML
    private TableColumn<Client, String> clientSecteur_col;

    @FXML
    private TableView<Client> client_tableView;

    @FXML
    private TextField searchClient_field;
    @FXML
    private Button openFolder_bnt;
    @FXML
    private Button logout;
    private ObservableList<Client> dataList;

    public void Logout() throws IOException {
        logout.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/login-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root,600,400);;
        stage.setScene(scene);
        stage.show();
    }

    public void showClientsListData()
    {
        dataList = ClientDAO.CLientList();
        clientID_col.setCellValueFactory(new PropertyValueFactory<>("ID"));
        clientNom_col.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        clientAdresse_col.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        clientResidence_col.setCellValueFactory(new PropertyValueFactory<>("Residence"));
        clientSecteur_col.setCellValueFactory(new PropertyValueFactory<>("Secteur"));
        clientAgence_col.setCellValueFactory(new PropertyValueFactory<>("Agence"));
        client_tableView.setItems(dataList);

    }

    public void clientSearch(){
        FilteredList<Client> filteredList = new FilteredList<>(dataList, e ->true);
        client_tableView.setItems(filteredList);
        searchClient_field.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredList.setPredicate(predicateClientData ->{
                if(newValue ==null || newValue.isEmpty()){
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if(predicateClientData.getID().toString().contains(searchKey)){
                    return true;
                } else if (predicateClientData.getNom().toLowerCase().contains(searchKey)) {
                    return true;
                }
                else if (predicateClientData.getAdresse().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateClientData.getResidence().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateClientData.getSecteur().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateClientData.getAgence().toLowerCase().contains(searchKey)) {
                    return true;
                }
                return false;
            });
        });

    }
    public void getSelectedItem()
    {
        int num = client_tableView.getSelectionModel().getSelectedIndex();
        if(num-1<-1)
            return;
        SharedData.currentClient = client_tableView.getSelectionModel().getSelectedItem();


    }
    public void moveToAddAvaFolder() throws IOException {
        if(SharedData.currentClient == null)
            return;
        openFolder_bnt.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/ava_folder-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showClientsListData();
        clientSearch();
    }
}
