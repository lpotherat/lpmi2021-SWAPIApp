package lpmi.potherat.promo2021.swapiapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ViewHolder, cette classe permet de garder et exposer des références aux différents éléments
 * de la vue d'un item de la liste. Dans ce cas, on récupère des références vers les TextView
 * name, birthyear et gender.
 */
public class CharacterItemViewHolder extends RecyclerView.ViewHolder {

    public TextView txtName;
    public TextView txtBirthYear;
    public TextView txtGender;

    /**
     * Initialisation du viewholder à partir d'une vue
     * @param itemView la vue item_character
     */
    public CharacterItemViewHolder(@NonNull View itemView) {
        super(itemView);
        // ------------------------------------------
        // - On récupère ici les différentes vues relativement à itemview
        //   et on conserve les références dans le ViewHolder.
        txtName = itemView.findViewById(R.id.txtName);
        txtBirthYear = itemView.findViewById(R.id.txtBirthYear);
        txtGender = itemView.findViewById(R.id.txtGender);
        // ------------------------------------------
    }
}
