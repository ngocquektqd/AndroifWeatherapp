package com.lengocque.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lengocque.R;
import com.lengocque.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Item> itemDataList;

    public ItemAdapter(Activity activity, List<Item> itemDataList) {
        this.activity = activity;
        this.itemDataList = itemDataList;
    }


    public void reLoadData(List<Item> list){
        this.itemDataList=list;
        this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View dataViewHolder=activity.getLayoutInflater().inflate(R.layout.item_layout,parent,false);
        ItemDataHolder holder=new ItemDataHolder(dataViewHolder);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        ItemDataHolder dataHolder= (ItemDataHolder) holder;
        Item data=itemDataList.get(position);
        dataHolder.tvTime.setText(convertTime(data.getDateTime()));

        dataHolder.tvC.setText(String.valueOf(data.getTemperature().getValue()));
        int weatherIcon=data.getWeatherIcon();
        if (weatherIcon<10){
            String urlicon="https://developer.accuweather.com/sites/default/files/0"+weatherIcon+"-s.png";
            Glide.with(activity).load(urlicon).into(dataHolder.ivIcon);
        }
        if(weatherIcon>=10){
            String urlicon="https://developer.accuweather.com/sites/default/files/"+weatherIcon+"-s.png";
            Glide.with(activity).load(urlicon).into(dataHolder.ivIcon);
        }


    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }
    public  class ItemDataHolder extends RecyclerView.ViewHolder {

    TextView tvTime,tvC;
    ImageView ivIcon;
    public ItemDataHolder(@NonNull View itemView) {
        super(itemView);
        tvTime=itemView.findViewById(R.id.tvTime);
        tvC=itemView.findViewById(R.id.tvC);
        ivIcon=itemView.findViewById(R.id.ivIcon);

    }
}

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
