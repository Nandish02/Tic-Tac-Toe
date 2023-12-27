package com.example.tictactoe;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game implements Parcelable {
    private String uuid;
    private boolean open;
    private boolean singlePlayer;
    private String player1,player2;
    private Integer turn;
    private String winner;
    private String status;
    private List<String> tictactoe;

    public Game(){

    }

    public Game(boolean open, boolean singlePlayer, String player1, String player2,String status,String winner,Integer turn,List<String> tictactoe){
        this.uuid = UUID.randomUUID().toString();
        this.open = open;
        this.singlePlayer = singlePlayer;
        this.player1 = player1;
        this.player2 = player2;
        this.status = status;
        this.winner = winner;
        this.turn = turn;
        this.tictactoe = tictactoe;
    }

    Game(boolean open, boolean singlePlayer, String player1, String player2,String status,String winner,Integer turn){
        this.uuid = UUID.randomUUID().toString();
        this.open = open;
        this.singlePlayer = singlePlayer;
        this.player1 = player1;
        this.player2 = player2;
        this.status = status;
        this.winner = winner;
        this.turn = turn;
        initializeBoard();
    }

    protected Game(Parcel in) {
        uuid = in.readString();
        open = in.readByte() != 0;
        singlePlayer = in.readByte() != 0;
        player1 = in.readString();
        player2 = in.readString();
        if (in.readByte() == 0) {
            turn = null;
        } else {
            turn = in.readInt();
        }
        winner = in.readString();
        status = in.readString();
        tictactoe = in.createStringArrayList();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public boolean getOpen() {
        return open;
    }

    public boolean getSinglePlayer() {
        return singlePlayer;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getUUID() {
        return uuid;
    }

    public List<String> getTictactoe() {
        return tictactoe;
    }

    public void setTictactoe(List<String> tictactoe) {
        this.tictactoe = tictactoe;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Integer getTurn() {
        return turn;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void initializeBoard(){
        tictactoe = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            tictactoe.add("");
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(uuid);
        parcel.writeByte((byte) (open ? 1 : 0));
        parcel.writeByte((byte) (singlePlayer ? 1 : 0));
        parcel.writeString(player1);
        parcel.writeString(player2);
        if (turn == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(turn);
        }
        parcel.writeString(winner);
        parcel.writeString(status);
        parcel.writeStringList(tictactoe);
    }
}
