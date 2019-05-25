package com.example.notes1;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView;

        // Initializing list view with the custom adapter
        ArrayList<ClipData.Item> noteList = new ArrayList<ClipData.Item>();

        noteListAdapter adapter = new noteListAdapter(R.layout.notelist_row, noteList);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // Populating list items
        for(int i=1; i<=20; i++) {
            noteList.add(new ClipData.Item("Note " + i));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popupmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.one:
                Toast.makeText(this, "Do you want to create a folder?", Toast.LENGTH_LONG).show();
                return true;
            case R.id.two:
                Toast.makeText(this, "Do you want to remove a folder?", Toast.LENGTH_LONG).show();
                return true;
            case R.id.three:
                Toast.makeText(this, "Do you want to share this note?", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
