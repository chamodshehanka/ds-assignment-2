package com.fantastic4.server.business;

public class BOFactory {
    public enum BOTypes{
        CUSTOMER, VEHICLE, BRANCH, DRIVER, RECEPTION, ADMIN, RESERVATION, PAYMENT
    }

    private BOFactory() {
    }

    private static BOFactory boFactory;

    public static BOFactory getInstance(){
        if (boFactory == null)
            boFactory = new BOFactory();
        return boFactory;
    }

    public SuperBO getBOFactory(BOTypes boTypes){
        switch (boTypes){

            default:return null;
        }
    }
}
