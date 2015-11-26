package com.stewhouse.updownseekbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Allwin-Eva on 15. 10. 16..
 */

public class UpDownSeekBar extends RelativeLayout implements View.OnTouchListener {

    private static final String INDICATOR_VIEW_GROUP_TAG = "INDICATOR_VIEW_GROUP_TAG";

    private UpDownSeekBarListener _listener;

    private int _progress;
    private int _maxProgress;
    private int _minProgress;

    private RelativeLayout _seekBarView;
    private LayoutParams _seekBarViewParams;
    private int _seekBarViewWidth;

    private RelativeLayout _maxIndicatorView;
    private LayoutParams _maxIndicatorViewParams;
    private int _maxIndicatorViewWidth;
    private int _maxIndicatorViewHeight;

    private RelativeLayout _minIndicatorView;
    private LayoutParams _minIndicatorViewParams;
    private int _minIndicatorViewWidth;
    private int _minIndicatorViewHeight;

    private RelativeLayout _indicatorViewGroup;
    private LayoutParams _indicatorViewGroupParams;

    private RelativeLayout _indicatorView;
    private LayoutParams _indicatorViewParams;
    private int _indicatorViewWidth;
    private int _indicatorViewHeight;

    private RelativeLayout _indicatorDetailView;
    private LayoutParams _indicatorDetailViewParams;
    private int _indicatorDetailViewWidth;
    private int _indicatorDetailViewHeight;

    public UpDownSeekBar(Context context) {
        super(context);

        initialize();
    }

