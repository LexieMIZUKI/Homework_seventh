package com.lexieluv.homeworkseventh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ToggleButton tb_wifi;
    private RadioGroup rg;
    private RadioButton office,meeting,visitor;
    private ImageView cat;
    private LinearLayout content_wifi;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        tb_wifi.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                if(tb_wifi.isChecked()){
                    content_wifi.setVisibility(View.VISIBLE);
                }else
                    content_wifi.setVisibility(View.GONE);
            }
        });
        rg.setOnCheckedChangeListener(new RadioButtonListener());
        getCurrentTime();
    }

    private void getCurrentTime() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);
        int day = ca.get(Calendar.DATE);
        int hour = ca.get(Calendar.HOUR);
        int minute = ca.get(Calendar.MINUTE);
        tv_time.setText("当前时间为："+year+"年"+(month+1)+"月"+day+"天"+hour+"点"+minute+"分");
    }

    private void iniView() {
        tb_wifi = findViewById(R.id.tb_wifi);
        rg = findViewById(R.id.rg);
        office =findViewById(R.id.office);
        meeting = findViewById(R.id.meeting);
        visitor = findViewById(R.id.visitor);
        cat = findViewById(R.id.cat);
        content_wifi = findViewById(R.id.content_wifi);
        tv_time = findViewById(R.id.tv_time);
    }

    class RadioButtonListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId){
                case R.id.office:
                    cat.setImageResource(R.drawable.office);
                    break;
                case R.id.meeting:
                    cat.setImageResource(R.drawable.meeting);
                    break;
                case R.id.visitor:
                    cat.setImageResource(R.drawable.visitor);
                    break;
            }
        }
    }
}
