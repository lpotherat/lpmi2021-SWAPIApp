package lpmi.potherat.promo2021.swapiapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lpmi.potherat.promo2021.swapiapp.data.sw.People;

public class CharactersAdapter extends RecyclerView.Adapter<CharacterItemViewHolder> {

    private List<People> peopleList;

    public CharactersAdapter(List<People> peopleList){
        this.peopleList = peopleList;
    }

    @NonNull
    @Override
    public CharacterItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character,parent,false);
        CharacterItemViewHolder characterItemViewHolder = new CharacterItemViewHolder(view);
        return characterItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterItemViewHolder holder, int position) {
        People people = peopleList.get(position);

        holder.txtName.setText(people.name);
        holder.txtBirthYear.setText(people.birthYear);
        holder.txtGender.setText(people.gender);

    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }
}
