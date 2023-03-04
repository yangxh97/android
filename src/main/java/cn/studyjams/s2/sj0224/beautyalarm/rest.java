package cn.studyjams.s2.sj0224.beautyalarm;

/**
 * Created by Administrator on 2017/6/10.
 */

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.beautyalarm.R;

/**
 * Created by Administrator on 2017/6/8.
 */

public class rest extends AppCompatActivity implements View.OnClickListener {

    private Button play;

    private Button pause;



    MediaPlayer mediaSong;
    @Override

    protected void
    onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.rest);

        play = (Button) findViewById(R.id.buttonPlay);

        pause = (Button) findViewById(R.id.buttonPause);

        play.setOnClickListener(this); pause.setOnClickListener(this);

        // 初始化MediaPlayer
        try {
            mediaSong= MediaPlayer.create(this, R.raw.fengyue);
            mediaSong.prepare(); // 让MediaPlayer进入到准备状态


        } catch (Exception e) {

            e.printStackTrace();

        }
    }



    @Override

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonPlay:
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(50);

                if (!mediaSong.isPlaying()) {

                    mediaSong.start(); // 开始播放

                }

                break;

            case R.id.buttonPause:
                Vibrator vibrator1 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator1.vibrate(50);

                if (mediaSong.isPlaying()) {

                    mediaSong.pause(); // 暂停播放

                }

                break;


            default:

                break;

        }

    }

    @Override

    protected void onDestroy() {

        super.onDestroy();



        if (mediaSong != null) {

            mediaSong.stop();

            mediaSong.release();

        }

    }

}

