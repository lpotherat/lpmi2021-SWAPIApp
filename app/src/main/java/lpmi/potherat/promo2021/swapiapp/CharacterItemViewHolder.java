package lpmi.potherat.promo2021.swapiapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterItemViewHolder extends RecyclerView.ViewHolder {

    public TextView txtName;
    public TextView txtBirthYear;
    public TextView txtGender;


    public CharacterItemViewHolder(@NonNull View itemView) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txtName);
        txtBirthYear = itemView.findViewById(R.id.txtBirthYear);
        txtGender = itemView.findViewById(R.id.txtGender);

    }
}
