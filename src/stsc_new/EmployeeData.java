package stsc_new;

import java.sql.Date;

public class EmployeeData {
    private Integer id;
    private String employeeID;
    private String password;
    private String fullName;
    private String email;
    private String gender;
    private Long mobileNumber;
    private String specialized;
    private String address;
    private String image;
    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;

    public EmployeeData(Integer id, String employeeID, String password, String fullName,
            String email, String gender, Long mobileNumber, String specialized, String address,
            String image, Date date, Date dateModify, Date dateDelete, String status) {
        this.id = id;
        this.employeeID = employeeID;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.specialized = specialized;
        this.address = address;
        this.image = image;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
    }

    public EmployeeData(String employeeID, String fullName, String specialized, String status) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.specialized = specialized;
        this.status = status;
    }

    public EmployeeData(Integer id, String employeeID, String fullName, String specialized, String email, String image) {
        this.id = id;
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.specialized = specialized;
        this.email = email;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public String getSpecialized() {
        return specialized;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public String getStatus() {
        return status;
    }
}
