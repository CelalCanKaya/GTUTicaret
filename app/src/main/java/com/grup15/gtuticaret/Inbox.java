package com.grup15.gtuticaret;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Inbox extends AppCompatActivity {
    private ListView listView;
    //deneme amacli bi class ve array
    private ArrayList<Deneme> deneme_arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        listView = findViewById(R.id.list_inbox);
        //tikladiginde chat ekrani aciliyor
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent chat = new Intent(getApplicationContext(), Chat.class);
                startActivity(chat);
            }
        });
        
        deneme_arr = new ArrayList<>();
        deneme_arr.add(new Deneme("Tarik Kilic","kaça olur bu ürün"));
        deneme_arr.add(new Deneme("Ramazan guvenc","altın mı lan bu fiyat ne"));
        deneme_arr.add(new Deneme("Celal Can kaya","Uyudun mu cevap ver imcici uyumaz"));

        CustomAdapter adapter = new CustomAdapter(deneme_arr);
        listView.setAdapter(adapter);

    }




    public class CustomAdapter extends BaseAdapter {
        ArrayList<Deneme> adapter_arr;

        public CustomAdapter(ArrayList<Deneme> d){
            adapter_arr = d;
        }

        @Override
        public int getCount() {
            return adapter_arr.size();
        }

        @Override
        public Object getItem(int i) {
            return adapter_arr.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.inbox_custom, null);
            TextView textView_name = view.findViewById(R.id.textView_name_inbox);
            TextView textView_des = view.findViewById(R.id.textView_description_inbox);

            textView_name.setText(adapter_arr.get(i).getName());
            textView_des.setText(adapter_arr.get(i).getDes());
            return view;
        }
    }

    public class Deneme{
        private String name;
        private String des;


        public Deneme(String name, String des) {
            this.name = name;
            this.des = des;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }


    }


}
