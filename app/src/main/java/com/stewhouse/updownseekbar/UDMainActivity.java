package com.stewhouse.updownseekbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

public class UDMainActivity extends AppCompatActivity {

    private UpDownSeekBar _upDownSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _upDownSeekBar = (UpDownSeekBar) findViewById(R.id.seekBar);
        _upDownSeekBar.setIndicatorViewWidth(80);
        _upDownSeekBar.setIndicatorViewHeight(80);
        _upDownSeekBar.setIndicatorDetailViewWidth(300);
        _upDownSeekBar.setIndicatorDetailViewHeight(300);
        _upDownSeekBar.setMinIndicatorViewWidth(60);
        _upDownSeekBar.setMinIndicatorViewHeight(60);
        _upDownSeekBar.setMaxIndicatorViewWidth(60);
        _upDownSeekBar.setMaxIndicatorViewHeight(60);
        _upDownSeekBar.setSeekBarViewWidth(20);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        _upDownSeekBar.setProgress(10);
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
