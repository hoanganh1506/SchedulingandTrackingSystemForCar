/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsc_new;

/**
 *
 * @author ACER
 */
public class ServicesData {
    
    private Integer id;
    private String serviceID;
    private String name;
    private String unit;
    private Integer price;
    private String depict;
    private String status;
    
    public ServicesData(Integer id, String serviceID, String name,
            String unit, Integer price, String depict, String status){
        
        this.id = id;
        this.serviceID = serviceID;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.depict = depict;
        this.status = status;        
    }
    
    public Integer getID(){
        return id;
    }
    
    public String getServiceID(){
        return serviceID;
    }
    
    public String getName(){
        return name;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public Integer getPrice(){
        return price;
    }
    
    public String getDepict(){
        return depict;
    }
    
    public String getStatus(){
        return status;
    }
    
}
