package com.example.speedquiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    public EditText ET_p1;
    public EditText ET_p2;
    public TextView TV_p1;
    public TextView TV_p2;
    public Button BT_add;
    public Button BT_val;

    int counter_bt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        //setSupportActionBar(mainToolbar);

        ET_p1 = findViewById(R.id.ed_player_1);
        ET_p2 = findViewById(R.id.ed_player_2);
        TV_p1 = findViewById(R.id.tv_player_1);
        TV_p2 = findViewById(R.id.tv_player_2);
        BT_add = findViewById(R.id.bt_add);
        BT_val = findViewById(R.id.bt_val);

        ET_p1.setVisibility(View.INVISIBLE);
        ET_p2.setVisibility(View.INVISIBLE);
        TV_p1.setVisibility(View.INVISIBLE);
        TV_p2.setVisibility(View.INVISIBLE);
        BT_val.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        BT_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_player();
            }
        });

        BT_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameactivity = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameactivity);
            }
        });

        ET_p1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                BT_val.setVisibility(View.VISIBLE);
            }
        });

        ET_p2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                BT_val.setVisibility(View.VISIBLE);
            }
        });


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                System.out.println("ds");
                break;
            case R.id.action_delete:
                System.out.println("fds");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void add_player() {
        if (counter_bt < 2) {
            counter_bt++;
        }
        if (counter_bt ==1){
            ET_p1.setVisibility(View.VISIBLE);
            TV_p1.setVisibility(View.VISIBLE);
        }
        else if (counter_bt ==2){
            ET_p2.setVisibility(View.VISIBLE);
            TV_p2.setVisibility(View.VISIBLE);
        }



    }



}
