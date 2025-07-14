package com.food;

import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;
import com.food.project.*;

public class myMethods {
    public static Scanner sc=new Scanner(System.in);
     // Methods (` (X) `)
    public static void addCusto()
    {
        EntityManager e=UtilClassJpa.getEntityManager();
        EntityTransaction t=e.getTransaction();

        System.out.println("Enter Customer id , name and phone : ");
        int i=sc.nextInt();
        String n=sc.next();
        String p=sc.next();

        try{
                t.begin();
                e.persist(new Customer(i,n,p));
                t.commit();
                System.out.println("(^ - ^) Customer added !");
                e.close();
        }
        catch(Exception z){
            System.out.println("(T ~ T) Could not add !");
            z.printStackTrace();
        }
    }

    public static void addMenu()
    {
        EntityManager e=UtilClassJpa.getEntityManager();
        EntityTransaction t=e.getTransaction();

        System.out.println("Enter Menu item id , name and price : ");
        int i=sc.nextInt();
        String n=sc.next();
        double p=sc.nextDouble();

        try{
                t.begin();
                e.persist(new Menu(i,n,p));
                t.commit();
                System.out.println("(^ - ^) Menu item added !");
                e.close();
        }
        catch(Exception e2){
            System.out.println("(T ~ T) Could not add !");
            e2.printStackTrace();
        }
    }

    public static void viewCusto(){
        EntityManager e=UtilClassJpa.getEntityManager();
        List<Customer> cl=e.createQuery("From Customer",Customer.class).getResultList();
        System.out.println(" _____= Customers =_____");
        for (Customer cin: cl) {
            System.err.println(cin);
        }
        e.close();
    }

    public static void viewMenu(){
        EntityManager e=UtilClassJpa.getEntityManager();
         List<Menu> ml=e.createQuery("From Menu",Menu.class).getResultList();
        System.out.println(" @_____*= Menu Items =*_____@");
        for (Menu min: ml) {
            System.err.println(min);
        }
        e.close();
    }

    public static void viewOrder(){
        EntityManager e=UtilClassJpa.getEntityManager();
        
        System.out.println("Enter customer id: ");
        int id=sc.nextInt();

        Customer c=e.find(Customer.class,id);
        if(c==null){
            System.out.println(" (X) Customer not found ");
            return;
        } 
        
        List<Orders> myOrd=e.createQuery("FROM Orders o where o.customer.custId= :id",Orders.class).setParameter("id",id).getResultList();
        System.out.println("==== Orders for : "+c.getCname()+" ====");
        for (Orders or : myOrd) {
            System.out.println(or);
        }
        e.close();
    }

    public static void orderNow(){
        EntityManager e=UtilClassJpa.getEntityManager();
        EntityTransaction t=e.getTransaction();

        try{
                List<Customer> cList=e.createQuery("FROM Customer",Customer.class).getResultList();
                List<Menu> mList=e.createQuery("FROM Menu",Menu.class).getResultList();

                if(cList.isEmpty() || mList.isEmpty()){
                    System.out.println(" Add customer and menu : its Empty (. ^ .)"); return;
                }

                System.out.println("==== Available Customers ====");
                for (Customer cin : cList) {
                    System.out.println(cin);
                }

                System.out.println("Enter Customer id: ");
                int id=sc.nextInt();

                Customer c=e.find(Customer.class,id);
                if(c==null)
                {
                    System.out.println("Can't find customer"); return;
                }

                System.out.println("==== Menu Items ====");
                for (Menu min : mList) {
                    System.out.println(min);
                }

                System.out.println("Enter Menu item id and quantity: ");
                int itid=sc.nextInt();
                int qt=sc.nextInt();

                Menu m=e.find(Menu.class,itid);
                if(m==null){
                    System.out.println(" Can't find menu item "); return;
                }

                t.begin();
                Orders o1=new Orders(itid,c, m, qt);
                e.persist(o1);
                t.commit();
                e.close();
        }
        catch(Exception e4){
            e4.printStackTrace();
        }

    }
}

