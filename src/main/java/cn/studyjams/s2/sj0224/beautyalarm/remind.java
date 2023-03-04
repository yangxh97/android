package cn.studyjams.s2.sj0224.beautyalarm;

/**
 * Created by Administrator on 2017/6/10.
 */

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.administrator.beautyalarm.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/6/6.
 */

public class remind extends AppCompatActivity {

    AlarmManager alarmManager;
    TimePicker alarmTimePicker;
    TextView update_text;
    Context context;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remind);

        this.context=this;

        alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

        alarmTimePicker=(TimePicker)findViewById(R.id.alarmTimePicker) ;
//
        update_text=(TextView) findViewById(R.id.textView);

        final Calendar calender= Calendar.getInstance();

        final Intent myIntent=new Intent(remind.this,AlarmReceiver.class);

        Button alarmOn=(Button)findViewById(R.id.alarmOn) ;

        alarmOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calender.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getHour());
                calender.set(Calendar.MINUTE,alarmTimePicker.getMinute());

                int hour=alarmTimePicker.getHour();
                int minute=alarmTimePicker.getMinute();
//时间获取
                String Hour=String.valueOf(hour);
                String Minute=String.valueOf(minute);

                if (hour>12){
                    Hour=String.valueOf(hour-12);
                }

                if (minute<10){
                    Minute="0"+String.valueOf(minute);
                }

                setAlarmText("alarm set to  "+Hour+":"+Minute);

                myIntent.putExtra("extra","alarm on");

                pendingIntent=PendingIntent.getBroadcast(remind.this,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(),pendingIntent);


            }

        });

        Button alarmOff=(Button)findViewById(R.id.alarmOff);

//按钮监听器

        alarmOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmText("alarm off");

                alarmManager.cancel(pendingIntent);

                myIntent.putExtra("extra","alarm off");

                sendBroadcast(myIntent);
            }
        });

    }

    private void setAlarmText(String outPut) {
        update_text.setText(outPut);
    }



}
