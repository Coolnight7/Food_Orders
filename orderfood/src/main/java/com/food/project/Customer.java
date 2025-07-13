package com.food.project;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name= "myCustomers")
public class Customer {
    
    @Id
    private int custId;

    private String cname;

    private String cphone;

    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
    private List<Orders> order;

    public Customer(){}
    public Customer(int i,String n,String p)
    {
        this.custId=i;
        this.cname=n;
        this.cphone=p;
    }

    // My getters and setters
    public int getCustId() {
        return custId;
    }
    public void setCustId(int custId) {
        this.custId = custId;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getCphone() {
        return cphone;
    }
    public void setCphone(String cphone) {
        this.cphone = cphone;
    }
    public List<Orders> getOrders() {
        return order;
    }
    public void setOrders(List<Orders> orders) {
        this.order = orders;
    }

    @Override
    public String toString(){
        return custId+" = "+cname+" ph.no: "+cphone;
    }


}
