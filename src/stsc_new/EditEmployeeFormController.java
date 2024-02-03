/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsc_new;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author WINDOWS 10
 */
public class EditEmployeeFormController implements Initializable {

    @FXML
    private TextField editEmployee_employeeID;

    @FXML
    private TextField editEmployee_fullName;

    @FXML
    private TextField editEmployee_email;

    @FXML
    private TextField editEmployee_password;

    @FXML
    private ComboBox<String> editEmployee_specialized;

    @FXML
    private ComboBox<String> editEmployee_gender;

    @FXML
    private TextField editEmployee_mobileNumber;

    @FXML
    private ImageView editEmployee_imageView;

    @FXML
    private Button editEmployee_importBtn;

    @FXML
    private TextArea editEmployee_address;

    @FXML
    private ComboBox<String> editEmployee_status;

    @FXML
    private Button editEmployee_updateBtn;

    @FXML
    private Button editEmployee_cancelBtn;

    private AlertMessage alert = new AlertMessage();

    private Image image;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void importBtn() {

        FileChooser open = new FileChooser();
        open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*jpg", "*png", "*jpeg"));

        File file = open.showOpenDialog(editEmployee_importBtn.getScene().getWindow());

        if (file != null) {

            Data.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 112, 121, false, true);
            editEmployee_imageView.setImage(image);

        }

    }

    public void displayEmployeeData() {

        String sql = "SELECT * FROM employee WHERE employee_id = '"
                + editEmployee_employeeID.getText() + "'";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                editEmployee_fullName.setText(result.getString("full_name"));
                editEmployee_email.setText(result.getString("email"));
                editEmployee_password.setText(result.getString("password"));
                editEmployee_specialized.getSelectionModel().select(result.getString("specialized"));
                editEmployee_gender.getSelectionModel().select(result.getString("gender"));
                editEmployee_mobileNumber.setText(result.getString("mobile_number"));
                editEmployee_address.setText(result.getString("address"));
                editEmployee_status.getSelectionModel().select(result.getString("status"));

                image = new Image("File:" + result.getString("image"), 112, 121, false, true);
                editEmployee_imageView.setImage(image);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBtn() {
        connect = Database.connectDB();

        if (editEmployee_employeeID.getText().isEmpty()
                || editEmployee_fullName.getText().isEmpty()
                || editEmployee_email.getText().isEmpty()
                || editEmployee_password.getText().isEmpty()
                || editEmployee_specialized.getSelectionModel().getSelectedItem() == null
                || editEmployee_gender.getSelectionModel().getSelectedItem() == null
                || editEmployee_mobileNumber.getText().isEmpty()
                || editEmployee_address.getText().isEmpty()
                || editEmployee_status.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            if (Data.path == null || "".equals(Data.path)) {
                String updateData = "UPDATE employee SET full_name = '"
                        + editEmployee_fullName.getText() + "', email = '"
                        + editEmployee_email.getText() + "', password = '"
                        + editEmployee_password.getText() + "', specialized = '"
                        + editEmployee_specialized.getSelectionModel().getSelectedItem() + "', gender = '"
                        + editEmployee_gender.getSelectionModel().getSelectedItem() + "', mobile_number = '"
                        + editEmployee_mobileNumber.getText() + "', address = '"
                        + editEmployee_address.getText() + "', status = '"
                        + editEmployee_status.getSelectionModel().getSelectedItem() + "', modify_date = '"
                        + String.valueOf(sqlDate) + "' "
                        + "WHERE employee_id = '" + editEmployee_employeeID.getText() + "'";
                try {
                    if (alert.confirmationMessage("Are you sure you want to Update Employee ID: " + editEmployee_employeeID.getText() + "?")) {
                        prepare = connect.prepareStatement(updateData);
                        prepare.executeUpdate();
                    } else {
                        alert.errorMessage("Cancelled.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if (alert.confirmationMessage("Are you sure you want to Update Employee ID: "
                            + editEmployee_employeeID.getText() + "?")) {
                        String path = Data.path;
                        path = path.replace("\\", "\\\\");
                        Path transfer = Paths.get(path);

                        Path copy = Paths.get("C:\\Users\\ACER\\Documents\\NetBeansProjects\\stsc_new\\src\\Employee_Directory\\"
                                + editEmployee_employeeID.getText() + ".jpg");

                        Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);

                        String insertImage = copy.toString();
                        insertImage = insertImage.replace("\\", "\\\\");
                        
                        String updateData = "UPDATE employee SET full_name = '"
                                + editEmployee_fullName.getText() + "', email = '"
                                + editEmployee_email.getText() + "', password = '"
                                + editEmployee_password.getText() + "', specialized = '"
                                + editEmployee_specialized.getSelectionModel().getSelectedItem() + "', gender = '"
                                + editEmployee_gender.getSelectionModel().getSelectedItem() + "', mobile_number = '"
                                + editEmployee_mobileNumber.getText() + "', image = '"
                                + insertImage + "', address = '"
                                + editEmployee_address.getText() + "', status = '"
                                + editEmployee_status.getSelectionModel().getSelectedItem() + "' "
                                + "WHERE employee_id = '" + editEmployee_employeeID.getText() + "'";

                        prepare = connect.prepareStatement(updateData);
                        prepare.executeUpdate();

                    } else {
                        alert.errorMessage("Cancelled.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        displayEmployeeData();
    }

    public void cancelBtn() {
        displayEmployeeData();
    }

    public void setField() {
        editEmployee_employeeID.setText(Data.temp_employeeID);
        editEmployee_fullName.setText(Data.temp_employeeName);
        editEmployee_email.setText(Data.temp_employeeEmail);
        editEmployee_password.setText(Data.temp_employeePassword);
        editEmployee_specialized.getSelectionModel().select(Data.temp_employeeSpecialized);
        editEmployee_gender.getSelectionModel().select(Data.temp_employeeGender);
        editEmployee_mobileNumber.setText(Data.temp_employeeMobileNumber);
        editEmployee_address.setText(Data.temp_employeeName);
        editEmployee_status.getSelectionModel().select(Data.temp_employeeStatus);

        image = new Image("File:" + Data.temp_employeeImagePath, 112, 121, false, true);
        editEmployee_imageView.setImage(image);
    }

    public void specializationList() {
        List<String> specializationL = new ArrayList<>();

        for (String data : Data.specialization) {
            specializationL.add(data);
        }

        ObservableList listData = FXCollections.observableList(specializationL);
        editEmployee_specialized.setItems(listData);
    }

    public void genderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : Data.gender) {
            genderL.add(data);
        }

        ObservableList listData = FXCollections.observableList(genderL);
        editEmployee_gender.setItems(listData);
    }

    public void statusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : Data.status) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableList(statusL);
        editEmployee_status.setItems(listData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setField();
        specializationList();
        genderList();
        statusList();
    }

}
