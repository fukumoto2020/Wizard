package com.example.wizard.wizard;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.media.Image;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wizard.GameFramework.GameHumanPlayer;
import com.example.wizard.GameFramework.GameMainActivity;
import com.example.wizard.GameFramework.infoMessage.GameState;
import com.example.wizard.R;
import com.example.wizard.GameFramework.infoMessage.GameInfo;
import com.example.wizard.GameFramework.infoMessage.IllegalMoveInfo;
import com.example.wizard.GameFramework.infoMessage.NotYourTurnInfo;
import com.example.wizard.GameFramework.utilities.Logger;

/**
 * A GUI that allows a human to play tic-tac-toe. Moves are made by clicking
 * regions on a canvas
 *
 * @author Steven R. Vegdahl
 * @version September 2016
 */
public class WizardHumanPlayer extends GameHumanPlayer implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private WizardCards cardToPlay;

    private int bidNum = 0;

    WizardPlayAction myPlay = new WizardPlayAction(this, cardToPlay);

    WizardBidAction myBid = new WizardBidAction(this, bidNum);

    WizardGameState myState = new WizardGameState();

    WizardPlayer myPlayer = new WizardPlayer();


    //Tag for logging
    private static final String TAG = "WizardHumanPlayer1";
    // the current activity
    private GameMainActivity myActivity;

    // the surface view
    private WizardSurfaceView surfaceView;


    //CHANGED
    // the card picture
    private TextView player1Score = null;
    private TextView player2Score = null;
    private TextView player3Score = null;
    private TextView player4Score = null;
    private ImageView card1 = null;     //humans player card 1
    private ImageView card2 = null;
    private ImageView card3 = null;
    private ImageView card4 = null;
    private ImageView card5 = null;
    private ImageView card6 = null;
    private ImageView card7 = null;
    private ImageView card8 = null;
    private ImageView card1Played = null;   //the card that player 1 played
    private ImageView card2Played = null;
    private ImageView card3Played = null;
    private ImageView card4Played = null;
    private ImageView cardTrump = null;

    /**
     * constructor
     *
     * @param name
     * 		the player's name
     */
    public WizardHumanPlayer(String name) {
        super(name);
    }

    /**
     * Callback method, called when player gets a message
     *
     * @param info
     * 		the message
     */
    @Override
    public void receiveInfo(GameInfo info) {

        if (surfaceView == null) return;

        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo) {
            // if the move was out of turn or otherwise illegal, flash the screen
            surfaceView.flash(Color.RED, 50);
        }
        else if (!(info instanceof WizardGameState))
            // if we do not have a WizardState, ignore
            return;
        else {
            surfaceView.setState((WizardGameState)info);
            surfaceView.invalidate();
            Logger.log(TAG, "receiving");
        }

        //CHANGED

        if (info instanceof WizardGameState){
            this.player1Score.setText("Player 1 Total Score: "+(((WizardPlayer) info).getPlayer1Score()));
            this.player2Score.setText("Player 2 Total Score: "+(((WizardPlayer) info).getPlayer2Score()));
            this.player3Score.setText("Player 3 Total Score: "+(((WizardPlayer) info).getPlayer3Score()));
            this.player4Score.setText("Player 4 Total Score: "+(((WizardPlayer) info).getPlayer4Score()));


            //need to change this to use wizardcard objects
            switch(((WizardCards) info).getCardSuit()){
                case "diamond":
                    switch(((WizardCards) info).getCardNumber()){
                        case 0:
                            this.card1.setImageResource(R.drawable.jester);
                        case 2:
                            this.card1.setImageResource(R.drawable.two_diamond);
                        case 3:
                            this.card1.setImageResource(R.drawable.three_diamond);
                        case 4:
                            this.card1.setImageResource(R.drawable.four_diamond);
                        case 5:
                            this.card1.setImageResource(R.drawable.five_diamond);
                        case 6:
                            this.card1.setImageResource(R.drawable.six_diamond);
                        case 7:
                            this.card1.setImageResource(R.drawable.seven_diamond);
                        case 8:
                            this.card1.setImageResource(R.drawable.eight_diamond);
                        case 9:
                            this.card1.setImageResource(R.drawable.nine_diamond);
                        case 10:
                            this.card1.setImageResource(R.drawable.ten_diamond);
                        case 11:
                            this.card1.setImageResource(R.drawable.jack_diamond);
                        case 12:
                            this.card1.setImageResource(R.drawable.queen_diamond);
                        case 13:
                            this.card1.setImageResource(R.drawable.king_diamond);
                        case 14:
                            this.card1.setImageResource(R.drawable.ace_diamond);
                        case 15:
                            this.card1.setImageResource(R.drawable.wizard);
                    }
                case "heart":
                    switch(((WizardCards) info).getCardNumber()){
                        case "zero":
                            this.card1.setImageResource(R.drawable.jester);
                        case "two":
                            this.card1.setImageResource(R.drawable.two_heart);
                        case "three":
                            this.card1.setImageResource(R.drawable.three_heart);
                        case "four":
                            this.card1.setImageResource(R.drawable.four_heart);
                        case "five":
                            this.card1.setImageResource(R.drawable.five_heart);
                        case "six":
                            this.card1.setImageResource(R.drawable.six_heart);
                        case "seven":
                            this.card1.setImageResource(R.drawable.seven_heart);
                        case "eight":
                            this.card1.setImageResource(R.drawable.eight_heart);
                        case "nine":
                            this.card1.setImageResource(R.drawable.nine_heart);
                        case "ten":
                            this.card1.setImageResource(R.drawable.ten_heart);
                        case "eleven":
                            this.card1.setImageResource(R.drawable.jack_heart);
                        case "twelve":
                            this.card1.setImageResource(R.drawable.queen_heart);
                        case "thirteen":
                            this.card1.setImageResource(R.drawable.king_heart);
                        case "fourteen":
                            this.card1.setImageResource(R.drawable.ace_heart);
                        case "fifteen":
                            this.card1.setImageResource(R.drawable.wizard);
                    }
                case "spade":
                    switch(((WizardCards) info).getCardNumber()){
                        case "zero":
                            this.card1.setImageResource(R.drawable.jester);
                        case "two":
                            this.card1.setImageResource(R.drawable.two_spade);
                        case "three":
                            this.card1.setImageResource(R.drawable.three_spade);
                        case "four":
                            this.card1.setImageResource(R.drawable.four_spade);
                        case "five":
                            this.card1.setImageResource(R.drawable.five_spade);
                        case "six":
                            this.card1.setImageResource(R.drawable.six_spade);
                        case "seven":
                            this.card1.setImageResource(R.drawable.seven_spade);
                        case "eight":
                            this.card1.setImageResource(R.drawable.eight_spade);
                        case "nine":
                            this.card1.setImageResource(R.drawable.nine_spade);
                        case "ten":
                            this.card1.setImageResource(R.drawable.ten_spade);
                        case "eleven":
                            this.card1.setImageResource(R.drawable.jack_spade);
                        case "twelve":
                            this.card1.setImageResource(R.drawable.queen_spade);
                        case "thirteen":
                            this.card1.setImageResource(R.drawable.king_spade);
                        case "fourteen":
                            this.card1.setImageResource(R.drawable.ace_spade);
                        case "fifteen":
                            this.card1.setImageResource(R.drawable.wizard);
                    }
                case "club":
                    switch(((WizardCards) info).getCardNumber()){
                        case "zero":
                            this.card1.setImageResource(R.drawable.jester);
                        case "two":
                            this.card1.setImageResource(R.drawable.two_club);
                        case "three":
                            this.card1.setImageResource(R.drawable.three_club);
                        case "four":
                            this.card1.setImageResource(R.drawable.four_club);
                        case "five":
                            this.card1.setImageResource(R.drawable.five_club);
                        case "six":
                            this.card1.setImageResource(R.drawable.six_club);
                        case "seven":
                            this.card1.setImageResource(R.drawable.seven_club);
                        case "eight":
                            this.card1.setImageResource(R.drawable.eight_club);
                        case "nine":
                            this.card1.setImageResource(R.drawable.nine_club);
                        case "ten":
                            this.card1.setImageResource(R.drawable.ten_club);
                        case "eleven":
                            this.card1.setImageResource(R.drawable.jack_club);
                        case "twelve":
                            this.card1.setImageResource(R.drawable.queen_club);
                        case "thirteen":
                            this.card1.setImageResource(R.drawable.king_club);
                        case "fourteen":
                            this.card1.setImageResource(R.drawable.ace_club);
                        case "fifteen":
                            this.card1.setImageResource(R.drawable.wizard);
                    }
            }
        }
    }

    /**
     * sets the current player as the activity's GUI
     */
    public void setAsGui(GameMainActivity activity) {

        // remember our activitiy
        myActivity = activity;

        // Load the layout resource for the new configuration
        /*activity.setContentView(layoutId);

        // set the surfaceView instance variable
        surfaceView = (WizardSurfaceView)myActivity.findViewById(R.id.surfaceView);
        Logger.log("set listener","OnTouch");
        surfaceView.setOnTouchListener(this);*/


        LinearLayout cardLayout = (LinearLayout)activity.findViewById(R.id.cardLayout);
        for(int i = 0; i<myState.getRoundNum(); i++){
            ImageView card = new ImageView(this);

            //somehow check the card at index i of player's hand and assign that card's drawable file
            //to the new imageview created
            myPlayer.getCurrentHand().get(i);
            card.setImageResource(R.drawable.ace_club);

            //add layout width layout height stuff here
            cardLayout.addView(card);
        }



        //CHANGED
        /*ImageView card1 = (ImageView)myActivity.findViewById(R.id.imageView1);
        card1.setOnTouchListener(this);
        ImageView card2 = (ImageView)myActivity.findViewById(R.id.imageView2);
        card2.setOnTouchListener(this);
        ImageView card3 = (ImageView)myActivity.findViewById(R.id.imageView3);
        card3.setOnTouchListener(this);
        ImageView card4 = (ImageView)myActivity.findViewById(R.id.imageView4);
        card4.setOnTouchListener(this);
        ImageView card5 = (ImageView)myActivity.findViewById(R.id.imageView5);
        card5.setOnTouchListener(this);
        ImageView card6 = (ImageView)myActivity.findViewById(R.id.imageView6);
        card6.setOnTouchListener(this);
        ImageView card7 = (ImageView)myActivity.findViewById(R.id.imageView7);
        card7.setOnTouchListener(this);
        ImageView card8 = (ImageView)myActivity.findViewById(R.id.imageView8);
        card8.setOnTouchListener(this);*/
    }

    /**
     * returns the GUI's top view
     *
     * @return
     * 		the GUI's top view
     */
    @Override
    public View getTopView() { return myActivity.findViewById(R.id.top_gui_layout); }

    /**
     * perform any initialization that needs to be done after the player
     * knows what their game-position and opponents' names are.
     */
    protected void initAfterReady() {
        myActivity.setTitle("Tic-Tac-Toe: "+allPlayerNames[0]+" vs. "+allPlayerNames[1]);
    }

    /*
    bid number dropdown and imageview on click listeners go here
     */


    //spinner listener for the bid dropdown menu
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if(view.getId() == R.id.bidDropdown) {
            bidNum = (Integer) parent.getItemAtPosition(pos);
            super.game.sendAction(myBid);
        }

        //WizardHumanPlayer is like the controller, so when user interacts with dropdown and chooses a bid
        //we handle that bid here, set it equal to bidNum, and send bidNum through sendAction to the game class
        //WizardLocalGame extends LocalGame which extends Game, so it receives the action from Game

        //myBid is a WizardBidAction object which sends the player and the bid number to WizardBidAction

    }
    //unused method required with spinner
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void onClick(View button) {
        if(button.getId() == R.id.imageView){

        }
    }



}
