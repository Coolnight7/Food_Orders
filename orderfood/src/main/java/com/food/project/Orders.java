package com.food.project;

import jakarta.persistence.*;

@Entity
@Table(name="myOrders")
public class Orders {
    
    @Id
    private int orderId;

    @ManyToOne
    @JoinColumn(name="cust_id",nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="meItId",nullable=false)
    private Menu menuItem;
    private int quantity;

    public Orders(){}

    public Orders(int i,Customer c,Menu m,int q){
        this.orderId=i;
        this.customer=c;
        this.menuItem=m;
        this.quantity=q;
    }

      //My getters and setters (0 - 0)

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Menu getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Menu menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal(){
        return quantity*menuItem.getiPrice();
    }

    public String toString(){
        return "Order: "+orderId+"\nCustomer: "+customer.getCname()+"\nItem: "+menuItem.getiName()+"\nQty: "+quantity+"\nTotal Pri: "+getTotal();
    }


}
