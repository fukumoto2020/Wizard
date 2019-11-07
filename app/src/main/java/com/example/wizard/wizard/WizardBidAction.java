package com.example.wizard.wizard;

import com.example.wizard.GameFramework.actionMessage.GameAction;

public class WizardBidAction extends GameAction {
    protected int bidNum;

    public WizardBidAction(WizardPlayer player, int myBid){
        super(player);
        this.bidNum = myBid;
    }

    public int getBidNum(){return bidNum;}
}
