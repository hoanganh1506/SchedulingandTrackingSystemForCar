/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsc_new;

import stsc_new.Data;
import stsc_new.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author quanv
 */
public class EditServicesFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField editServices_serviceDepict;

    @FXML
    private TextField editServices_serviceID;

    @FXML
    private TextField editServices_serviceName;

    @FXML
    private TextField editServices_servicePrice;

    @FXML
    private ComboBox<String> editServices_serviceStatus;

    @FXML
    private ComboBox<String> editServices_serviceUnit;

    
    private AlertMessage alert = new AlertMessage();
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @FXML
    void cancelBtn(ActionEvent event) {
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Đóng cửa sổ
        stage.close();

    }

    @FXML
    void updateBtn(ActionEvent event) {
        
        if (editServices_serviceID.getText().isEmpty()
                || editServices_serviceName.getText().isEmpty()
                || editServices_servicePrice.getText().isEmpty()
                || editServices_serviceDepict.getText().isEmpty()
                || editServices_serviceUnit.getSelectionModel().getSelectedItem() == null
                || editServices_serviceStatus.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            String updateData = "UPDATE services SET name = ?, price = ?"
                    + ", unit = ?, depict = ?, status = ?"
                    + "WHERE serviceID = '"
                    + editServices_serviceID.getText() + "'";
            connect = Database.connectDB();
            try {
                if (alert.confirmationMessage("Are you sure you want to UPDATE Service ID: " + editServices_serviceID.getText()
                        + "?")) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, editServices_serviceName.getText());
                    prepare.setString(2, editServices_servicePrice.getText());
                    prepare.setString(3, editServices_serviceUnit.getSelectionModel().getSelectedItem());
                    prepare.setString(4, editServices_serviceDepict.getText());
                    prepare.setString(5, editServices_serviceStatus.getSelectionModel().getSelectedItem());
                    prepare.executeUpdate();
                    alert.successMessage("Updated Successfully!");
                } else {
                    alert.errorMessage("Cancelled.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }

    }
    
    public void displayServicesData() {
        String sql = "SELECT * FROM services WHERE serviceID = '"
                + editServices_serviceID.getText() + "'";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                editServices_serviceName.setText(result.getString("name"));
                editServices_serviceUnit.getSelectionModel().select(result.getString("unit"));
                editServices_servicePrice.setText(result.getString("price"));
                editServices_serviceDepict.setText(result.getString("depict"));
                editServices_serviceStatus.getSelectionModel().select(result.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }
    
    public void setField() {
        editServices_serviceID.setText(Data.temp_serviceID);
        editServices_serviceName.setText(Data.temp_serviceName);
        editServices_serviceUnit.getSelectionModel().select(Data.temp_serviceUnit);
        editServices_servicePrice.setText(Data.temp_servicePrice);
        editServices_serviceDepict.setText(Data.temp_serviceDepict);
        editServices_serviceStatus.getSelectionModel().select(Data.temp_serviceStatus);
        
        }
    
    public void statusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : Data.status) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableList(statusL);
        editServices_serviceStatus.setItems(listData);
    }
    
    public void unitList() {
        List<String> unitL = new ArrayList<>();

        for (String data : Data.unit) {
            unitL.add(data);
        }

        ObservableList listData = FXCollections.observableList(unitL);
        editServices_serviceUnit.setItems(listData);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        unitList();
        statusList();
        setField();
    }    
    
}
