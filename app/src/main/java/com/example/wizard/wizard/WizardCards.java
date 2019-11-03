package com.example.wizard.wizard;

public class WizardCards extends WizardGameState{
    private String cardSuit;
    private int cardNumber;
    private int cardValue;

    public WizardCards(String mySuit, int myNumber){
        this.cardSuit = mySuit;
        this.cardNumber = myNumber;

        if(mySuit == super.getTrumpCard()){
            this.cardValue = this.cardNumber * 10;
        }
        else{
            this.cardValue = this.cardNumber;
        }
    }

    public int getCardValue(){
        return this.cardValue;
    }




}
