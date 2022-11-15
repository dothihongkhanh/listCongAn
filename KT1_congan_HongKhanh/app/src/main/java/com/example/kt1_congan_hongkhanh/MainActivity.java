package com.example.kt1_congan_hongkhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvDestination;
    ArrayList<CongAn> congAnArrayList;
    CongAnAdapter congAnAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        congAnAdapter = new CongAnAdapter(this,R.layout.list_congan, congAnArrayList);
        lvDestination.setAdapter(congAnAdapter);

        lvDestination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteSach(i);
            }
        });
    }

    private void AnhXa() {
        lvDestination = (ListView) findViewById(R.id.listviewDestination);
        congAnArrayList = new ArrayList<>();
        congAnArrayList.add(new CongAn(R.drawable.congan, "Nguyen Van A", "Trung úy","Đà Nẵng", "3 sao"));
        congAnArrayList.add(new CongAn(R.drawable.congan2, "Nguyen Van S", "Trung tá","TP Hồ Chí Minh","3 sao"));
        congAnArrayList.add(new CongAn(R.drawable.congan, "Nguyen Van D", "Trung úy", "Hà Nội","3 sao"));
        congAnArrayList.add(new CongAn(R.drawable.congan2, "Nguyen Van F", "Trung tá","Đà Nẵng", "3 sao"));
        congAnArrayList.add(new CongAn(R.drawable.congan, "Nguyen Van G", "Trung tướng","TP Hồ Chí Minh" ,"3 sao"));
        congAnArrayList.add(new CongAn(R.drawable.congan2, "Nguyen Van H", "Trung tướng","Hà Nội" ,"3 sao"));

    }


    private void deleteSach(final int position){
        new AlertDialog.Builder(this)
                .setTitle("Delete TOUR")
                .setMessage("Do you want delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        congAnArrayList.remove(position);
                        congAnAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", null)
                .show();
    }
}