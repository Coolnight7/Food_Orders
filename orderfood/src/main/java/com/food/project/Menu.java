package com.food.project;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name= "myMenu")
public class Menu {

    @Id
    private int itemId;

    private String iName;

    private double iPrice;

    @OneToMany(mappedBy="menuItem",cascade=CascadeType.ALL)
    private List<Orders> order;

    public Menu(){}

    public Menu(int i,String n,double p){
        this.itemId=i;
        this.iName=n;
        this.iPrice=p;
    }

    //My getters and setters(0-0)

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public double getiPrice() {
        return iPrice;
    }

    public void setiPrice(double iPrice) {
        this.iPrice = iPrice;
    }

    public List<Orders> getOrder() {
        return order;
    }

    public void setOrder(List<Orders> order) {
        this.order = order;
    }

    @Override
    public String toString(){
        return itemId+" = "+iName+" Rs: "+iPrice;
    }
}
