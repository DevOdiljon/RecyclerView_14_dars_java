package com.example.a14_recyclerviewdragandswipejava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a14_recyclerviewdragandswipejava.R;
import com.example.a14_recyclerviewdragandswipejava.helper.ItemTouchHelperAdapter;
import com.example.a14_recyclerviewdragandswipejava.model.Member;

import java.util.Collections;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {
    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_activity_view, parent, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof CustomHolder){
                TextView tv_name = ((CustomHolder) holder).tv_name;
                TextView tv_tel_name = ((CustomHolder) holder).tv_tel_number;

                tv_name.setText(member.getTv_name());
                tv_tel_name.setText(member.getTv_tel_number());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition){
            for (int i = fromPosition; i < toPosition; i++){
                Collections.swap(members, i, i+1);
            }
        }else {
            for (int i = fromPosition; i < toPosition; i--){
                Collections.swap(members, i, i-1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        members.remove(position);
        notifyItemRemoved(position);
    }

    private class CustomHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView tv_name;
        private TextView tv_tel_number;

        public CustomHolder(View v) {
            super(v);
            view = v;

            tv_name = view.findViewById(R.id.tv_name);
            tv_tel_number = view.findViewById(R.id.tv_tel_number);
        }
    }
}