    public UpDownSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        initialize();
    }

    public UpDownSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    private void initialize() {
        _listener = null;

        _progress = -1;
        _maxProgress = -1;
        _minProgress = -1;

        _seekBarView = null;
        _seekBarViewParams = null;
        _seekBarViewWidth = -1;

        _maxIndicatorView = null;
        _maxIndicatorViewParams = null;
        _maxIndicatorViewWidth = -1;
        _maxIndicatorViewHeight = -1;

        _minIndicatorView = null;
        _minIndicatorViewParams = null;
        _minIndicatorViewWidth = -1;
        _minIndicatorViewHeight = -1;

        _indicatorViewGroup = null;
        _indicatorViewGroupParams = null;

        _indicatorView = null;
        _indicatorViewParams = null;
        _indicatorViewWidth = -1;
        _indicatorViewHeight = -1;

        _indicatorDetailView = null;
        _indicatorDetailViewParams = null;
        _indicatorDetailViewWidth = -1;
        _indicatorDetailViewHeight = -1;
    }

    public void setListener(UpDownSeekBarListener listener) {
        _listener = listener;
    }

    public void setMaxProgress(int maxProgress) {
        _maxProgress = maxProgress;
    }

    public void setMinProgress(int minProgress) {
        _minProgress = minProgress;
    }

    public void setSeekBarViewWidth(int seekBarViewWidth) {
        _seekBarViewWidth = seekBarViewWidth;
    }

    public void setMaxIndicatorViewWidth(int maxIndicatorViewWidth) {
        _maxIndicatorViewWidth = maxIndicatorViewWidth;
    }

    public void setMaxIndicatorViewHeight(int maxIndicatorViewHeight) {
        _maxIndicatorViewHeight = maxIndicatorViewHeight;
    }

    public void setMinIndicatorViewWidth(int minIndicatorViewWidth) {
        _minIndicatorViewWidth = minIndicatorViewWidth;
    }

    public void setMinIndicatorViewHeight(int minIndicatorViewHeight) {
        _minIndicatorViewHeight = minIndicatorViewHeight;
    }

    public void setIndicatorViewWidth(int indicatorViewWidth) {
        _indicatorViewWidth = indicatorViewWidth;
    }

    public void setIndicatorViewHeight(int indicatorViewHeight) {
        _indicatorViewHeight = indicatorViewHeight;
    }

    public void setIndicatorDetailViewWidth(int indicatorDetailViewWidth) {
        _indicatorDetailViewWidth = indicatorDetailViewWidth;
    }

    public void setIndicatorDetailViewHeight(int indicatorDetailViewHeight) {
        _indicatorDetailViewHeight = indicatorDetailViewHeight;
    }

    public int getProgress() {
        return _progress;
    }

    public RelativeLayout getIndicatorDetailView() {
        return _indicatorDetailView;
    }

    public void setProgress(int progress) {
        setViews();

        int progressCalculate = (int) ((getMeasuredHeight() - _indicatorDetailViewHeight) * (float)(progress / (float)(_maxProgress - _minProgress)));
        int h = getMeasuredHeight();
        _indicatorViewGroupParams.setMargins(0, (getMeasuredHeight() - _indicatorDetailViewHeight) - progressCalculate, 0, 0);
        _progress = progress;
        _listener.progressChanged(_progress);

        _seekBarView.setLayoutParams(_seekBarViewParams);
        _seekBarView.setBackgroundColor(Color.MAGENTA);
        _maxIndicatorView.setBackgroundColor(Color.GREEN);
        _maxIndicatorView.setLayoutParams(_maxIndicatorViewParams);
        _minIndicatorView.setBackgroundColor(Color.WHITE);
        _minIndicatorView.setLayoutParams(_minIndicatorViewParams);
        _indicatorViewGroup.setLayoutParams(_indicatorViewGroupParams);
        _indicatorDetailView.setLayoutParams(_indicatorDetailViewParams);
        _indicatorView.setBackgroundColor(Color.GRAY);
        _indicatorView.setLayoutParams(_indicatorViewParams);

        invalidate();
    }

    private void setViews() {
        if (_seekBarView == null) {
            _seekBarView = new RelativeLayout(getContext());
            addView(_seekBarView);
        }
        if (_seekBarViewParams == null) {
            _seekBarViewParams = new LayoutParams(_seekBarViewWidth, getMeasuredHeight() - ((_indicatorDetailViewHeight / 2) - (_maxIndicatorViewHeight / 2)) - ((_indicatorDetailViewHeight / 2) - (_minIndicatorViewHeight / 2)) - (_maxIndicatorViewHeight / 2) - (_minIndicatorViewHeight / 2));
            _seekBarViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            _seekBarViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            _seekBarViewParams.setMargins(0, (_indicatorDetailViewHeight / 2), _indicatorDetailViewWidth + (_indicatorViewWidth / 2) - (_seekBarViewWidth / 2), 0);
        }
        if (_maxIndicatorView == null) {
            _maxIndicatorView = new RelativeLayout(getContext());
            addView(_maxIndicatorView);
        }
        if (_maxIndicatorViewParams == null) {
            _maxIndicatorViewParams = new LayoutParams(_maxIndicatorViewWidth, _maxIndicatorViewHeight);
            _maxIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            _maxIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            _maxIndicatorViewParams.setMargins(0, (_indicatorDetailViewHeight / 2) - (_maxIndicatorViewHeight / 2), _indicatorDetailViewWidth + ((_indicatorViewWidth - _maxIndicatorViewWidth) / 2), 0);
        }
        if (_minIndicatorView == null) {
            _minIndicatorView = new RelativeLayout(getContext());
            addView(_minIndicatorView);
        }
        if (_minIndicatorViewParams == null) {
            _minIndicatorViewParams = new LayoutParams(_minIndicatorViewWidth, _minIndicatorViewHeight);
            _minIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            _minIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            _minIndicatorViewParams.setMargins(0, 0, _indicatorDetailViewWidth + ((_indicatorViewWidth - _minIndicatorViewWidth) / 2), (_indicatorDetailViewHeight / 2) - (_minIndicatorViewHeight / 2));
        }
        if (_indicatorViewGroup == null) {
            _indicatorViewGroup = new RelativeLayout(getContext());
            _indicatorViewGroup.setTag(INDICATOR_VIEW_GROUP_TAG);
            _indicatorViewGroup.setOnTouchListener(this);
            addView(_indicatorViewGroup);
        }
        if (_indicatorViewGroupParams == null) {
            _indicatorViewGroupParams = new LayoutParams(_indicatorViewWidth + _indicatorDetailViewWidth, _indicatorDetailViewHeight);
            _indicatorViewGroupParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        }
        if (_indicatorDetailView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.detail_view, null);
            _indicatorDetailView = (RelativeLayout) layout.findViewById(R.id.detailView);
            _indicatorDetailView.setOnTouchListener(this);
            _indicatorDetailView.setId(R.id.indicatorDetailView);
            _indicatorViewGroup.addView(_indicatorDetailView);
        }
        if (_indicatorDetailViewParams == null) {
            _indicatorDetailViewParams = new LayoutParams(_indicatorDetailViewWidth, _indicatorDetailViewHeight);
            _indicatorDetailViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            _indicatorDetailViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        }
        if (_indicatorView == null) {
            _indicatorView = new RelativeLayout(getContext());
            _indicatorView.setOnTouchListener(this);
            _indicatorView.setId(R.id.indicatorView);
            _indicatorViewGroup.addView(_indicatorView);
        }
        if (_indicatorViewParams == null) {
            _indicatorViewParams = new LayoutParams(_indicatorViewWidth, _indicatorViewHeight);
            _indicatorViewParams.addRule(RelativeLayout.LEFT_OF, _indicatorDetailView.getId());
            _indicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            _indicatorViewParams.setMargins(0, (_indicatorDetailViewHeight / 2) - (_indicatorViewHeight / 2), 0, 0);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getTag() == _indicatorViewGroup.getTag()) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    DisplayMetrics display = getResources().getDisplayMetrics();
                    int displayHeight = display.heightPixels;
                    int marginTop = (int) (getMeasuredHeight() * (event.getRawY() - _indicatorDetailViewHeight) / displayHeight);
                    if (marginTop < getMeasuredHeight() - _indicatorDetailViewHeight && !(marginTop < 0)) {
                        _indicatorViewGroupParams.setMargins(0, marginTop, 0, 0);
                        _indicatorViewGroup.setLayoutParams(_indicatorViewGroupParams);
                        float heightCalculate = (float)marginTop / (float)(getMeasuredHeight() - _indicatorDetailViewHeight);
                        setProgress(_maxProgress - (int) (heightCalculate * (_maxProgress - _minProgress)));
                    }
                    break;
            }
        } else {
            return false;
        }
        return true;
    }
}