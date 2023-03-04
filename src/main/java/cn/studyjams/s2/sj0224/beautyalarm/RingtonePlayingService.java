package cn.studyjams.s2.sj0224.beautyalarm;

/**
 * Created by Administrator on 2017/6/10.
 */


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.administrator.beautyalarm.R;

/**
 * Created by Administrator on 2017/6/7.
 */

public class RingtonePlayingService extends Service {
    int startId;

    boolean isRunning;

    MediaPlayer mediaSong;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override

    public int onStartCommand(Intent intent,int flags,int startId){
        Log.e("In the service","true"+startId+intent);

        String state =intent.getExtras().getString("extra");
//震动
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(2000);


//通知栏
        NotificationManager notify_Manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent_main_activity=new Intent(this.getApplicationContext(),MainActivity.class);

        PendingIntent pendingIntentMainActivity=PendingIntent.getActivity(this,0,intent_main_activity,0);

        Notification notification_pump=new Notification.Builder(this)
                .setContentTitle("早点休息")
                .setContentText("熬夜对身体不好")
                .setContentIntent(pendingIntentMainActivity)
                .setSmallIcon(R.drawable.p)
                .setAutoCancel(true)
                .build();
        notify_Manager.notify(0,notification_pump);
//控制闹铃的开始停止

        assert state!=null;
        switch (state){
            case "alarm on":
                startId=1;
                break;
            case "alarm off":
                startId=0;
                break;
            default:
                startId=0;
                break;
        }

        return START_NOT_STICKY;
    };

    @Override
    public void onDestroy(){

        super.onDestroy();
        this.isRunning=true;

    }

}
