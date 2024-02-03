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
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author quanv
 */
public class InsertSuppliesFormController implements Initializable {

    @FXML
    private Label supplies_CI_supplieID;

    @FXML
    private Label supplies_CI_supplieName;

    @FXML
    private Label supplies_CI_supplieOrigin;

    @FXML
    private Label supplies_CI_suppliePrice;

    @FXML
    private Label supplies_CI_supplieProductionYear;

    @FXML
    private Label supplies_CI_supplieQuantity;

    @FXML
    private Label supplies_CI_supplieUnit;

    @FXML
    private Label supplies_CI_supplieStatus;

    @FXML
    private TextField supplies_supplieID;

    @FXML
    private TextField supplies_supplieName;

    @FXML
    private TextField supplies_supplieOrigin;

    @FXML
    private TextField supplies_suppliePrice;

    @FXML
    private TextField supplies_supplieProductionYear;

    @FXML
    private TextField supplies_supplieQuantity;

    @FXML
    private ComboBox<String> supplies_supplieStatus;

    @FXML
    private ComboBox<String> supplies_supplieUnit;

    private AlertMessage alert = new AlertMessage();
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public void suppliesClearFields() {
        supplies_supplieID.clear();
        supplies_supplieName.clear();
        supplies_supplieOrigin.clear();
        supplies_suppliePrice.clear();
        supplies_supplieProductionYear.clear();
        supplies_supplieQuantity.clear();
        supplies_supplieUnit.getSelectionModel().clearSelection();
        supplies_supplieStatus.getSelectionModel().clearSelection();

        supplies_CI_supplieID.setText("");
        supplies_CI_supplieName.setText("");
        supplies_CI_supplieOrigin.setText("");
        supplies_CI_suppliePrice.setText("");
        supplies_CI_supplieProductionYear.setText("");
        supplies_CI_supplieQuantity.setText("");
        supplies_CI_supplieUnit.setText("");
        supplies_CI_supplieStatus.setText("");
    }

    @FXML
    void supplieAddBtn(ActionEvent event) {
        connect = Database.connectDB();

        if (supplies_CI_supplieID.getText().isEmpty()
                || supplies_CI_supplieName.getText().isEmpty()
                || supplies_CI_supplieOrigin.getText().isEmpty()
                || supplies_CI_suppliePrice.getText().isEmpty()
                || supplies_CI_supplieProductionYear.getText().isEmpty()
                || supplies_CI_supplieQuantity.getText().isEmpty()
                || supplies_CI_supplieUnit.getText().isEmpty()
                || supplies_CI_supplieStatus.getText().isEmpty()) {
            alert.errorMessage("Something wenr wrong");
        } else {
            String selectData = "SELECT MAX(suppliesID) FROM supplies";

            int tempSupID = 0;
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(selectData);

                if (result.next()) {
                    tempSupID = result.getInt("MAX(suppliesID)") + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
            try {

                String checkSuppliesID = "SELECT * FROM supplies WHERE suppliesID = '"
                        + supplies_CI_supplieID.getText() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkSuppliesID);
                if (result.next()) {
                    alert.errorMessage(supplies_CI_supplieID.getText() + " is already exist");

                } else {
                    String insertData = "INSERT INTO supplies (id, suppliesID, name, origin, Price, "
                            + "productionYear, quantity, unit, status) "
                            + "VALUES(?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(tempSupID));
                    prepare.setString(2, supplies_CI_supplieID.getText());
                    prepare.setString(3, supplies_CI_supplieName.getText());
                    prepare.setString(4, supplies_CI_supplieOrigin.getText());
                    prepare.setString(5, supplies_CI_suppliePrice.getText());
                    prepare.setString(6, supplies_CI_supplieProductionYear.getText());
                    prepare.setString(7, supplies_CI_supplieQuantity.getText());
                    prepare.setString(8, supplies_CI_supplieUnit.getText());
                    prepare.setString(9, supplies_CI_supplieStatus.getText());

                    prepare.executeUpdate();

                    alert.successMessage("Added successfully!");
                    // TO CLEAR ALL FIELDS AND SOME LABELS
                    suppliesClearFields();
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }
    }

    @FXML
    void supplieConfirmBtn(ActionEvent event
    ) {
        if (supplies_supplieID.getText().isEmpty()
                || supplies_supplieName.getText().isEmpty()
                || supplies_supplieOrigin.getText().isEmpty()
                || supplies_suppliePrice.getText().isEmpty()
                || supplies_supplieProductionYear.getText().isEmpty()
                || supplies_supplieQuantity.getText().isEmpty()
                || supplies_supplieUnit.getSelectionModel().getSelectedItem() == null
                || supplies_supplieStatus.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            supplies_CI_supplieID.setText(supplies_supplieID.getText());
            supplies_CI_supplieName.setText(supplies_supplieName.getText());
            supplies_CI_supplieOrigin.setText(supplies_supplieOrigin.getText());
            supplies_CI_suppliePrice.setText(supplies_suppliePrice.getText());
            supplies_CI_supplieProductionYear.setText(supplies_supplieProductionYear.getText());
            supplies_CI_supplieQuantity.setText(supplies_supplieQuantity.getText());
            supplies_CI_supplieUnit.setText((String) supplies_supplieUnit.getSelectionModel().getSelectedItem());
            supplies_CI_supplieStatus.setText((String) supplies_supplieStatus.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void cancelBtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Đóng cửa sổ
        stage.close();
    }

    public void unitList() {
        List<String> unitL = new ArrayList<>();

        for (String data : Data.unit) {
            unitL.add(data);
        }

        ObservableList listData = FXCollections.observableList(unitL);
        supplies_supplieUnit.setItems(listData);
    }

    public void statusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : Data.status) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableList(statusL);
        supplies_supplieStatus.setItems(listData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        unitList();
        statusList();
    }
}
