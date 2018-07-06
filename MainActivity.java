package ee.edu.jpk.elina.mang2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button player_button;
    Button game_manager_button;
    Button guide_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        player_button = (Button) findViewById(R.id.player_button); // assign the layout id to the button
        // on button click
        player_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openplayerActivity();
            }
        });

        game_manager_button = (Button) findViewById(R.id.game_manager_button);
        game_manager_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            openplayerRegistrationToGameActivity();
            }
        });

        guide_button = (Button) findViewById(R.id.guide_button);
        guide_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openguideActivity();
            }
        });
    }
    public void openplayerActivity(){
        Intent intent = new Intent(this, playerActivity.class);
        startActivity(intent);
    }

    public void openplayerRegistrationToGameActivity(){
        Intent intent = new Intent(this, PlayerRegistrationToGameActivity.class);
        startActivity(intent);
    }
    public void openguideActivity() {
        Intent intent = new Intent(this, guideActivity.class);
        startActivity (intent);
    }



}
