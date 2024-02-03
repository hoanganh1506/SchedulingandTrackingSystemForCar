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
 * FXML Controller class
 *
 * @author quanv
 */
public class InsertServicesFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label services_CI_serviceDepict;

    @FXML
    private Label services_CI_serviceID;

    @FXML
    private Label services_CI_serviceName;

    @FXML
    private Label services_CI_servicePrice;

    @FXML
    private Label services_CI_serviceUnit;

    @FXML
    private TextField services_serviceDepict;

    @FXML
    private TextField services_serviceID;

    @FXML
    private TextField services_servicePrice;

    @FXML
    private ComboBox<String> services_serviceUnit;

    @FXML
    private TextField services_serviceName;

    private AlertMessage alert = new AlertMessage();
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public void servicesClearFields() {
        services_serviceID.clear();
        services_serviceUnit.getSelectionModel().clearSelection();
        services_serviceName.clear();
        services_servicePrice.clear();
        services_serviceDepict.clear();

        services_CI_serviceID.setText("");
        services_CI_serviceName.setText("");
        services_CI_serviceUnit.setText("");
        services_CI_servicePrice.setText("");
        services_CI_serviceDepict.setText("");
    }

    @FXML
    void AddBtn(ActionEvent event) {

        connect = Database.connectDB();

        if (services_CI_serviceID.getText().isEmpty()
                || services_CI_serviceName.getText().isEmpty()
                || services_CI_serviceUnit.getText().isEmpty()
                || services_CI_servicePrice.getText().isEmpty()
                || services_CI_serviceDepict.getText().isEmpty()) {
            alert.errorMessage("Something wenr wrong");
        } else {
            String selectData = "SELECT MAX(serviceID) FROM services";

            int tempSerID = 0;
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(selectData);

                if (result.next()) {
                    tempSerID = result.getInt("MAX(serviceID)") + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }

            try {

                String checkSuppliesID = "SELECT * FROM services WHERE serviceID = '"
                        + services_CI_serviceID.getText() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkSuppliesID);
                if (result.next()) {
                    alert.errorMessage(services_CI_serviceID.getText() + " is already exist");

                } else {
                    String insertData = "INSERT INTO services (id, serviceID, name, unit, price, "
                            + "depict, status) "
                            + "VALUES(?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(tempSerID));
                    prepare.setString(2, services_CI_serviceID.getText());
                    prepare.setString(3, services_CI_serviceName.getText());
                    prepare.setString(4, services_CI_serviceUnit.getText());
                    prepare.setString(5, services_CI_servicePrice.getText());
                    prepare.setString(6, services_CI_serviceDepict.getText());
                    prepare.setString(7, "Confirm");

                    prepare.executeUpdate();

                    alert.successMessage("Added successfully!");
                    // TO CLEAR ALL FIELDS AND SOME LABELS
                    servicesClearFields();
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }

    }

    @FXML
    void cancelBtn(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Đóng cửa sổ
        stage.close();

    }

    @FXML
    void serviceConfirmBtn(ActionEvent event) {
        if (services_serviceID.getText().isEmpty()
                || services_serviceName.getText().isEmpty()
                || services_servicePrice.getText().isEmpty()
                || services_serviceDepict.getText().isEmpty()
                || services_serviceUnit.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            services_CI_serviceID.setText(services_serviceID.getText());
            services_CI_serviceName.setText(services_serviceName.getText());
            services_CI_serviceUnit.setText((String) services_serviceUnit.getSelectionModel().getSelectedItem());
            services_CI_servicePrice.setText(services_servicePrice.getText());
            services_CI_serviceDepict.setText(services_serviceDepict.getText());
        }

    }

    public void unitList() {
        List<String> unitL = new ArrayList<>();

        for (String data : Data.unit) {
            unitL.add(data);
        }

        ObservableList listData = FXCollections.observableList(unitL);
        services_serviceUnit.setItems(listData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        unitList();
    }

}
