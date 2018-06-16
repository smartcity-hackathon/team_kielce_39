package com.example.kamil.hackatonkielce;

public class PaidOffers {

    String idOfPaidOffer;
    String title;
    String sallary;
    String description;
    String addPhoneNumber;


    public PaidOffers(){

    }

    public PaidOffers(String idOfPaidOffer, String title, String sallary, String description, String addPhoneNumber) {
        this.sallary = sallary;
        this.idOfPaidOffer = idOfPaidOffer;
        this.title = title;
        this.description = description; //czyli tekst
        this.addPhoneNumber = addPhoneNumber;
    }
    public PaidOffers(String idOfPaidOffer, String title, String description, String addPhoneNumber) {
        this.idOfPaidOffer = idOfPaidOffer;
        this.title = title;
        this.description = description; //czyli tekst
        this.addPhoneNumber = addPhoneNumber;
    }

    public String getidOfPaidOffer() {
        return idOfPaidOffer;
    }

    public String gettitle() {
        return title;
    }

    public String getdescription() {
        return description;
    }
}
