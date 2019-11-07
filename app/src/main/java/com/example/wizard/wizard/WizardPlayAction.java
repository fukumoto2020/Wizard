package com.example.wizard.wizard;

import com.example.wizard.GameFramework.actionMessage.GameAction;

public class WizardPlayAction extends GameAction {
    protected WizardCards cardToPlay;

    public WizardPlayAction(WizardPlayer player, WizardCards myCard){
        super(player);
        this.cardToPlay = myCard;
    }

    public WizardCards getCardToPlay() {
        return cardToPlay;
    }
}
