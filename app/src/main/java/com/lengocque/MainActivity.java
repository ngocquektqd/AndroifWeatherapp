package com.lengocque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lengocque.adapter.ItemAdapter;
import com.lengocque.model.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewMain;
    TextView tvCnow,tvstatusNow;

    List<Item> list=new ArrayList<>();
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getdata();
        adapter =new ItemAdapter(this,list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        recyclerViewMain=findViewById(R.id.rvMain);
        recyclerViewMain.setLayoutManager(layoutManager);
        recyclerViewMain.setAdapter(adapter);
        tvCnow=findViewById(R.id.tvCnow);
        tvstatusNow=findViewById(R.id.tvstatusNow);

    }
    public void getdata(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ManagerApi.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ManagerApi apimanager=retrofit.create(ManagerApi.class);
        apimanager.getdata().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

                if(response.body()!=null){
                    list=response.body();
                    adapter.reLoadData(list);
                    response.code();
                    tvstatusNow.setText(list.get(0).getIconPhrase());
                    int Cnow= (int) list.get(0).getTemperature().getValue();
                    tvCnow.setText((Cnow+"°"));

                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {


                Toast.makeText(MainActivity.this,"Fail",Toast.LENGTH_LONG).show();
            }
        });
    }
}