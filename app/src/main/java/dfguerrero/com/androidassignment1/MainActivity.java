package dfguerrero.com.androidassignment1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity {

    Button quotesBtn;
    Button smurfsBtn;
    Button jokesBtn;
    Button scienceBtn;
    Button musicBtn;
    Button lastBtn;

    ImageButton randomBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    quotesBtn = (Button) findViewById(R.id.quotes);
        quotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context quotesContext = MainActivity.this;
                Class quotesActivity = QuotesActivity.class;
             Intent quotesIntent = new Intent(quotesContext,quotesActivity);
              startActivity(quotesIntent);

            }

        });

    randomBtn = (ImageButton) findViewById(R.id.random_button);
        randomBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context randomContext = MainActivity.this;
                Class randomActivity = RandomActivity.class;
            Intent randomIntent = new Intent(randomContext,randomActivity);
                startActivity(randomIntent);
            }

        });

        smurfsBtn = (Button) findViewById(R.id.smurfs);
        smurfsBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context smurfsContext = MainActivity.this;
                Class smurfsActivity = AnimalsActivity.class;
                Intent smurfsIntent = new Intent(smurfsContext,smurfsActivity);
                startActivity(smurfsIntent);
            }

        });
        jokesBtn = (Button) findViewById(R.id.jokes);
        jokesBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context jokesContext = MainActivity.this;
                Class jokesActivity = JokesActivity.class;
                Intent jokesIntent = new Intent(jokesContext,jokesActivity);
                startActivity(jokesIntent);
            }

        });
        scienceBtn = (Button) findViewById(R.id.science);
        scienceBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context scienceContext = MainActivity.this;
                Class scienceActivity = InspirationActivity.class;
                Intent scienceIntent = new Intent(scienceContext,scienceActivity);
                startActivity(scienceIntent);
            }

        });
        musicBtn = (Button) findViewById(R.id.music);
        musicBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context musicContext = MainActivity.this;
                Class musicActivity = MusicActivity.class;
                Intent musicIntent = new Intent(musicContext,musicActivity);
                startActivity(musicIntent);
            }

        });
        lastBtn = (Button) findViewById(R.id.last);
        lastBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Context lastContext = MainActivity.this;
                Class lastActivity = LastActivity.class;
                Intent lastIntent = new Intent(lastContext,lastActivity);
                startActivity(lastIntent);
            }

        });





    }



}
