package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);
        Button playAgainBTN=findViewById(R.id.button3);
        Button homeBTN=findViewById(R.id.button4);
        TextView playerTurn=findViewById(R.id.textView);
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        String[] playerNames=getIntent().getStringArrayExtra("PLAYER_NAMES");
        if(playerNames!=null){
            playerTurn.setText((playerNames[0]+ " 's Turn"));
        }
ticTacToeBoard=findViewById(R.id.ticTacToeBoard2);
ticTacToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);
    }
    public void button3(View view){
ticTacToeBoard.resetGame();
ticTacToeBoard.invalidate();
    }
    public void button4(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}