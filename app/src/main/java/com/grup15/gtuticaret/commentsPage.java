package com.grup15.gtuticaret;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Serkan Sorman on 09.04.2018.
 */

public class commentsPage extends AppCompatActivity {
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments);

        //Yorumlar intentle yeni activitiye aktarılır
        ArrayList<String> comments = getIntent().getStringArrayListExtra("allComments");
        Collections.reverse(comments);
        ListView mainListView =  findViewById( R.id.mainListView );
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.row,comments);
        mainListView.setAdapter( listAdapter );


        mdrawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this,mdrawerLayout,R.string.open,R.string.close);
        mdrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.Black));

        NavigationView navigation = (NavigationView) findViewById(R.id.toolbar);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navigation_menu:
                        Intent menu = new Intent(commentsPage.this, AnaEkran.class);
                        startActivity(menu);
                        finish();
                        break;
                    case R.id.navigation_account:
                        Intent hesap = new Intent(commentsPage.this, Hesabim.class);
                        startActivity(hesap);
                        finish();
                        break;
                    case R.id.navigation_categories:
                        Intent kategori = new Intent(commentsPage.this, Categories.class);
                        startActivity(kategori);
                        finish();
                        break;
                    case R.id.navigation_setting:
                        Intent ayarlar = new Intent(commentsPage.this, Ayarlar.class);
                        startActivity(ayarlar);
                        finish();
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.basketmenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        switch(item.getItemId()) {
            case R.id.basket:
                Intent i = new Intent(this, Sepet.class);
                startActivity(i);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
