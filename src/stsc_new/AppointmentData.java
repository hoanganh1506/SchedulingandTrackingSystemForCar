/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsc_new;

import java.sql.Date;

public class AppointmentData {

    private Integer id;
    private Integer appointmentID;
    private Integer customerID;
    private String name;
    private String gender;
    private String description;
    private String service;
    private String supplies;
    private Long mobileNumber;
    private String address;
    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;
    private String employeeID;
    private String specialized;
    private Date schedule;

    public AppointmentData(Integer id, Integer appointmentID, String name, String gender,
            Long mobileNumber, String description, String service, String supplies, String address,
            String employeeID, String specialized,
            Date date, Date dateModify, Date dateDelete, String status, Date schedule) {
        this.id = id;
        this.appointmentID = appointmentID;
        this.name = name;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.description = description;
        this.service = service;
        this.supplies = supplies;
        this.address = address;
        this.employeeID = employeeID;
        this.specialized = specialized;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
        this.schedule = schedule;

    }

    public AppointmentData(Integer appointmentID, String name, String gender,
            Long mobileNumber, String description, String service, String supplies, String address,
            Date date, Date dateModify, Date dateDelete, String status, Date schedule) {

        this.appointmentID = appointmentID;
        this.name = name;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.description = description;
        this.service = service;
        this.supplies = supplies;
        this.address = address;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
        this.schedule = schedule;

    }

    public AppointmentData(Integer appointmentID, String name,
            String description, Date date, String status) {
        this.appointmentID = appointmentID;
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }
    
    public AppointmentData(Integer id, Integer appointmentID, String description,
            String service, String supplies, Date date, Date schedule) {
        this.id = id;
        this.appointmentID = appointmentID;
        this.description = description;
        this.service = service;
        this.supplies = supplies;
        this.date = date;
        this.schedule = schedule;
    }

    public AppointmentData(Integer appointmentID, String description,
            String service, String supplies, String employeeID, Date schedule) {
        this.appointmentID = appointmentID;
        this.description = description;
        this.service = service;
        this.supplies = supplies;
        this.employeeID = employeeID;
        this.schedule = schedule;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getService() {
        return service;
    }

    public String getSupplies() {
        return supplies;
    }

    public String getAddress() {
        return address;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getSpecialized() {
        return specialized;
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

    public Date getSchedule() {
        return schedule;
    }

}
