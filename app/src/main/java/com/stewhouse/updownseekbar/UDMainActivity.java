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
        _upDownSeekBar.setMaxProgress(100);
        _upDownSeekBar.setMinProgress(0);
        _upDownSeekBar.setIndicatorBGColor(Color.BLUE);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (_upDownSeekBar != null) {
            _upDownSeekBar.setProgress(50);
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
