package com.example.demo.Controllers;

import com.example.demo.DAOs.AvaFolderDAO;
import com.example.demo.Entities.AvaFolder;
import com.example.demo.Entities.SharedData;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AvaManagerView implements Initializable {

    @FXML
    private TableColumn<AvaFolder, Integer> IDAva;
    @FXML
    private TableColumn<AvaFolder, String> type;
    @FXML
    private TableColumn<AvaFolder, Integer> titulaire;
    @FXML
    private TableColumn<AvaFolder, Double> MontantCalcul;
    @FXML
    private TableColumn<AvaFolder, Double> DroitInitial;
    @FXML
    private TableColumn<AvaFolder, Double> SoldeAva;

    @FXML
    private TableColumn<AvaFolder, String> DeclarationFiscal;
    @FXML
    private  TableColumn<AvaFolder,String> Status;



    @FXML
    private TableView<AvaFolder> ava_tableView;

    @FXML
    private TextField searchAva_field;
    @FXML
    private Button logout;
    private ObservableList<AvaFolder> dataList;

    public void Logout() throws IOException {
        logout.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/login-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }






    public void showAvaListData()
    {
        dataList = AvaFolderDAO.AvaList();
        dataList.forEach(af ->{
            if(Integer.parseInt(af.getStatus()) == -1){
                af.setStatus("Rejeté");
            } else if (Integer.parseInt(af.getStatus()) == 1) {
                af.setStatus("Validé");
            }else {
                af.setStatus("En Attend");
            }
        });
        IDAva.setCellValueFactory(new PropertyValueFactory<>("ID"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        titulaire.setCellValueFactory(new PropertyValueFactory<>("titulaire"));
        MontantCalcul.setCellValueFactory(new PropertyValueFactory<>("MontantCalcul"));
        DroitInitial.setCellValueFactory(new PropertyValueFactory<>("DroitInitial"));
        SoldeAva.setCellValueFactory(new PropertyValueFactory<>("SoldeAva"));
        DeclarationFiscal.setCellValueFactory(new PropertyValueFactory<>("DeclarationFiscal"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        ava_tableView.setItems(dataList);

    }

    public void avaSearch(){
        FilteredList<AvaFolder> filteredList = new FilteredList<>(dataList, e ->true);
        ava_tableView.setItems(filteredList);
        searchAva_field.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredList.setPredicate(predicateAvaData ->{
                if(newValue ==null || newValue.isEmpty()){
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if(predicateAvaData.getID().toString().contains(searchKey)){
                    return true;
                } else if (predicateAvaData.getType().toLowerCase().contains(searchKey)) {
                    return true;
                }
                else if (predicateAvaData.getDeclarationFiscal().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateAvaData.getSoldeAva().toString().contains(searchKey)) {
                    return true;
                }else if (predicateAvaData.getTitulaire().toString().contains(searchKey)) {
                    return true;
                }else if (predicateAvaData.getMontantCalcul().toString().contains(searchKey)) {
                    return true;
                }else if (predicateAvaData.getDroitInitial().toString().contains(searchKey)) {
                    return true;
                }
                return false;
            });
        });

    }
    public void getSelectedItem()
    {
        int num = ava_tableView.getSelectionModel().getSelectedIndex();
        if(num-1<-1)
            return;
        SharedData.currentAva = ava_tableView.getSelectionModel().getSelectedItem();


    }
    public void consulterDeclaration() {
       if(SharedData.currentAva == null)
            return;
        try {
            String imagePath = SharedData.currentAva.getDeclarationFiscal();
            File file = new File(imagePath);
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.err.println("File does not exist: " + imagePath);
                }
            } else {
                System.err.println("Desktop is not supported on this platform");
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error opening image: " + e.getMessage());
        }

    }
    public void valider(){
        if(SharedData.currentAva == null)
            return;
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Valider le dossier de titulaire : "+ SharedData.currentAva.getTitulaire()+" ?");
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get().equals(ButtonType.OK)){
            AvaFolderDAO.ChangeStatus(SharedData.currentAva.getID(),"1");
            showAvaListData();
            avaSearch();
        }
    }
    public void rejeter(){
        if(SharedData.currentAva == null)
            return;
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Rejeter le dossier de titulaire : "+ SharedData.currentAva.getTitulaire()+" ?");
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get().equals(ButtonType.OK)){
            AvaFolderDAO.ChangeStatus(SharedData.currentAva.getID(),"-1");
            showAvaListData();
            avaSearch();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAvaListData();
        avaSearch();

    }

}
