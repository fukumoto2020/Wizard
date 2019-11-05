package com.example.wizard.wizard;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.media.Image;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wizard.GameFramework.GameHumanPlayer;
import com.example.wizard.GameFramework.GameMainActivity;
import com.example.wizard.GameFramework.infoMessage.GameState;
import com.example.wizard.R;
import com.example.wizard.game.R;
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
public class WizardHumanPlayer1 extends GameHumanPlayer implements View.OnTouchListener {
    //Tag for logging
    private static final String TAG = "WizardHumanPlayer1";
    // the current activity
    private GameMainActivity myActivity;

    // the surface view
    private WizardSurfaceView surfaceView;

    // the ID for the layout to use
    private int layoutId;

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
     * @param layoutId
     *      the id of the layout to use
     */
    public WizardHumanPlayer1(String name, int layoutId) {
        super(name);
        this.layoutId = layoutId;
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
        else if (!(info instanceof WizardState))
            // if we do not have a WizardState, ignore
            return;
        else {
            surfaceView.setState((WizardState)info);
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
            switch(((WizardCards) info).getCardValue()){
                case "diamond":
                    switch(((WizardGameState) info).getCardNumber()){
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
                    switch(((WizardGameState) info).getCardValue()){
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
                    switch(((WizardGameState) info).getCardValue()){
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
                    switch(((WizardGameState) info).getCardValue()){
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
        activity.setContentView(layoutId);

        // set the surfaceView instance variable
        surfaceView = (WizardSurfaceView)myActivity.findViewById(R.id.surfaceView);
        Logger.log("set listener","OnTouch");
        surfaceView.setOnTouchListener(this);

        //CHANGED
        ImageView card1 = (ImageView)myActivity.findViewById(R.id.imageView1);
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
        card8.setOnTouchListener(this);
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

    /**
     * callback method when the screen it touched. We're
     * looking for a screen touch (which we'll detect on
     * the "up" movement" onto a tic-tac-tie square
     *
     * @param event
     * 		the motion event that was detected
     */
    public boolean onTouch(View v, MotionEvent event) {
        // ignore if not an "up" event
        if (event.getAction() != MotionEvent.ACTION_UP) return true;
        // get the x and y coordinates of the touch-location;
        // convert them to square coordinates (where both
        // values are in the range 0..2)
        int x = (int) event.getX();
        int y = (int) event.getY();
        Point p = surfaceView.mapPixelToSquare(x, y);

        // if the location did not map to a legal square, flash
        // the screen; otherwise, create and send an action to
        // the game
        if (p == null) {
            surfaceView.flash(Color.RED, 50);
        } else {
            WizardMoveAction action = new WizardMoveAction(this, p.y, p.x);
            Logger.log("onTouch", "Human player sending WizardMA ...");
            game.sendAction(action);
            surfaceView.invalidate();
        }

        // register that we have handled the event
        return true;

    }


}
