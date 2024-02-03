package stsc_new;

import stsc_new.Data;
import stsc_new.Database;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS 10
 */
public class AdminMainFormController implements Initializable {

    // GIVE NAME OF ALL COMPONENTS
    @FXML
    private AnchorPane main_form;

    @FXML
    private Circle top_profile;

    @FXML
    private Label top_username;

    @FXML
    private Label date_time;

    @FXML
    private Label current_form;

    @FXML
    private Label nav_adminID;

    @FXML
    private Label nav_username;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button employees_btn;

    @FXML
    private Button customers_btn;

    @FXML
    private Button appointments_btn;

    @FXML
    private Button payment_btn;

    @FXML
    private Button profile_btn;

    @FXML
    private Button services_btn;

    @FXML
    private AnchorPane services_form;

    @FXML
    private TableView<ServicesData> services_tableView;

    @FXML
    private TableColumn<ServicesData, String> services_col_serviceAction;

    @FXML
    private TableColumn<ServicesData, String> services_col_serviceDepict;

    @FXML
    private TableColumn<ServicesData, String> services_col_serviceID;

    @FXML
    private TableColumn<ServicesData, String> services_col_serviceName;

    @FXML
    private TableColumn<ServicesData, String> services_col_servicePrice;

    @FXML
    private TableColumn<ServicesData, String> services_col_serviceStatus;

    @FXML
    private TableColumn<ServicesData, String> services_col_serviceUnit;

    @FXML
    private TableView<SuppliesData> supplies_tableView;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_suppliesID;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_Name;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_Origin;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_PDYear;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_Unit;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_Price;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_Quantity;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_Status;

    @FXML
    private TableColumn<SuppliesData, String> supplies_col_Action;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_AD;

    @FXML
    private Label dashboard_TP;

    @FXML
    private Label dashboard_AP;

    @FXML
    private Label dashboard_tA;

    @FXML
    private AreaChart<?, ?> dashboad_chart_PD;

    @FXML
    private BarChart<?, ?> dashboad_chart_DD;

    @FXML
    private TableView<EmployeeData> dashboad_tableView;

    @FXML
    private TableColumn<EmployeeData, String> dashboad_col_employeeID;

    @FXML
    private TableColumn<EmployeeData, String> dashboad_col_name;

    @FXML
    private TableColumn<EmployeeData, String> dashboad_col_specialized;

    @FXML
    private TableColumn<EmployeeData, String> dashboad_col_status;

    @FXML
    private AnchorPane employees_form;

    @FXML
    private TableView<EmployeeData> employees_tableView;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_employeeID;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_name;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_gender;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_contactNumber;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_email;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_specialization;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_address;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_status;

    @FXML
    private TableColumn<EmployeeData, String> employees_col_action;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private TableView<CustomersData> customers_tableView;

    @FXML
    private TableColumn<CustomersData, String> customers_col_customerID;

    @FXML
    private TableColumn<CustomersData, String> customers_col_name;

    @FXML
    private TableColumn<CustomersData, String> customers_col_gender;

    @FXML
    private TableColumn<CustomersData, String> customers_col_contactNumber;

    @FXML
    private TableColumn<CustomersData, String> customers_col_description;

    @FXML
    private TableColumn<CustomersData, String> customers_col_date;

    @FXML
    private TableColumn<CustomersData, String> customers_col_dateModify;

    @FXML
    private TableColumn<CustomersData, String> customers_col_dateDelete;

    @FXML
    private TableColumn<CustomersData, String> customers_col_status;

    @FXML
    private TableColumn<CustomersData, String> customers_col_action;

    @FXML
    private AnchorPane appointments_form;

    @FXML
    private TableView<AppointmentData> appointments_tableView;

    @FXML
    private TableColumn<AppointmentData, String> appointments_appointmentID;

    @FXML
    private TableColumn<AppointmentData, String> appointments_name;

    @FXML
    private TableColumn<AppointmentData, String> appointments_gender;

    @FXML
    private TableColumn<AppointmentData, String> appointments_contactNumber;

