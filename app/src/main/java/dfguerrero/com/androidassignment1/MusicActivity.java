package dfguerrero.com.androidassignment1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.prefs.PreferenceChangeEvent;

public class MusicActivity extends AppCompatActivity {
    TextView quotesTxt;
    ImageButton nextQuote;
    ImageButton prevQuote;
    String[] quotes;
    int next=0;
    int prev=6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Resources res = getResources();
        quotes = res.getStringArray(R.array.arrayMusic);
        quotesTxt = (TextView) findViewById(R.id.musicView);
        nextQuote =(ImageButton)findViewById(R.id.next);
        prevQuote =(ImageButton)findViewById(R.id.prev);

        Random rand = new Random();
        quotesTxt.setText(quotes[rand.nextInt(5)+1]);

        nextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next++;
                if(next==6){
                    next =0;
                }
                quotesTxt.setText(quotes[next]);
            }
        });
        prevQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev--;
                if(prev==0){
                    prev =6;
                }
                quotesTxt.setText(quotes[prev]);
            }
        });

        /*Write Last Music in Shared Preferences*/

        SharedPreferences prefs = getSharedPreferences("Last", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("lastQuote",quotesTxt.getText().toString());
        editor.apply();
    }
    /*Saving and Restoring State in Bundle to keep for Ratation*/

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("music", quotesTxt.getText().toString());


    }

    protected void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);
        String counter = inState.getString("music");
        quotesTxt.setText(counter);
    }
}
