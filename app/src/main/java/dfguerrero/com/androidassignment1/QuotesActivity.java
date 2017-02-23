package dfguerrero.com.androidassignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuotesActivity extends AppCompatActivity {


    TextView quotesTxt;
    ImageButton nextQuote;
    ImageButton prevQuote;
    String[] quotes;
    String i;
    int next = 0;
    int prev = 4;

    public static final String TAG = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);


        quotesTxt = (TextView) findViewById(R.id.quotesArray);
        nextQuote = (ImageButton) findViewById(R.id.nextQuote);
        prevQuote = (ImageButton) findViewById(R.id.prevQuote);

        Resources res = getResources();
        quotes = res.getStringArray(R.array.quotes);
        Random rand = new Random();
        i = quotes[rand.nextInt(4) + 1];
        quotesTxt.setText(i);

        nextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next++;
                if (next == 5) {
                    next = 0;
                }
                quotesTxt.setText(quotes[next]);
            }
        });
        prevQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev--;
                if (prev == 0) {
                    prev = 4;
                }
                quotesTxt.setText(quotes[prev]);
            }
        });

        /*Writing the last Quote to Shared Preferences */

        SharedPreferences prefs = getSharedPreferences("Last", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("lastQuote", quotesTxt.getText().toString());
        editor.apply();

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("quote", quotesTxt.getText().toString());


    }

    protected void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);
        String counter = inState.getString("quote");
        quotesTxt.setText(counter);
    }


}
