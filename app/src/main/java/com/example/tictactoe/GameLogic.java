package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameLogic {
    private String[] playerNames={"Player 1","Player2"};
    private int[][] gameboard;
    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;
private int[] winType={-1,-1,-1};
    private int player=1;
    GameLogic(){
        gameboard=new int[3][3];
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                gameboard[r][c]=0;

            }
        }
    }
public boolean updateGameBoard(int row,int col){
        if(gameboard[row-1][col-1]==0){
            gameboard[row-1][col-1]=player;
            if(player==1){
                playerTurn.setText((playerNames[1]+" 's Turn"));
            }
            else{
                playerTurn.setText((playerNames[0]+" 's Turn"));
            }
            return true;
        }else{
            return false;
        }
}
public boolean winnerCheck(){
        boolean isWinner=false;
        for(int r=0;r<3;r++){
            if(gameboard[r][0]==gameboard[r][1]  && gameboard[r][0]==gameboard[r][2] && gameboard[r][0]!=0){
winType=new int[] {r,0,1};
                isWinner=true;
            }

        }
    for(int c=0;c<3;c++){
        if(gameboard[0][c]==gameboard[1][c]  && gameboard[2][c]==gameboard[c][c] && gameboard[0][c]!=0){
            winType=new int[] {0,c,2};
            isWinner=true;
        }

    }

        if(gameboard[0][0]==gameboard[1][1]  && gameboard[0][0]==gameboard[2][2] && gameboard[0][0]!=0){

            winType=new int[] {0,2,3};
            isWinner=true;


    }

        if(gameboard[2][0]==gameboard[1][1]  && gameboard[2][0]==gameboard[0][2] && gameboard[2][0]!=0){
            winType=new int[] {2,2,4};
            isWinner=true;
        }
        int boardFilled=0;
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if(gameboard[r][c]!=0){
                    boardFilled+=1;
                }
            }
        }
if(isWinner){
    playAgainBTN.setVisibility(View.VISIBLE);
    homeBTN.setVisibility(View.VISIBLE);
    playerTurn.setText((playerNames[player-1] + "Won!!!!"));
    return  true;
}
else if(boardFilled==9){
    playAgainBTN.setVisibility(View.VISIBLE);
    homeBTN.setVisibility(View.VISIBLE);
    playerTurn.setText("Tie Game!!!!");
    return true;
}
else{
return false;
}
}
public void resetGame(){
    for(int r=0;r<3;r++){
        for(int c=0;c<3;c++){
            gameboard[r][c]=0;

        }
    }
    player=1;
    playAgainBTN.setVisibility(View.GONE);
    homeBTN.setVisibility(View.GONE);
    playerTurn.setText((playerNames[0] +" 's Turn"));

}
public void setPlayAgainBTN(Button playAgainBTN){
        this.playAgainBTN=playAgainBTN;
}
public void setHomeBtn(Button homeBTN){
        this.homeBTN=homeBTN;
}
public void setPlayerTurn(TextView playerTurn){
        this.playerTurn=playerTurn;
}

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int[][] getGameboard() {
        return gameboard;
    }
    public void setPlayer(int player){
        this.player=player;
    }
    public int getPlayer(){
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
