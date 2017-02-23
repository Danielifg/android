package dfguerrero.com.androidassignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class LastActivity extends AppCompatActivity {
    TextView lastView;
    String lquote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        lastView = (TextView) findViewById(R.id.lastView);

        SharedPreferences prefs = getSharedPreferences("Last", Context.MODE_PRIVATE);
        lquote = prefs.getString("lastQuote", "");

        if (lquote.isEmpty()|| lquote == null ) {
            Toast.makeText(this, "Nothing Saved", Toast.LENGTH_LONG).show();

        } else {
            lastView.setText(lquote);
        }
    }


}