    @FXML
    private TableColumn<AppointmentData, String> appointments_description;

    @FXML
    private TableColumn<AppointmentData, String> appointments_date;

    @FXML
    private TableColumn<AppointmentData, String> appointments_dateModify;

    @FXML
    private TableColumn<AppointmentData, String> appointments_dateDelete;

    @FXML
    private TableColumn<AppointmentData, String> appointments_status;

    @FXML
    private TableColumn<AppointmentData, String> appointments_action;

    @FXML
    private AnchorPane profile_form;

    @FXML
    private AnchorPane supplies_form;

    @FXML
    private Circle profile_circle;

    @FXML
    private Button profile_importBtn;

    @FXML
    private Label profile_label_adminIO;

    @FXML
    private Label profile_label_name;

    @FXML
    private Label profile_label_email;

    @FXML
    private Label profile_label_dateCreated;

    @FXML
    private TextField profile_adminID;

    @FXML
    private TextField profile_username;

    @FXML
    private TextField profile_email;

    @FXML
    private ComboBox<String> profile_status;

    @FXML
    private Button profile_updateBtn;

    @FXML
    private Button supplies_btn;

    @FXML
    private AnchorPane payment_form;

    @FXML
    private TableView<CustomersData> payment_tableView;

    @FXML
    private TableColumn<CustomersData, String> payment_col_customerID;

    @FXML
    private TableColumn<CustomersData, String> payment_col_name;

    @FXML
    private TableColumn<CustomersData, String> payment_col_gender;

    @FXML
    private TableColumn<CustomersData, String> payment_col_service;

    @FXML
    private TableColumn<CustomersData, String> payment_col_employee;

    @FXML
    private TableColumn<CustomersData, String> payment_col_date;

    @FXML
    private Circle payment_circle;

    @FXML
    private Button payment_checkoutBtn;

    @FXML
    private Label payment_customerID;

    @FXML
    private Label payment_name;

    @FXML
    private Label payment_employee;

    @FXML
    private Label payment_date;

    @FXML
    private Button logout_btn;

//    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private AlertMessage alert = new AlertMessage();

    private Image image;

