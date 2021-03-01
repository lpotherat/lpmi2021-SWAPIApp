package lpmi.potherat.promo2021.swapiapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lpmi.potherat.promo2021.swapiapp.data.sw.People;

/**
 * Adapter : Permet de faire le lien entre la liste de données et le recyclerview.
 * Il contient 3 méthodes obligatoires
 * - onCreateViewHolder : Vous devrez ici créer la vue pour un élément, et initialiser le viewholder
 * - onBindViewHolder : Vous devrez ici paramétrer les élements fournis dans le paramètre viewholder
 *   avec les données correspondantes dans la liste à la position demandée
 * - getItemCount : Vous devrez retourner le nombre d'éléments total de votre liste.
 */
public class CharactersAdapter extends RecyclerView.Adapter<CharacterItemViewHolder> {

    /**
     * La liste de personnage à adapter
     */
    private final List<People> peopleList;

    /**
     * Initialisation de l'adapter avec une liste de personnage fournie
     * @param peopleList liste à utiliser
     */
    public CharactersAdapter(List<People> peopleList){
        this.peopleList = peopleList;
    }

    /**
     * Méthode appelée lorsque le RecyclerView aura besoin de créer une vue pour un personnage.
     * @param parent la vue parente, fournie par le système
     * @param viewType le type de vue à créer, utile si notre liste peut afficher des élements de
     *                 nature différente
     * @return un viewholder de personnage
     */
    @NonNull
    @Override
    public CharacterItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character,parent,false);
        return new CharacterItemViewHolder(view);
    }

    /**
     * Méthode appelée lorsque le RecyclerView aura besoin d'afficher une vue avec des nouvelles
     * données. Il nous rappelle avec un viewholder, qui contient les parties de vue à paramétrer,
     * puis la position dans la liste de l'élément qu'il faut afficher. Ici, cela correspond à la
     * position dans la liste peopleList.
     * @param holder le viewholder à paramétrer
     * @param position la position de l'élement à afficher
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterItemViewHolder holder, int position) {
        People people = peopleList.get(position);

        holder.txtName.setText(people.name);
        holder.txtBirthYear.setText(people.birthYear);
        holder.txtGender.setText(people.gender);

    }

    /**
     * Méthode appelée par le RecyclerView lorsqu'il a besoin de connaître la taille de la liste à
     * afficher. On retourne ici la taille de l'arraylist poepleList.
     * @return le nombre total d'éléments à afficher
     */
    @Override
    public int getItemCount() {
        return peopleList.size();
    }
}
