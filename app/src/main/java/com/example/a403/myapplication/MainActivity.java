package com.example.a403.myapplication;

import android.media.Image;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Switch s1;
    Chronometer ch1;
    LinearLayout l1;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    EditText ed1,ed2,ed3;
    ImageView iv1;
    Button btn1,btn2,btn3,btn4;
    CalendarView cv1;
    TimePicker tp1;
    TextView tv1,tv2,tv3;
    FrameLayout frame;
    String cdv,tp,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("놀이동산 예약시스템");

        s1 = (Switch)findViewById(R.id.switch1);
        ch1 = (Chronometer)findViewById(R.id.chronometer2);
        l1 = (LinearLayout)findViewById(R.id.lay11);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        ed3 = (EditText)findViewById(R.id.editText3);
        iv1 = (ImageView)findViewById(R.id.imageView);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button5);
        btn4 = (Button)findViewById(R.id.button6);
        rb4 = (RadioButton)findViewById(R.id.radioButton4);
        rb5 = (RadioButton)findViewById(R.id.radioButton5);
        cv1 = (CalendarView)findViewById(R.id.calendarView);
        tp1 = (TimePicker)findViewById(R.id.timePicker);
        tv1 = (TextView)findViewById(R.id.textView9);
        tv2 = (TextView)findViewById(R.id.textView10);
        tv3 = (TextView)findViewById(R.id.textView11);
        frame = (FrameLayout)findViewById(R.id.frame1);
        int num1,num2,num3;
        cdv = "";
        tp = "";
        date = "";

        rb1.setChecked(true);
        rb4.setChecked(true);
        frame.setVisibility(View.INVISIBLE);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    l1.setVisibility(View.VISIBLE);
                    ch1.setBase(SystemClock.elapsedRealtime());
                    ch1.start();
                }
                else
                    l1.setVisibility(View.INVISIBLE);
            }
        });
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    iv1.setImageResource(R.drawable.basic);
            }
        });
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    iv1.setImageResource(R.drawable.money);
            }
        });
        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    iv1.setImageResource(R.drawable.membership);
            }
        });
        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    cv1.setVisibility(View.VISIBLE);
                else
                    tp1.setVisibility(View.INVISIBLE);
            }
        });
        rb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    tp1.setVisibility(View.VISIBLE);
                else
                    cv1.setVisibility(View.INVISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame.setVisibility((View.VISIBLE));
                l1.setVisibility(View.INVISIBLE);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().length() ==0 || ed2.getText().length() ==0|| ed3.getText().length() ==0){
                    Toast.makeText(getApplicationContext(),"인원을 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                String num1 = ed1.getText().toString();
                String num2 = ed2.getText().toString();
                String num3 = ed3.getText().toString();
                int result1 = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);
                Double result2 = (Double.parseDouble(num1) * 15000) + ((Double.parseDouble(num2)) * 12000) + ((Double.parseDouble(num3)) * 8000);
                Double result3 = (Double.parseDouble(num1) * 15000) + ((Double.parseDouble(num2)) * 12000) + ((Double.parseDouble(num3)) * 8000);
                if(rb1.isChecked()) {
                    result2 = (Double)result2 - ((Double)result2 *0.05);
                }
                if(rb2.isChecked()) {
                    result2 = (Double)result2 - ((Double)result2 *0.1);
                }
                if(rb3.isChecked()) {
                    result2 = (Double)result2 - ((Double)result2 *0.2);
                }
                Double result4 = result3-result2;
                tv1.setText("총 명수 : "+ result1);
                tv2.setText("할인금액 :"+ result4);
                tv3.setText("결제금액 :" +result2);
            }
        });
        cv1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView cal_view, int year, int month, int day){
                cdv = year+"-"+month+"-"+day+"-";
            }
        });
        tp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hour, int minute) {
                tp = hour+":"+minute;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn1.isClickable()){
                    date = cdv+tp;
                    Toast.makeText(getApplicationContext(),date+"예약이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                    ch1.stop();
                }
                else
                    Toast.makeText(getApplicationContext(),"인원예약을 먼저하세요.",Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1.setChecked(false);
                frame.setVisibility(View.GONE);
            }
        });
    }
}
