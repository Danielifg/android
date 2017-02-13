package dfguerrero.com.androidassignment1;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class QuotesActivity extends AppCompatActivity {
    TextView quotesTxt;
    ImageButton nextQuote;
    ImageButton prevQuote;
    String[] quotes;
    int next=0;
    int prev=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        Resources res = getResources();
        quotes = res.getStringArray(R.array.quotes);
        quotesTxt = (TextView) findViewById(R.id.quotesArray);
        nextQuote =(ImageButton)findViewById(R.id.nextQuote);
        prevQuote =(ImageButton)findViewById(R.id.prevQuote);

        Random rand = new Random();
        quotesTxt.setText(quotes[rand.nextInt(4)+1]);

        nextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next++;
                if(next==5){
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
                    prev =4;
                }
                quotesTxt.setText(quotes[prev]);
            }
        });

    }
}
