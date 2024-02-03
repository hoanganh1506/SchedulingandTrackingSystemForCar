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
public class SuppliesData {
    
    private Integer id;
    private String suppliesID;
    private String name;
    private String origin;
    private Integer productionYear;
    private String unit;
    private String price;
    private String quantity;
    private String status;
    
    public SuppliesData(Integer id, String suppliesID, String name, 
            String origin, Integer productionYear, String unit, 
            String price, String quantity, String status){
        this.id = id;
        this.suppliesID = suppliesID;
        this.name = name;
        this.origin = origin;
        this.productionYear = productionYear;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    
    public Integer getId(){
        return id;
    }
    
    public String getSuppliesID(){
        return suppliesID;
    }
    
    public String getName(){
        return name;
    }
    
    public String getOrigin(){
        return origin;
    }
    
    public Integer getProductionYear(){
        return productionYear;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public String getPrice(){
        return price;
    }
    
    public String getQuantity(){
        return quantity;
    }
    
    public String getStatus(){
        return status;
    }
    
}
