package dfguerrero.com.androidassignment1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class AnimalsActivity extends AppCompatActivity {
    TextView quotesTxt;
    String[] quotes;
    ImageButton nextBtn;
    ImageButton prevBtn;
    int next = 0;
    int prev = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        quotes = getResources().getStringArray(R.array.arrayAnimals);
        quotesTxt = (TextView) findViewById(R.id.smartAnimals);
        nextBtn = (ImageButton) findViewById(R.id.next);
        prevBtn = (ImageButton) findViewById(R.id.prev);
        Random one = new Random();
        quotesTxt.setText(quotes[one.nextInt(4) + 1]);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next++;
                if (next == 4) {
                    next = 0;
                }
                quotesTxt.setText(quotes[next]);
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev--;
                if (prev == 0) {
                    prev = 4;
                }
                quotesTxt.setText(quotes[prev]);
            }
        });
        SharedPreferences prefs = getSharedPreferences("Last", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("lastQuote", quotesTxt.getText().toString());
        editor.apply();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("animals", quotesTxt.getText().toString());


    }

    protected void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);
        String counter = inState.getString("animals");
        quotesTxt.setText(counter);
    }
}
