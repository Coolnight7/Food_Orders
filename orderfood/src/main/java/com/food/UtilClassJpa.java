package com.food;

import jakarta.persistence.*;

public class UtilClassJpa {
    private static EntityManagerFactory emf;
    static{
    try
    {
        emf=Persistence.createEntityManagerFactory("myFoodShop");
    }
    catch(Exception e){e.printStackTrace();}
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void myClose(){
            emf.close();
    }
}

