package com.example.gautamnarayanan.practice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;

public class itemtext extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemtext);
        EditText Gtext1 = (EditText)findViewById(R.id.Gtext1);
        Bundle maindata = getIntent().getExtras();
        if(maindata==null)
        {return;}
        String itemvalue = maindata.getString("itemname");
        Gtext1.setText(itemvalue);
        Gtext1.setEnabled(false);

    }
}
