package com.example.wizard.wizard;

import com.example.wizard.GameFramework.GamePlayer;

import java.util.ArrayList;

public class WizardPlayer extends WizardGameState, GamePlayer {
    private int playerID;
    private int player1Score;
    private int player2Score;
    private int player3Score;
    private int player4Score;
    private int runningTotal;
    private String playerName;
    private int bidNum;
    private ArrayList<WizardCards> currentHand = new ArrayList<WizardCards>();

    public WizardPlayer(int playerID, String playerName){
        this.playerID = playerID;
        this.playerName = playerName;
        this.player1Score = 0;
        this.player2Score = 0;
        this.player3Score = 0;
        this.player4Score = 0;
        runningTotal = 0;
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

    public void setRunningTotal(int bidNum, int bidWon){
        if(bidNum==bidWon){
            this.runningTotal = 20 + (bidWon * 10);
        }
        else{
            this.runningTotal = java.lang.Math.abs(bidNum - bidWon) * (-10);
        }
    }

    public void setPlayer1Score(int runningTotal) { this.player1Score = player1Score + getRunningTotal(); }

    public void setPlayer2Score(int runningTotal) { this.player2Score = player2Score + getRunningTotal(); }

    public void setPlayer3Score(int runningTotal) { this.player3Score = player3Score + getRunningTotal(); }

    public void setPlayer4Score(int runningTotal) { this.player4Score = player4Score + getRunningTotal(); }

    public int getBidNum() { return bidNum; }

    public int getRunningTotal() { return runningTotal; }

    public int getPlayer1Score() { return player1Score; }

    public int getPlayer2Score() { return player2Score; }

    public int getPlayer3Score() { return player3Score; }

    public int getPlayer4Score() { return player4Score; }

    public ArrayList getCurrentHand() {return currentHand;}

}
