package eman.example.com.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.MyJokes;

public class JokesDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
        MyJokes joke = new MyJokes();
        Log.e("joke", joke.funnyJoke());
    }
}
