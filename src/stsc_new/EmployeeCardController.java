package stsc_new;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class EmployeeCardController implements Initializable {
    
    @FXML
    private Circle employee_circle;

    @FXML
    private Label employee_id;

    @FXML
    private Label employee_fullName;

    @FXML
    private Label employee_specialization;

    @FXML
    private Label employee_email;

    private Image image;
    
    public void setData(EmployeeData dData) {

        if (dData.getImage() != null) {
            image = new Image("File:" + dData.getImage(), 52, 52, false, true);
            employee_circle.setFill(new ImagePattern(image));
        }

        employee_id.setText(dData.getEmployeeID());
        employee_fullName.setText(dData.getFullName());
        employee_specialization.setText(dData.getSpecialized());
        employee_email.setText(dData.getEmail());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}
