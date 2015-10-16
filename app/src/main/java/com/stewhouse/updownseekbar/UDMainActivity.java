package com.stewhouse.updownseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

public class UDMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SeekBar defaultSeekBar;

        defaultSeekBar = (SeekBar) findViewById(R.id.defalutSeekBar);
        if (defaultSeekBar != null) {
            defaultSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    // Get progress.
                    Log.e("onProgressChanged", "PROGRESS: " + progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                    // 선택 막대를 터치하고 드래그를 시작할 때 실행되는 메서드.
                    Log.e("onStartTrackingTouch", "DRAGGING");
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                    // 선택을 완료했을 때 표시하는 메서드.
                    Log.e("onStopTrackingTouch", "DRAGGING COMPLETE");
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
