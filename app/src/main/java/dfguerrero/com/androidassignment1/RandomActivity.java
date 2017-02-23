package dfguerrero.com.androidassignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    String[] quotes;
    String[] inspiration;
    String[] animals;
    String[] jokes;
    String[] music;
    int quoteIndex;
    TextView random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        random = (TextView) findViewById(R.id.random);


        /************************************************
         * Getting a reference to the five String arrays
         * stored in the Values directory
         ************************************************/

        quotes = getResources().getStringArray(R.array.quotes);
        inspiration = getResources().getStringArray(R.array.arrayInspiration);
        animals = getResources().getStringArray(R.array.arrayAnimals);
        jokes = getResources().getStringArray(R.array.arrayJokes);
        music = getResources().getStringArray(R.array.arrayMusic);

        Random ran = new Random();
        quoteIndex = ran.nextInt(4) + 1;
        String space = "\n\n\n\n";

        /**************************************************
         * Simple switch statement to chose a random quote
         **************************************************/

        switch (ran.nextInt(4) + 1) {
            case 1:
                random.setText("QUOTES" + space + quotes[quoteIndex]);
                break;
            case 2:
                random.setText("INSPIRATION" + space + inspiration[quoteIndex]);
                break;
            case 3:
                random.setText("ANIMALS" + space + animals[quoteIndex]);
                break;
            case 4:
                random.setText("MOBILE JOKES" + space + jokes[quoteIndex]);
                break;
            case 5:
                random.setText("MUSIC" + space + music[quoteIndex]);
        }

        SharedPreferences prefs = getSharedPreferences("Last", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("lastQuote",random.getText().toString());
        editor.apply();
    }

    /*****************************************************
     * Saving the randomQuote state in bundle for rotation
     *****************************************************/

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("random", random.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        String storedQuote = inState.getString("random");
        random.setText(storedQuote);

    }

}
