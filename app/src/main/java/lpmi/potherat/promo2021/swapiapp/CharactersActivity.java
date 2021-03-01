package lpmi.potherat.promo2021.swapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CharactersActivity extends AppCompatActivity {


    RecyclerView lstCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        lstCharacters = findViewById(R.id.lstCharacters);

        lstCharacters.setLayoutManager(new LinearLayoutManager(this));





    }
}