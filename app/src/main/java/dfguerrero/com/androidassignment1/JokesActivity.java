package dfguerrero.com.androidassignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JokesActivity extends AppCompatActivity {

    TextView quotesText;
    String joke;
    String[] quotes;
    final int LAST_JOKE = 1;

    ImageButton nextBtn;
    ImageButton prevBtn;

    int next = 0;
    int prev = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        quotes = getResources().getStringArray(R.array.arrayJokes);
        quotesText = (TextView) findViewById(R.id.jokes);

        Random one = new Random();
        quotesText.setText(quotes[one.nextInt(4)+1]);

        SharedPreferences prefs = getSharedPreferences("Last", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("lastQuote",quotesText.getText().toString());
        editor.apply();


    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("jokes", quotesText.getText().toString());


    }

    protected void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);
        String counter = inState.getString("jokes");
        quotesText.setText(counter);
    }



}
