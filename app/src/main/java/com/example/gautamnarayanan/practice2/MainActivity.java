package com.example.gautamnarayanan.practice2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.RelativeLayout;
import java.util.StringTokenizer;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends Activity {

    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adpter;
    Button Gbutton,Gbutton2;
    ListView Glist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            list=savedInstanceState.getStringArrayList("MyList");
            if(list!=null)
            {
                adpter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
            }
        }
        else
        {adpter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);}
        Gbutton = (Button)findViewById(R.id.gbutton);
        Gbutton2=(Button)findViewById(R.id.Gbutton2);
        final EditText Gtext = (EditText)findViewById(R.id.gtext);
        final EditText Gtext2 = (EditText)findViewById(R.id.gtext2);
        Glist = (ListView)findViewById(R.id.glist);
        RelativeLayout glayout = (RelativeLayout)findViewById(R.id.glayout);

        Glist.setAdapter(adpter);
        Gbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        String input = Gtext.getText().toString();
                        if(input.length()>0)
                        {
                            adpter.add(input);
                            Gtext.setText(null);


                        }
                    }
                }
        );

        Gbutton2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {

                        String position = Gtext2.getText().toString();
                        if (position.length() > 0) {
                            int pos = Integer.parseInt(position);
                            int first,last;
                            first=Glist.getFirstVisiblePosition();
                            last=Glist.getLastVisiblePosition();
                            if(pos-1<first||pos-1>last)
                            {Toast.makeText(MainActivity.this,"No item at this position",Toast.LENGTH_LONG).show();}
                            else
                            {String item = adpter.getItem(pos - 1);
                            adpter.remove(item);}

                        }
                    }
                }
        );

        Glist.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(MainActivity.this,itemtext.class);
                        String item = Glist.getItemAtPosition(position).toString();
                        i.putExtra("itemname",item);
                        startActivity(i);
                    }
                }

        );


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("MyList",list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
