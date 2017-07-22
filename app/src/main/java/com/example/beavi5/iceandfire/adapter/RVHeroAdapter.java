package com.example.beavi5.iceandfire.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.beavi5.iceandfire.Character;
import com.example.beavi5.iceandfire.R;

import java.util.List;

/**
 * Created by beavi5 on 22.07.2017.
 */

public class RVHeroAdapter extends RecyclerView.Adapter<RVHeroAdapter.HeroHolder> {
    List<Character> listHeroes;

    @Override
    public HeroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_row,parent,false);
       return new HeroHolder(v);
    }

    @Override
    public void onBindViewHolder(HeroHolder holder, int position) {

        holder.gender.setText(listHeroes.get(position).getGender());
        holder.culture.setText(listHeroes.get(position).getCulture());
        holder.name.setText(listHeroes.get(position).getName());

        String aliasesHero = "";
        for (String alias :listHeroes.get(position).getAliases()) {
            aliasesHero+=alias;

        }
        holder.aliases.setText(aliasesHero);

    }

    public RVHeroAdapter(List<Character> listHeroes) {
        this.listHeroes = listHeroes;
    }

    @Override
    public int getItemCount() {

        return listHeroes.size();
    }

    class HeroHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView gender;
    TextView culture;
    TextView aliases;
    public HeroHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameHero);
        aliases = itemView.findViewById(R.id.aliasesHero);
        gender = itemView.findViewById(R.id.genderHero);
        culture = itemView.findViewById(R.id.cultureHero);
    }
}
}
