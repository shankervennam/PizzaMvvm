package com.example.ivc17088adm.pizzamvvm.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ivc17088adm.pizzamvvm.R;
import com.example.ivc17088adm.pizzamvvm.databinding.RecyclerViewDisplayBinding;
import com.example.ivc17088adm.pizzamvvm.model.Result;
import com.example.ivc17088adm.pizzamvvm.viewmodel.DataItemViewModel;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaAdapterViewHolder> {

    private List<Result> results;

    public PizzaAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public PizzaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewDisplayBinding recyclerViewDisplayBinding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_view_display,
                        parent, false);

        return new PizzaAdapterViewHolder(recyclerViewDisplayBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapterViewHolder holder, int position) {
        holder.bind(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class PizzaAdapterViewHolder extends RecyclerView.ViewHolder {

        RecyclerViewDisplayBinding recyclerViewDisplayBinding;

        private PizzaAdapterViewHolder(RecyclerViewDisplayBinding recyclerViewDisplayBinding) {
            super(recyclerViewDisplayBinding.getRoot());
            this.recyclerViewDisplayBinding = recyclerViewDisplayBinding;
        }

        private void bind(Result result) {
            if (recyclerViewDisplayBinding.getItemViewModel() == null) {
                recyclerViewDisplayBinding.setItemViewModel(new DataItemViewModel(result, itemView.getContext()));
            }
            if (recyclerViewDisplayBinding.getItemViewModel() == null) {
                recyclerViewDisplayBinding.setItemViewModel(new DataItemViewModel(result, itemView.getContext()));
            }
        }
    }
}
