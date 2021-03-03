package lpmi.potherat.promo2021.swapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import lpmi.potherat.promo2021.swapiapp.data.SWAPI;
import lpmi.potherat.promo2021.swapiapp.data.sw.People;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharactersActivity extends AppCompatActivity {

    /**
     * Liste de données en dur pour tests
     */
    ArrayList<People> peopleArrayList;
    /**
     * L'adapter qui sera affecté à notre recyclerview
     */
    CharactersAdapter charactersAdapter;
    /**
     * Le Recyclerview, en charge d'afficher la liste des éléments.
     */
    RecyclerView lstCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        //Récupération de la recyclerview dans le layout
        lstCharacters = findViewById(R.id.lstCharacters);
        //Paramétrage du LayoutManager, qui va déterminer la méthode d'affichage du recyclerview
        // - LinearLayoutManager, une liste verticale ou horizontale
        // - GridLayoutManager, une liste sous forme de grille
        lstCharacters.setLayoutManager(new LinearLayoutManager(this));

        // ------------------------------------------------------
        // - Création d'un jeu de test de personnages pour la démo
        People people1 = new People();
        people1.name = "Chewbacca";
        people1.birthYear = "-598 BYY";
        people1.gender = "Male";
        People people2 = new People();
        people2.name = "Han Solo";
        people2.birthYear = "-90 BYY";
        people2.gender = "Male";
        peopleArrayList = new ArrayList<People>(2){{
            add(people1);
            add(people2);
        }};
        // ------------------------------------------------------
        //Création de l'adapter, qui permet de faire le lien entre notre liste de personnages et
        //les items à afficher dans la RecyclerView
        charactersAdapter = new CharactersAdapter(peopleArrayList);
        //Affectation de notre adapter à la liste
        lstCharacters.setAdapter(charactersAdapter);


        // ------
        // Récupération de la liste des personnages depuis l'API
        Retrofit retrofit = new Retrofit.Builder()
                // L'url de base des endpoints de l'api
                .baseUrl("https://swapi.dev/")
                // Le converter à utiliser pour convertir les données JSON en objets du modèle
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Création du service SWAPI
        SWAPI service = retrofit.create(SWAPI.class);

        Call<People> onePeople = service.getOnePeople(1);
        onePeople.enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                if(response.isSuccessful()){
                    People people = response.body();
                    peopleArrayList.add(people);

                    //On notifie l'adapter de notre recyclerview que les données ont changé pour
                    //qu'il s'actualise
                    charactersAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                Log.e("NETWORK","Erreur réseau : " + Log.getStackTraceString(t));
            }
        });

        // ------


    }
}