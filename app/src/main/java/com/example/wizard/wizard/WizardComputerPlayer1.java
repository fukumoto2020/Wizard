package com.example.wizard.wizard;

import com.example.wizard.GameFramework.GameComputerPlayer;
import com.example.wizard.GameFramework.infoMessage.GameInfo;
import com.example.wizard.GameFramework.infoMessage.NotYourTurnInfo;
import com.example.wizard.GameFramework.utilities.Logger;

public class WizardComputerPlayer1 extends GameComputerPlayer{
    public WizardComputerPlayer1(String name){
        super(name);
    }
    /**
     * Called when the player receives a game-state (or other info) from the
     * game.
     *
     * @param info
     * 		the message from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {

        // if it was a "not your turn" message, just ignore it
        if (info instanceof NotYourTurnInfo) return;
        Logger.log("WizardComputer", "My turn!");
        // pick x and y positions at random (0-2)
        int xVal = (int)(3*Math.random());
        int yVal = (int)(3*Math.random());

        // delay for a second to make opponent think we're thinking
        sleep(1);

        // Submit our move to the game object. We haven't even checked it it's
        // our turn, or that that position is unoccupied. If it was not our turn,
        // we'll get a message back that we'll ignore. If it was an illegal move,
        // we'll end up here again (and possibly again, and again). At some point,
        // we'll end up randomly pick a move that is legal.
        Logger.log("WizardComputer", "Sending move");
        game.sendAction(new WizardMoveAction(this, yVal, xVal));

    }
}
