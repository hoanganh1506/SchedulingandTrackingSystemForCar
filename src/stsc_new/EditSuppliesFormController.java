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
 *
 * @author quanv
 */
public class EditSuppliesFormController implements Initializable {

    @FXML
    private TextField editSupplies_Name;

    @FXML
    private javafx.scene.control.Button editSupplies_cancelBtn;

    @FXML
    private TextField editSupplies_origin;

    @FXML
    private TextField editSupplies_price;

    @FXML
    private TextField editSupplies_productionYear;

    @FXML
    private TextField editSupplies_quantity;

    @FXML
    private ComboBox<String> editSupplies_status;

    @FXML
    private TextField editSupplies_suppliesID;

    @FXML
    private ComboBox<String> editSupplies_unit;

    @FXML
    private javafx.scene.control.Button editSupplies_updateBtn;

    private AlertMessage alert = new AlertMessage();
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void displaySuppliesData() {
        String sql = "SELECT * FROM supplies WHERE suppliesID = '"
                + editSupplies_suppliesID.getText() + "'";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                editSupplies_Name.setText(result.getString("name"));
                editSupplies_origin.setText(result.getString("origin"));
                editSupplies_productionYear.setText(result.getString("productionYear"));
                editSupplies_unit.getSelectionModel().select(result.getString("unit"));
                editSupplies_price.setText(result.getString("price"));
                editSupplies_quantity.setText(result.getString("quantity"));
                editSupplies_status.getSelectionModel().select(result.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    @FXML
    void cancelBtn(ActionEvent event) {
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Đóng cửa sổ
        stage.close();

    }

    @FXML
    void updateBtn(ActionEvent event) {

        if (editSupplies_suppliesID.getText().isEmpty()
                || editSupplies_Name.getText().isEmpty()
                || editSupplies_origin.getText().isEmpty()
                || editSupplies_productionYear.getText().isEmpty()
                || editSupplies_unit.getSelectionModel().getSelectedItem() == null
                || editSupplies_price.getText().isEmpty()
                || editSupplies_quantity.getText().isEmpty()
                || editSupplies_status.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            String updateData = "UPDATE supplies SET name = ?, origin = ?"
                    + ", productionYear = ?, unit = ?, price = ?, quantity = ? , status = ?"
                    + "WHERE suppliesID = '"
                    + editSupplies_suppliesID.getText() + "'";
            connect = Database.connectDB();
            try {
                if (alert.confirmationMessage("Are you sure you want to UPDATE Supplies ID: " + editSupplies_suppliesID.getText()
                        + "?")) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, editSupplies_Name.getText());
                    prepare.setString(2, editSupplies_origin.getText());
                    prepare.setString(3, editSupplies_productionYear.getText());
                    prepare.setString(4, editSupplies_unit.getSelectionModel().getSelectedItem());
                    prepare.setString(5, editSupplies_price.getText());
                    prepare.setString(6, editSupplies_quantity.getText());
                    prepare.setString(7, editSupplies_status.getSelectionModel().getSelectedItem());
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

    public void setField() {
        editSupplies_suppliesID.setText(Data.temp_suppliesID);
        editSupplies_Name.setText(Data.temp_suppliesName);
        editSupplies_origin.setText(Data.temp_suppliesOrigin);
        editSupplies_productionYear.setText(Data.temp_suppliesProductionYear);
        editSupplies_unit.getSelectionModel().select(Data.temp_suppliesUnit);
        editSupplies_price.setText(Data.temp_suppliesPrice);
        editSupplies_quantity.setText(Data.temp_suppliesQuantity);
        editSupplies_status.getSelectionModel().select(Data.temp_suppliesStatus);

    }

    public void unitList() {
        List<String> unitL = new ArrayList<>();

        for (String data : Data.unit) {
            unitL.add(data);
        }

        ObservableList listData = FXCollections.observableList(unitL);
        editSupplies_unit.setItems(listData);
    }

    public void statusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : Data.status) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableList(statusL);
        editSupplies_status.setItems(listData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setField();
        unitList();
        statusList();

    }

}
