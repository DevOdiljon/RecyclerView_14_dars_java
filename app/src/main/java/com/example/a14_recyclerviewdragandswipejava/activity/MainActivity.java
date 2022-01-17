package com.example.a14_recyclerviewdragandswipejava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a14_recyclerviewdragandswipejava.R;
import com.example.a14_recyclerviewdragandswipejava.adapter.CustomAdapter;
import com.example.a14_recyclerviewdragandswipejava.helper.ItemTouchHelperAdapter;
import com.example.a14_recyclerviewdragandswipejava.helper.SimpleItemTouchHelperCallback;
import com.example.a14_recyclerviewdragandswipejava.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        List<Member> members = prepareMember();
        refreshAdapter(members);
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter =  new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private List<Member> prepareMember() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 60; i++){
            members.add(new Member("Odilbek " + i, "+998-97-775-17-79"));
        }
        return members;
    }

    void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }
}