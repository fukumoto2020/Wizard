package com.example.wizard.wizard;

import com.example.wizard.GameFramework.infoMessage.GameState;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class WizardGameState extends GameState {
    private int playerTurn; //which players turn it is
    private int cardPlayed; //card number player chooses to play for round
    private int gameStage;  //which state of the game the player is in
    private String trumpCard;  //suit of trump card
    public int roundNum;
    private static String cardSuit;   //cards suit
    private static int cardNumber;  //cards value
    private int numberPlayers = 3;

    //HASHTABLE FOR PLAYERS SCORES
    private Hashtable<String, Integer> playerScore = new Hashtable<>();
    private Hashtable<String, Integer> bidNum = new Hashtable<String, Integer>();
   // private Hashtable<String, Integer> deck = new Hashtable<String, Integer>();   //all the cards in the deck
    private ArrayList<WizardCards> deck = new ArrayList<>();

    //CHANGED: player array is a list of lists of wizard cards
    private ArrayList<ArrayList<WizardCards>> playerArray = new ArrayList<>();
    private ArrayList<String> cardsPlayed = new ArrayList<>();

    public WizardGameState(){
        this.playerTurn = 0; //player 0 will go first
        this.cardPlayed = -1;    //player has no played card yet
        this.gameStage = 0;      //starts at game state 0: bidding phase
        this.trumpCard = "Queen";     //trump card is not decided yet?
        this.roundNum = 1;

        //CHANGED
        playerScore.put("player 1", 0);
        playerScore.put("player 2", 0);
        playerScore.put("player 3", 0);
        playerScore.put("player 4", 0);

        bidNum.put("player 1", 0);
        bidNum.put("player 2", 0);
        bidNum.put("player 3", 0);
        bidNum.put("player 4", 0);


        WizardCards heartJoker = new WizardCards("heart", 0);
        WizardCards heartTwo = new WizardCards("heart",2);
        WizardCards heartThree = new WizardCards("heart",3);
        WizardCards heartFour = new WizardCards("heart",4);
        WizardCards heartFive = new WizardCards("heart",5);
        WizardCards heartSix = new WizardCards("heart",6);
        WizardCards heartSeven = new WizardCards("heart",7);
        WizardCards heartEight = new WizardCards("heart",8);
        WizardCards heartNine = new WizardCards("heart",9);
        WizardCards heartTen = new WizardCards("heart",10);
        WizardCards heartJack = new WizardCards("heart",11);
        WizardCards heartQueen = new WizardCards("heart",12);
        WizardCards heartKing = new WizardCards("heart",13);
        WizardCards heartAce = new WizardCards("heart",14);
        WizardCards heartWizard = new WizardCards("heart",15);

        WizardCards spadeJoker = new WizardCards("spade", 0);
        WizardCards spadeTwo = new WizardCards("spade",2);
        WizardCards spadeThree = new WizardCards("spade",3);
        WizardCards spadeFour = new WizardCards("spade",4);
        WizardCards spadeFive = new WizardCards("spade",5);
        WizardCards spadeSix = new WizardCards("spade",6);
        WizardCards spadeSeven = new WizardCards("spade",7);
        WizardCards spadeEight = new WizardCards("spade",8);
        WizardCards spadeNine = new WizardCards("spade",9);
        WizardCards spadeTen = new WizardCards("spade",10);
        WizardCards spadeJack = new WizardCards("spade",11);
        WizardCards spadeQueen = new WizardCards("spade",12);
        WizardCards spadeKing = new WizardCards("spade",13);
        WizardCards spadeAce = new WizardCards("spade",14);
        WizardCards spadeWizard = new WizardCards("spade",15);

        WizardCards diamondJoker = new WizardCards("diamond", 0);
        WizardCards diamondTwo = new WizardCards("diamond",2);
        WizardCards diamondThree = new WizardCards("diamond",3);
        WizardCards diamondFour = new WizardCards("diamond",4);
        WizardCards diamondFive = new WizardCards("diamond",5);
        WizardCards diamondSix = new WizardCards("diamond",6);
        WizardCards diamondSeven = new WizardCards("diamond",7);
        WizardCards diamondEight = new WizardCards("diamond",8);
        WizardCards diamondNine = new WizardCards("diamond",9);
        WizardCards diamondTen = new WizardCards("diamond",10);
        WizardCards diamondJack = new WizardCards("diamond",11);
        WizardCards diamondQueen = new WizardCards("diamond",12);
        WizardCards diamondKing = new WizardCards("diamond",13);
        WizardCards diamondAce = new WizardCards("diamond",14);
        WizardCards diamondWizard = new WizardCards("diamond",15);

        WizardCards clubJoker = new WizardCards("club", 0);
        WizardCards clubTwo = new WizardCards("club",2);
        WizardCards clubThree = new WizardCards("club",3);
        WizardCards clubFour = new WizardCards("club",4);
        WizardCards clubFive = new WizardCards("club",5);
        WizardCards clubSix = new WizardCards("club",6);
        WizardCards clubSeven = new WizardCards("club",7);
        WizardCards clubEight = new WizardCards("club",8);
        WizardCards clubNine = new WizardCards("club",9);
        WizardCards clubTen = new WizardCards("club",10);
        WizardCards clubJack = new WizardCards("club",11);
        WizardCards clubQueen = new WizardCards("club",12);
        WizardCards clubKing = new WizardCards("club",13);
        WizardCards clubAce = new WizardCards("club",14);
        WizardCards clubWizard = new WizardCards("club",15);

        Collections.addAll(deck, heartJoker, heartTwo, heartThree, heartFour, heartFive, heartSix, heartSeven, heartEight, heartNine, heartTen, heartJack, heartQueen, heartKing, heartAce, heartWizard,
                spadeJoker, spadeTwo, spadeThree, spadeFour, spadeFive, spadeSix, spadeSeven, spadeEight, spadeNine, spadeTen, spadeJack, spadeQueen, spadeKing, spadeAce, spadeWizard,
                diamondJoker, diamondTwo, diamondThree, diamondFour, diamondFive, diamondSix, diamondSeven, diamondEight, diamondNine, diamondTen, diamondJack, diamondQueen, diamondKing, diamondAce, diamondWizard,
                clubJoker, clubTwo, clubThree, clubFour, clubFive, clubSix, clubSeven, clubEight, clubNine, clubTen, clubJack, clubQueen, clubKing, clubAce, clubWizard);

       /* deck.put("heart zero", 0);    //joker
        deck.put("heart two", 2);
        deck.put("heart three", 3);
        deck.put("heart four", 4);
        deck.put("heart five", 5);
        deck.put("heart six", 6);
        deck.put("heart seven", 7);
        deck.put("heart eight", 8);
        deck.put("heart nine", 9);
        deck.put("heart ten", 10);
        deck.put("heart eleven", 11); //jack
        deck.put("heart twelve", 12); //queen
        deck.put("heart thirteen", 13);   //king
        deck.put("heart fourteen", 14);   //ace
        deck.put("heart fifteen", 15);  //wizard
        deck.put("spade zero", 0);    //joker
        deck.put("spade two", 2);
        deck.put("spade three", 3);
        deck.put("spade four", 4);
        deck.put("spade five", 5);
        deck.put("spade six", 6);
        deck.put("spade seven", 7);
        deck.put("spade eight", 8);
        deck.put("spade nine", 9);
        deck.put("spade ten", 10);
        deck.put("spade eleven", 11); //jack
        deck.put("spade twelve", 12); //queen
        deck.put("spade thirteen", 13);   //king
        deck.put("spade fourteen", 14);   //ace
        deck.put("spade fifteen", 15);  //wizard
        deck.put("diamond zero", 0);    //joker
        deck.put("diamond two", 2);
        deck.put("diamond three", 3);
        deck.put("diamond four", 4);
        deck.put("diamond five", 5);
        deck.put("diamond six", 6);
        deck.put("diamond seven", 7);
        deck.put("diamond eight", 8);
        deck.put("diamond nine", 9);
        deck.put("diamond ten", 10);
        deck.put("diamond eleven", 11); //jack
        deck.put("diamond twelve", 12); //queen
        deck.put("diamond thirteen", 13);   //king
        deck.put("diamond fourteen", 14);   //ace
        deck.put("diamond fifteen", 15);  //wizard
        deck.put("club zero", 0);    //joker
        deck.put("club two", 2);
        deck.put("club three", 3);
        deck.put("club four", 4);
        deck.put("club five", 5);
        deck.put("club six", 6);
        deck.put("club seven", 7);
        deck.put("club eight", 8);
        deck.put("club nine", 9);
        deck.put("club ten", 10);
        deck.put("club eleven", 11); //jack
        deck.put("club twelve", 12); //queen
        deck.put("club thirteen", 13);   //king
        deck.put("club fourteen", 14);   //ace
        deck.put("club fifteen", 15);  //wizard*/

        makePlayers(3);
        //dealDeck(deck, 1); //gives player a random card to start
        for (int currentHand = 0; currentHand < playerArray.size(); currentHand++){
            dealDeck(deck, playerArray.get(currentHand), roundNum);
        }
    }

    public void makePlayers(int numPlayers){
        switch (numPlayers){
            case 6:
                ArrayList<WizardCards> player6Hand = new ArrayList<>(); //cards player has in their hand
                playerArray.add(player6Hand);
            case 5:
                ArrayList<WizardCards> player5Hand = new ArrayList<>(); //cards player has in their hand
                playerArray.add(player5Hand);
            case 4:
                ArrayList<WizardCards> player4Hand = new ArrayList<>(); //cards player has in their hand
                playerArray.add(player4Hand);
            case 3:
                ArrayList<WizardCards> player3Hand = new ArrayList<>(); //cards player has in their hand
                ArrayList<WizardCards> player2Hand = new ArrayList<>(); //cards player has in their hand
                ArrayList<WizardCards> player1Hand = new ArrayList<>(); //cards player has in their hand
                playerArray.add(player1Hand);
                playerArray.add(player2Hand);
                playerArray.add(player3Hand);
        }
    }

    //deals a card out to a player
    //CHANGED
    public void dealDeck(ArrayList deck, ArrayList playerHand, int numTricks){
        Random random = new Random();
        for (int round = 0; round < numTricks; round++) {
            int randomCard = random.nextInt(deck.size());
            playerHand.add(deck.get(randomCard));
            deck.remove(randomCard);
        }
    }

    //copy constructor
    public WizardGameState(WizardGameState myState){
        playerTurn = myState.playerTurn;
        bidNum = myState.bidNum;
        cardPlayed = myState.cardPlayed;
        playerScore = myState.playerScore;
        gameStage = myState.gameStage;
        trumpCard = myState.trumpCard;
        roundNum = myState.roundNum;

        //is this a deep copy?
        deck = myState.deck;
        playerArray = myState.playerArray;
    }

    @Override
    public String toString(){
        return "Player turn: " + this.playerTurn + "\n Bid: " +
                "\n Card Played: " + this.cardPlayed + "\n Player Score: " + this.playerScore +
                "\n Game Stage: " + this.gameStage + "\n Trump Card: " + this.trumpCard +
                "\n Round Number: " + this.roundNum + "\n Current Deck: " + this.deck +
                "\n Player's Hand: " + this.playerArray;
    }

    //CHANGED
    public boolean placeBid(Hashtable bidNum, int bid)
    {
        String player = "player" + playerTurn + "Hand";
        if (bidNum.containsKey(player) && bid >= 0 && bid <= getRoundNum() && gameStage == 0)
        {
            bidNum.put(player, bid);
            if (playerTurn == 3){
                playerTurn = 0;
            }
            else {
                playerTurn++;
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    //have to change playcard to use card objects
    public boolean playCard(Hashtable playerArray, int player, String card)
    {
        if (player == playerTurn && playerArray.get(player).containsKey(card))
        {
            currentHand.remove(card);
            playerArray.set(player, currentHand);
            cardsPlayed.add(card);
            playerTurn++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public ArrayList getPlayerHand(int player) {return playerArray.get(player);}

    public int getPlayerTurn() {return playerTurn; }

    public int getCardPlayed() {return cardPlayed; }

    public int getGameStage() { return gameStage; }

    public String getTrumpCard() { return trumpCard; }

    public int getRoundNum() { return roundNum; }

    //CHANGED

    public int getPlayer1Score(){ return (int)playerScore.get("player 1"); }

    public int getPlayer2Score(){ return (int)playerScore.get("player 2"); }

    public int getPlayer3Score(){ return (int)playerScore.get("player 3"); }

    public int getPlayer4Score(){ return (int)playerScore.get("player 4"); }

    public static String getCardSuit() {return cardSuit; }

    public static int getCardNumber() {return cardNumber;}

    public void setPlayerTurn(int playerTurn) { this.playerTurn = playerTurn; }

    public void setCardPlayed(int cardPlayed) { this.cardPlayed = cardPlayed; }

    public void setGameStage(int gameStage) { this.gameStage = gameStage; }

    public void setTrumpCard(String trumpCard) { this.trumpCard = trumpCard; }

    public void setRoundNum(int roundNum) { this.roundNum = roundNum; }

    //CHANGED

    public void setCardNumber(int cardNumber) {this.cardNumber = cardNumber; }

    public void setCardSuit(String cardSuit) {this.cardSuit = cardSuit; }

}
