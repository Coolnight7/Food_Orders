package com.food;

import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;
import com.food.project.*;

public class MainMenu 
{
    public static EntityManagerFactory e1=Persistence.createEntityManagerFactory("myFoodShop");
    public static Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
    try{
        int ch;
        while(true){
            System.out.println("====== Food Ordering System ======");
            System.out.println("1. add customer");
            System.out.println("2. add menu item");
            System.out.println("3. place order");
            System.out.println("4. view customers");
            System.out.println("5. view menu");
            System.out.println("6. view my order");
            System.out.println("7. exit");
            System.out.println("=== Enter your choice === ->");
            ch=sc.nextInt();
             
            switch (ch) {
                case 1:
                    addCusto();  break;
                case 2: 
                    addMenu(); break;
                case 3:
                    orderNow(); break;
                case 4:
                    viewCusto(); break;
                case 5:
                    viewMenu(); break;
                case 6:
                    viewOrder(); break;
                case 7:
                    System.out.println("===== Thank you ! Visit again ! =====");
                    System.exit(0);
                default:
                    System.out.println("(` X `) Invalid input please try again ");
                    break;
            }
        }
    }
    catch(Exception e){e.printStackTrace();}
    
}//main closing para

    // Methods (` (X) `)
    public static void addCusto()
    {
        EntityManager e=e1.createEntityManager();
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
        EntityManager e=e1.createEntityManager();
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
        EntityManager e=e1.createEntityManager();
        List<Customer> cl=e.createQuery("From Customer",Customer.class).getResultList();
        System.out.println(" _____= Customers =_____");
        for (Customer cin: cl) {
            System.err.println(cin);
        }
        e.close();
    }

    public static void viewMenu(){
        EntityManager e=e1.createEntityManager();
         List<Menu> ml=e.createQuery("From Menu",Menu.class).getResultList();
        System.out.println(" @_____*= Menu Items =*_____@");
        for (Menu min: ml) {
            System.err.println(min);
        }
        e.close();
    }

    public static void viewOrder(){
        EntityManager e=e1.createEntityManager();
        
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
        EntityManager e=e1.createEntityManager();
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
