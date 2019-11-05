package com.example.wizard.wizard;

import java.util.ArrayList;

public class WizardPlayer extends WizardGameState {
    private int playerID;
    private int playerScore;
    private String playerName;
    private int bidNum;
    private ArrayList<WizardCards> currentHand = new ArrayList<WizardCards>();

    public WizardPlayer(int playerID, String playerName){
        this.playerID = playerID;
        this.playerName = playerName;
        playerScore = 0;
        bidNum = 0;
    }

    public void addCardtoHand(WizardCards cardToAdd){
            currentHand.add(cardToAdd);
    }

    public WizardCards playCard(WizardCards cardToPlay){
        if (currentHand.isEmpty()){
            return null;
        }
        else if (currentHand.contains(cardToPlay)){
            currentHand.remove(cardToPlay);
            return cardToPlay;
        }
        else {
            return null;
        }
    }

    public void setCurrentBid(int bid){
        bidNum = bid;
    }

    public void setPlayerScore(int score){
        playerScore = score;
    }

}
