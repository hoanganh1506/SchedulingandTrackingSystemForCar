/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsc_new;

import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 */
public class CustomersData {
    
    private Integer id;
    private Integer customerID;
    private String password;
    private String fullName;
    private Long mobileNumber;
    private String address;
    private String image;
    private String description;
    private String service;
    private String supplies;
    private String employee;
    private String specialized;
    private String gender;
    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;
    
    public CustomersData(Integer id, Integer customerID, String password, String fullName, Long mobileNumber
            , String gender, String address, String image, String description, String service, String supplies
            , String employee, String specialized, Date date, Date dateModify
            , Date dateDelete, String status){
        this.id = id;
        this.customerID = customerID;
        this.password = password;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.image = image;
        this.description = description;
        this.service = service;
        this.supplies = supplies;
        this.employee = employee;
        this.specialized = specialized;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
    }
    
    public CustomersData(Integer id, Integer customerID, String fullName, String gender,
            Long mobileNumber, String address, String status, Date date
            , Date dateModify, Date dateDelete){
        this.id = id;
        this.customerID = customerID;
        this.fullName = fullName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.status = status;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
    }
    
    public CustomersData(Integer id, Integer customerID, String fullName, String gender
            , String description, String service, String supplies
            , String employee, String image, Date date){
        this.id = id;
        this.customerID = customerID;
        this.fullName = fullName;
        this.gender = gender;
        this.description = description;
        this.service = service;
        this.supplies = supplies;
        this.employee = employee;
        this.image = image;
        this.date = date;
    }
    
    public CustomersData(Integer id, Integer customerID, String description
            , String service, String supplies, Date date){
        this.id = id;
        this.customerID = customerID;
        this.description = description;
        this.service = service;
        this.supplies = supplies;
        this.date = date;
    }
    
    public Integer getId(){
        return id;
    }
    public Integer getCustomerID(){
        return customerID;
    }
    public String getPassword(){
        return password;
    }
    public String getFullName(){
        return fullName;
    }
    public String getGender(){
        return gender;
    }
    public Long getMobileNumber(){
        return mobileNumber;
    }
    public String getAddress(){
        return address;
    }
    public String getImage(){
        return image;
    }
    public String getSupplies(){
        return supplies;
    }
    public String getEmployee(){
        return employee;
    }
    public String getSpecialized(){
        return specialized;
    }
    public Date getDate(){
        return date;
    }
    public Date getDateModify(){
        return dateModify;
    }
    public Date getDateDelete(){
        return dateDelete;
    }
    public String getStatus(){
        return status;
    }
}
