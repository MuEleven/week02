package com.bw.dukaibin1111.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class BaseP <P extends RecyclerView.ViewHolder> extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
