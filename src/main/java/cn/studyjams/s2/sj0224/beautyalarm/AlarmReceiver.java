package cn.studyjams.s2.sj0224.beautyalarm;

/**
 * Created by Administrator on 2017/6/10.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/7.
 */

public class AlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("I am in the receiver","really");

        String getYourString=intent.getExtras().getString("extra");

        Log.e("What is the key",getYourString);

        Intent service=new Intent(context,RingtonePlayingService.class);

        service.putExtra("extra",getYourString);

        context.startService(service);

    }
}
