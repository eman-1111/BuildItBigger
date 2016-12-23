package eman.example.com.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.MyJokes;

public class JokesDisplay extends AppCompatActivity {
    TextView txtJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
       // MyJokes joke = new MyJokes();
        //Log.e("joke", joke.funnyJoke());
        Intent intent = getIntent();
        String joke = intent.getStringExtra("JOKE_EXTRA");
        txtJoke = (TextView) findViewById(R.id.txt_joke);
        txtJoke.setText(joke);
    }
}
