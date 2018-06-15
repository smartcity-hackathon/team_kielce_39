package com.example.kamil.hackatonkielce;

public class PaidOffers {

    String idOfPaidOffer;
    String title;
    String description;

    public PaidOffers(){

    }

    public PaidOffers(String idOfPaidOffer, String title, String description) {
        this.idOfPaidOffer = idOfPaidOffer;
        this.title = title;
        this.description = description;
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
