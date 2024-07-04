package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayersSetup extends AppCompatActivity {
private EditText name1;
private EditText name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_setup);
        name1=findViewById(R.id.edit1);
        name2=findViewById(R.id.edit2);

    }
    public void button(View view){
        String edit1=name1.getText().toString();
        String edit2=name2.getText().toString();
Intent intent =new Intent(this,GameDisplay.class);
intent.putExtra("PLAYER_NAMES",new String[] {edit1,edit2});
startActivity(intent);


    }
}