    public void dashboardAD() {

        String sql = "SELECT COUNT(id) FROM employee WHERE status = 'Active' AND delete_date IS NULL";

        connect = Database.connectDB();

        int tempAD = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempAD = result.getInt("COUNT(id)");
            }
            dashboard_AD.setText(String.valueOf(tempAD));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTP() {

        String sql = "SELECT COUNT(id) FROM customer WHERE date_delete IS NULL";

        connect = Database.connectDB();

        int tempTP = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTP = result.getInt("COUNT(id)");
            }
            dashboard_TP.setText(String.valueOf(tempTP));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardAP() {

        String sql = "SELECT COUNT(id) FROM customer WHERE date_delete IS NULL AND status = 'Active'";

        connect = Database.connectDB();

        int tempAP = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempAP = result.getInt("COUNT(id)");
            }
            dashboard_AP.setText(String.valueOf(tempAP));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTA() {

        String sql = "SELECT COUNT(id) FROM appointment WHERE date_delete IS NULL";

        connect = Database.connectDB();

        int tempTA = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTA = result.getInt("COUNT(id)");
            }
            dashboard_tA.setText(String.valueOf(tempTA));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<EmployeeData> dashboardGetEmployeeData() {

        ObservableList<EmployeeData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee WHERE delete_date IS NULL";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            EmployeeData dData;

            while (result.next()) {
//                EmployeeData(String employeeID, String fullName, String specialized, String status)
                dData = new EmployeeData(result.getString("employee_id"),
                        result.getString("full_name"), result.getString("specialized"),
                        result.getString("status"));

                listData.add(dData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<EmployeeData> dashboardGetEmployeeListData;

    public void dashboardGetEmployeeDisplayData() {
        dashboardGetEmployeeListData = dashboardGetEmployeeData();

        dashboad_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        dashboad_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        dashboad_col_specialized.setCellValueFactory(new PropertyValueFactory<>("specialized"));
        dashboad_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        dashboad_tableView.setItems(dashboardGetEmployeeListData);

    }

    public void dashboardCustomerDataChart() {
        dashboad_chart_PD.getData().clear();

        String selectData = "SELECT date, COUNT(id) FROM customer WHERE date_delete IS NULL GROUP BY TIMESTAMP(date) ASC LIMIT 8";

        connect = Database.connectDB();
        XYChart.Series chart = new XYChart.Series<>();

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            dashboad_chart_PD.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardEmployeeDataChart() {
        dashboad_chart_DD.getData().clear();

        String selectData = "SELECT date, COUNT(id) FROM employee WHERE delete_date IS NULL GROUP BY TIMESTAMP(date) ASC LIMIT 6";

        connect = Database.connectDB();
        XYChart.Series chart = new XYChart.Series<>();

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            dashboad_chart_DD.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<EmployeeData> employeeGetData() {
        ObservableList<EmployeeData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employee";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            EmployeeData dData;
            while (result.next()) {
//                EmployeeData(Integer id, String employeeID, String password, String fullName,
//            String email, String gender, Long mobileNumber, String specialized, String address,
//            String image, Date date, Date dateModify, Date dateDelete, String status)
                dData = new EmployeeData(result.getInt("id"), result.getString("employee_id"),
                        result.getString("password"), result.getString("full_name"),
                        result.getString("email"), result.getString("gender"),
                        result.getLong("mobile_number"), result.getString("specialized"),
                        result.getString("address"), result.getString("image"),
                        result.getDate("date"), result.getDate("modify_date"),
                        result.getDate("delete_date"), result.getString("status"));

                listData.add(dData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<EmployeeData> employeeListData;

    public void employeeDisplayData() {
        employeeListData = employeeGetData();

        employees_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employees_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        employees_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        employees_col_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        employees_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employees_col_specialization.setCellValueFactory(new PropertyValueFactory<>("specialized"));
        employees_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        employees_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        employees_tableView.setItems(employeeListData);

    }

    public void employeeActionButton() {

        connect = Database.connectDB();
        employeeListData = employeeGetData();

        Callback<TableColumn<EmployeeData, String>, TableCell<EmployeeData, String>> cellFactory = (TableColumn<EmployeeData, String> param) -> {
            final TableCell<EmployeeData, String> cell = new TableCell<EmployeeData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                EmployeeData pData = employees_tableView.getSelectionModel().getSelectedItem();
                                int num = employees_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_employeeID = pData.getEmployeeID();
                                Data.temp_employeeName = pData.getFullName();
                                Data.temp_employeeEmail = pData.getEmail();
                                Data.temp_employeePassword = pData.getPassword();
                                Data.temp_employeeSpecialized = pData.getSpecialized();
                                Data.temp_employeeGender = pData.getGender();
                                Data.temp_employeeMobileNumber = String.valueOf(pData.getMobileNumber());
                                Data.temp_employeeAddress = pData.getAddress();
                                Data.temp_employeeStatus = pData.getStatus();
                                Data.temp_employeeImagePath = pData.getImage();

                                Parent root = FXMLLoader.load(getClass().getResource("EditEmployeeForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            EmployeeData pData = employees_tableView.getSelectionModel().getSelectedItem();
                            int num = employees_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE employee SET delete_date = ? WHERE employee_id = '"
                                    + pData.getEmployeeID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Employee ID: " + pData.getEmployeeID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                                    prepare.setString(1, String.valueOf(sqlDate));
                                    prepare.executeUpdate();

                                    employeeGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            employeeDisplayData();
            return cell;
        };

        employees_col_action.setCellFactory(cellFactory);
        employees_tableView.setItems(employeeListData);

    }

    public ObservableList<CustomersData> customerGetData() {

        ObservableList<CustomersData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            CustomersData pData;

            while (result.next()) {

                pData = new CustomersData(result.getInt("id"), result.getInt("customer_id"),
                        result.getString("password"), result.getString("full_name"),
                        result.getLong("mobile_number"), result.getString("gender"),
                        result.getString("address"),
                        result.getString("image"), result.getString("description"),
                        result.getString("service"),
                        result.getString("supplies"), result.getString("employee"),
                        result.getString("specialized"), result.getDate("date"),
                        result.getDate("date_modify"), result.getDate("date_delete"),
                        result.getString("status"));

                listData.add(pData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<CustomersData> customerListData;

    public void customerDisplayData() {
        customerListData = customerGetData();

        customers_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customers_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        customers_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        customers_col_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        customers_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        customers_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_dateModify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
        customers_col_dateDelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
        customers_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        customers_tableView.setItems(customerListData);
    }

    public void customerActionButton() {

        connect = Database.connectDB();
        customerListData = customerGetData();

        Callback<TableColumn<CustomersData, String>, TableCell<CustomersData, String>> cellFactory = (TableColumn<CustomersData, String> param) -> {
            final TableCell<CustomersData, String> cell = new TableCell<CustomersData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                CustomersData pData = customers_tableView.getSelectionModel().getSelectedItem();
                                int num = customers_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_CustomerID = pData.getCustomerID();
                                Data.temp_address = pData.getAddress();
                                Data.temp_name = pData.getFullName();
                                Data.temp_gender = pData.getGender();
                                Data.temp_number = pData.getMobileNumber();
                                Data.temp_status = pData.getStatus();

                                // NOW LETS CREATE FXML FOR EDIT CUSTOMER FORM
                                Parent root = FXMLLoader.load(getClass().getResource("EditCustomerForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            CustomersData pData = customers_tableView.getSelectionModel().getSelectedItem();
                            int num = customers_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE customer SET date_delete = ? WHERE customer_id = '"
                                    + pData.getCustomerID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Customer ID: " + pData.getCustomerID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                                    prepare.setString(1, String.valueOf(sqlDate));
                                    prepare.executeUpdate();

                                    employeeGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            employeeDisplayData();
            return cell;
        };

        customers_col_action.setCellFactory(cellFactory);
        customers_tableView.setItems(customerListData);

    }

    public ObservableList<AppointmentData> appointmentGetData() {

        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM appointment";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            AppointmentData aData;
            while (result.next()) {

                aData = new AppointmentData(result.getInt("id"), result.getInt("appointment_id"),
                        result.getString("name"), result.getString("gender"), result.getLong("mobile_number"),
                        result.getString("description"), result.getString("service"),
                        result.getString("supplies"), result.getString("address"),
                        result.getString("employee"), result.getString("specialized"),
                        result.getDate("date"), result.getDate("date_modify"),
                        result.getDate("date_delete"), result.getString("status"),
                        result.getDate("schedule"));
                listData.add(aData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<AppointmentData> appointmentListData;

    public void appointmentDisplayData() {
        appointmentListData = appointmentGetData();

        appointments_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointments_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        appointments_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        appointments_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        appointments_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointments_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        appointments_dateModify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
        appointments_dateDelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
        appointments_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        appointments_tableView.setItems(appointmentListData);

    }

    public void appointmentActionButton() {

        connect = Database.connectDB();
        appointmentListData = appointmentGetData();

        Callback<TableColumn<AppointmentData, String>, TableCell<AppointmentData, String>> cellFactory = (TableColumn<AppointmentData, String> param) -> {
            final TableCell<AppointmentData, String> cell = new TableCell<AppointmentData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                AppointmentData aData = appointments_tableView.getSelectionModel().getSelectedItem();
                                int num = appointments_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_appID = String.valueOf(aData.getAppointmentID());
                                Data.temp_appName = aData.getName();
                                Data.temp_appGender = aData.getGender();
                                Data.temp_appAddress = aData.getAddress();
                                Data.temp_appDescription = aData.getDescription();
                                Data.temp_appService = aData.getService();
                                Data.temp_appSupplies = aData.getSupplies();
                                Data.temp_appMobileNumber = String.valueOf(aData.getMobileNumber());
                                Data.temp_appEmployee = aData.getEmployeeID();
                                Data.temp_appSpecialized = aData.getSpecialized();
                                Data.temp_appStatus = aData.getStatus();

                                // NOW LETS CREATE FXML FOR EDIT APPOINTMENT FORM
                                Parent root = FXMLLoader.load(getClass().getResource("EditAppointmentForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            AppointmentData aData = appointments_tableView.getSelectionModel().getSelectedItem();
                            int num = appointments_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE appointment SET date_delete = ? WHERE appointment_id = '"
                                    + aData.getAppointmentID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Appointment ID: " + aData.getAppointmentID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                                    prepare.setString(1, String.valueOf(sqlDate));
                                    prepare.executeUpdate();

                                    employeeGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            employeeDisplayData();
            return cell;
        };

        appointments_action.setCellFactory(cellFactory);
        appointments_tableView.setItems(appointmentListData);

    }

    public ObservableList<CustomersData> paymentGetData() {

        ObservableList<CustomersData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer WHERE date_delete IS NULL AND status_pay IS NULL";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            CustomersData pData;
            while (result.next()) {

                pData = new CustomersData(result.getInt("id"),
                        result.getInt("customer_id"), result.getString("full_name"),
                        result.getString("gender"), result.getString("description"),
                        result.getString("service"), result.getString("supplies"),
                        result.getString("employee"), result.getString("image"), result.getDate("date"));

                listData.add(pData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<CustomersData> paymentListData;

    public void paymentDisplayData() {
        paymentListData = paymentGetData();

        payment_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        payment_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        payment_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        payment_col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
        payment_col_employee.setCellValueFactory(new PropertyValueFactory<>("employee"));
        payment_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        payment_tableView.setItems(paymentListData);

    }

    public void paymentSelectItems() {

        CustomersData pData = payment_tableView.getSelectionModel().getSelectedItem();
        int num = payment_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        if (pData.getImage() != null) {
            String path = "File:" + pData.getImage();
            image = new Image(path, 144, 105, false, true);
            payment_circle.setFill(new ImagePattern(image));

            Data.temp_path = pData.getImage();
        }

        Data.temp_CustomerID = pData.getCustomerID();
        Data.temp_name = pData.getFullName();
        Data.temp_date = String.valueOf(pData.getDate());

        payment_customerID.setText(String.valueOf(pData.getCustomerID()));
        payment_name.setText(pData.getFullName());
        payment_employee.setText(pData.getEmployee());
        payment_date.setText(String.valueOf(pData.getDate()));

    }

    public void paymentCheckOutBtn() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("CheckOutCustomer.fxml"));
            Stage stage = new Stage();

            stage.setTitle("Scheduling and Tracking System | Check-Out");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void profileUpdateBtn() {
        connect = Database.connectDB();
        if (profile_adminID.getText().isEmpty()
                || profile_username.getText().isEmpty()
                || profile_email.getText().isEmpty()
                || profile_status.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (Data.path == null || "".equals(Data.path)) {
                String updateData = "UPDATE admin SET username = ?, email = ?, gender = ? "
                        + "WHERE admin_id = " + Data.admin_id;

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, profile_username.getText());
                    prepare.setString(2, profile_email.getText());
                    prepare.setString(3, profile_status.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();

                    profileDisplayInfo();

                    alert.successMessage("Updated Successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                String updateData = "UPDATE admin SET username = ?, email = ?, image = ?, gender = ? "
                        + "WHERE admin_id = " + Data.admin_id;
                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, profile_username.getText());
                    prepare.setString(2, profile_email.getText());

                    String path = Data.path;
                    path = path.replace("\\", "\\\\");
                    Path transfer = Paths.get(path);

                    Path copy = Paths.get("C:\\Users\\ACER\\Documents\\NetBeansProjects\\stsc_new\\src\\Admin_Directory\\"
                            + Data.admin_id + ".jpg");

                    Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);
                    prepare.setString(3, copy.toAbsolutePath().toString());
                    prepare.setString(4, profile_status.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();
                    profileDisplayInfo();
                    profileDisplayImages();
                    alert.successMessage("Updated Successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void profileDisplayImages() {

        String selectData = "SELECT * FROM admin WHERE admin_id = " + Data.admin_id;
        connect = Database.connectDB();

        String tempPath1 = "";
        String tempPath2 = "";
        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            if (result.next()) {
                tempPath1 = "File:" + result.getString("image");
                tempPath2 = "File:" + result.getString("image");

                if (result.getString("image") != null) {
                    image = new Image(tempPath1, 1012, 22, false, true);
                    top_profile.setFill(new ImagePattern(image));

                    image = new Image(tempPath2, 137, 95, false, true);
                    profile_circle.setFill(new ImagePattern(image));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void profileInsertImage() {

        FileChooser open = new FileChooser();
        open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*jpg", "*jpeg", "*png"));

        File file = open.showOpenDialog(profile_importBtn.getScene().getWindow());

        if (file != null) {
            Data.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 137, 95, false, true);
            profile_circle.setFill(new ImagePattern(image));
        }

    }

    public void profileDisplayInfo() {

        String sql = "SELECT * FROM admin WHERE admin_id = " + Data.admin_id;
        System.out.println(Data.admin_id);
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                profile_adminID.setText(result.getString("admin_id"));
                profile_username.setText(result.getString("username"));
                profile_email.setText(result.getString("email"));
                profile_status.getSelectionModel().select(result.getString("gender"));

                profile_label_adminIO.setText(result.getString("admin_id"));
                profile_label_name.setText(result.getString("username"));
                profile_label_email.setText(result.getString("email"));
                profile_label_dateCreated.setText(result.getString("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void profileStatusList() {
        List<String> listS = new ArrayList<>();

        for (String data : Data.gender) {
            listS.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        profile_status.setItems(listData);
    }

    /* Them chuc nang */
    public ObservableList<SuppliesData> suppliesGetData() {
        ObservableList<SuppliesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM supplies";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            SuppliesData sData;
            while (result.next()) {
                sData = new SuppliesData(
                        result.getInt("id"), result.getString("suppliesID"),
                        result.getString("name"), result.getString("origin"),
                        result.getInt("productionYear"), result.getString("unit"),
                        result.getString("price"), result.getString("quantity"),
                        result.getString("status"));

                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
        return listData;
    }

    private ObservableList<SuppliesData> suppliesListData;

    public void suppliesDisplayData() {
        suppliesListData = suppliesGetData();

        supplies_col_suppliesID.setCellValueFactory(new PropertyValueFactory<>("suppliesID"));
        supplies_col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplies_col_Origin.setCellValueFactory(new PropertyValueFactory<>("origin"));
        supplies_col_PDYear.setCellValueFactory(new PropertyValueFactory<>("productionYear"));
        supplies_col_Unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        supplies_col_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        supplies_col_Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        supplies_col_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        supplies_tableView.setItems(suppliesListData);

    }

    public void suppliesActionButton() {

        connect = Database.connectDB();
        suppliesListData = suppliesGetData();

        Callback<TableColumn<SuppliesData, String>, TableCell<SuppliesData, String>> cellFactory = (TableColumn<SuppliesData, String> param) -> {
            final TableCell<SuppliesData, String> cell = new TableCell<SuppliesData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                SuppliesData sData = supplies_tableView.getSelectionModel().getSelectedItem();
                                int num = supplies_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_suppliesID = sData.getSuppliesID();
                                Data.temp_suppliesName = sData.getName();
                                Data.temp_suppliesOrigin = sData.getOrigin();
                                Data.temp_suppliesProductionYear = String.valueOf(sData.getProductionYear());
                                Data.temp_suppliesUnit = sData.getUnit();
                                Data.temp_suppliesPrice = sData.getPrice();
                                Data.temp_suppliesQuantity = sData.getQuantity();
                                Data.temp_suppliesStatus = sData.getStatus();

                                Parent root = FXMLLoader.load(getClass().getResource("EditSuppliesForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                             
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            SuppliesData pData = supplies_tableView.getSelectionModel().getSelectedItem();
                            int num = supplies_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE supplies SET status = 'Inactive' WHERE suppliesID = '"
                                    + pData.getSuppliesID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Supplies ID: " + pData.getSuppliesID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    prepare.executeUpdate();

                                    suppliesGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            suppliesDisplayData();
            return cell;
        };

        supplies_col_Action.setCellFactory(cellFactory);
        supplies_tableView.setItems(suppliesListData);

    }

    @FXML
    void suppliesInsertBtn(ActionEvent event) {

        try {
            if (alert.confirmationMessage("Are you sure you want to insert new supplie?")) {
                Parent root = FXMLLoader.load(getClass().getResource("InsertSuppliesForm.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }

    }

    @FXML
    void servicesInsertBtn(ActionEvent event) {
        try {
            if (alert.confirmationMessage("Are you sure you want to new service?")) {
                Parent root = FXMLLoader.load(getClass().getResource("InsertServicesForm.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }

    }

    public ObservableList<ServicesData> servicesGetData() {
        ObservableList<ServicesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM services";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ServicesData sData;
            while (result.next()) {
                sData = new ServicesData(
                        result.getInt("id"), result.getString("serviceID"),
                        result.getString("name"), result.getString("unit"),
                        result.getInt("price"), result.getString("depict"),
                        result.getString("status"));

                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
        return listData;
    }

    private ObservableList<ServicesData> servicesListData;

    public void servicesDisplayData() {
        servicesListData = servicesGetData();

        services_col_serviceID.setCellValueFactory(new PropertyValueFactory<>("serviceID"));
        services_col_serviceName.setCellValueFactory(new PropertyValueFactory<>("name"));
        services_col_serviceUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        services_col_servicePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        services_col_serviceDepict.setCellValueFactory(new PropertyValueFactory<>("depict"));
        services_col_serviceStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        services_tableView.setItems(servicesListData);

    }

    public void servicesActionButton() {

        connect = Database.connectDB();
        servicesListData = servicesGetData();

        Callback<TableColumn<ServicesData, String>, TableCell<ServicesData, String>> cellFactory = (TableColumn<ServicesData, String> param) -> {
            final TableCell<ServicesData, String> cell = new TableCell<ServicesData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                ServicesData sData = services_tableView.getSelectionModel().getSelectedItem();
                                int num = services_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_serviceID = sData.getServiceID();
                                Data.temp_serviceName = sData.getName();
                                Data.temp_serviceUnit = sData.getUnit();
                                Data.temp_servicePrice = String.valueOf(sData.getPrice());
                                Data.temp_serviceDepict = sData.getDepict();
                                Data.temp_serviceStatus = sData.getStatus();

                                Parent root = FXMLLoader.load(getClass().getResource("EditServicesForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            ServicesData pData = services_tableView.getSelectionModel().getSelectedItem();
                            int num = services_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE services SET status = 'Inactive' WHERE serviceID = '"
                                    + pData.getServiceID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Service ID: " + pData.getServiceID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    prepare.executeUpdate();

                                    servicesGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            servicesDisplayData();
            return cell;
        };

        services_col_serviceAction.setCellFactory(cellFactory);
        services_tableView.setItems(servicesListData);

    }

    // MAKE SURE THAT THE ID OF EVERY COMPONENTS TO THE OTHER IS DIFFERENT
    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            employees_form.setVisible(false);
            customers_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            supplies_form.setVisible(false);
            services_form.setVisible(false);

            dashboardAD();
            dashboardTP();
            dashboardAP();
            dashboardTA();
            dashboardGetEmployeeDisplayData();

            current_form.setText("Dashboard Form");
        } else if (event.getSource() == employees_btn) {
            dashboard_form.setVisible(false);
            employees_form.setVisible(true);
            customers_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            supplies_form.setVisible(false);
            services_form.setVisible(false);

            // TO DISPLAY IMMEDIATELY THE DATA OF EMPLOYEES IN TABLEVIEW
            employeeDisplayData();
            employeeActionButton();

            current_form.setText("Employee's Form");
        } else if (event.getSource() == customers_btn) {
            dashboard_form.setVisible(false);
            employees_form.setVisible(false);
            customers_form.setVisible(true);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            supplies_form.setVisible(false);
            services_form.setVisible(false);

            // TO DISPLAY IMMEDIATELY THE DATA OF CUSTOMERS IN TABLEVIEW
            customerDisplayData();
            customerActionButton();
            current_form.setText("Customer's Form");
        } else if (event.getSource() == appointments_btn) {
            dashboard_form.setVisible(false);
            employees_form.setVisible(false);
            customers_form.setVisible(false);
            appointments_form.setVisible(true);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            supplies_form.setVisible(false);
            services_form.setVisible(false);

            // TO DISPLAY IMMEDIATELY THE DATA OF APPOINTMENTS IN TABLEVIEW
            appointmentDisplayData();

            current_form.setText("Appointment's Form");
        } else if (event.getSource() == payment_btn) {
            dashboard_form.setVisible(false);
            employees_form.setVisible(false);
            customers_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(true);
            profile_form.setVisible(false);
            supplies_form.setVisible(false);
            services_form.setVisible(false);

            paymentDisplayData();

            current_form.setText("Payment Form");
        } else if (event.getSource() == profile_btn) {
            dashboard_form.setVisible(false);
            employees_form.setVisible(false);
            customers_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(true);
            supplies_form.setVisible(false);
            services_form.setVisible(false);

            profileStatusList();
            profileDisplayInfo();
            profileDisplayImages();

            current_form.setText("Profile Form");
        } else if (event.getSource() == supplies_btn) {

            dashboard_form.setVisible(false);
            employees_form.setVisible(false);
            customers_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            supplies_form.setVisible(true);
            services_form.setVisible(false);

            suppliesDisplayData();
            suppliesActionButton();
            current_form.setText("Car Supplies Form");
        } else if (event.getSource() == services_btn) {

            dashboard_form.setVisible(false);
            employees_form.setVisible(false);
            customers_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            supplies_form.setVisible(false);
            services_form.setVisible(true);

            servicesDisplayData();
            servicesActionButton();
            current_form.setText("Car Services Form");
        }

    }

    public void displayAdminIDUsername() {

        String sql = "SELECT * FROM admin WHERE username = '"
                + Data.admin_username + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                nav_adminID.setText(result.getString("admin_id"));
                String tempUsername = result.getString("username");
                tempUsername = tempUsername.substring(0, 1).toUpperCase() + tempUsername.substring(1); // TO SET THE FIRST LETTER TO UPPER CASE
                nav_username.setText(tempUsername);
                top_username.setText(tempUsername);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logoutBtn() {

        try {
            if (alert.confirmationMessage("Are you sure you want to logout?")) {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();

                // TO HIDE MAIN FORM
                logout_btn.getScene().getWindow().hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void runTime() {

        new Thread() {

            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                while (true) {
                    try {

                        Thread.sleep(1000); // 1000 ms = 1s

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        date_time.setText(format.format(new Date()));
                    });
                }
            }
        }.start();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runTime();
        displayAdminIDUsername();

//        DASHBOARD
        dashboardAD();
        dashboardTP();
        dashboardAP();
        dashboardTA();
        dashboardGetEmployeeDisplayData();
        dashboardCustomerDataChart();
        dashboardEmployeeDataChart();

        // TO DISPLAY IMMEDIATELY THE DATA OF DOCTORS IN TABLEVIEW
        employeeDisplayData();
        employeeActionButton();

        // TO DISPLAY IMMEDIATELY THE DATA OF PATIENTS IN TABLEVIEW
        customerDisplayData();
        customerActionButton();

        // TO DISPLAY IMMEDIATELY THE DATA OF APPOINTMENTS IN TABLEVIEW
        appointmentDisplayData();
        appointmentActionButton();

        // TO DISPLAY IMMEDIATELY THE DATA OF PAYMENT IN TABLEVIEW
        paymentDisplayData();

        profileStatusList();
        profileDisplayInfo();
        profileDisplayImages();
        
        suppliesDisplayData();
        suppliesActionButton();

        servicesDisplayData();
        servicesActionButton();
    }

}
