package lpmi.potherat.promo2021.swapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCharacters = findViewById(R.id.btnCharacters);

        btnCharacters.setOnClickListener(view -> {
            startActivity(new Intent(this,CharactersActivity.class));
        });

    }
}