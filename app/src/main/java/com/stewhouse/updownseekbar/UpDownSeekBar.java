package com.stewhouse.updownseekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Allwin-Eva on 15. 10. 16..
 */

public class UpDownSeekBar extends RelativeLayout {

    private int _maxProgress;
    private int _minProgress;

    private RelativeLayout _indicatorBGView;
    private int _indicatorBGColor;
    private LayoutParams _indicatorBGParams;

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

    public void initialize() {
        _maxProgress = -1;
        _minProgress = -1;

        _indicatorBGView = null;
        _indicatorBGColor = -1;
        _indicatorBGParams = null;
    }

    public void setMaxProgress(int maxProgress) {
        _maxProgress = maxProgress;
    }

    public void setMinProgress(int minProgress) {
        _minProgress = minProgress;
    }

    public void setIndicatorBGColor(int indicatorBGColor) {
        _indicatorBGColor = indicatorBGColor;
    }

    public void setProgress(int progress) {
        if (_indicatorBGView == null) {
            _indicatorBGView = new RelativeLayout(getContext());
            addView(_indicatorBGView);
        }
        if (_indicatorBGParams == null) {
            _indicatorBGParams = new LayoutParams(getMeasuredWidth(), LayoutParams.MATCH_PARENT);
            _indicatorBGParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        }

        int progressCalculate = (int) (getMeasuredHeight() * (float)(progress / (float)(_maxProgress - _minProgress)));
        _indicatorBGParams.setMargins(0, getMeasuredHeight() - progressCalculate, 0, 0);
        _indicatorBGView.setBackgroundColor(_indicatorBGColor);
        _indicatorBGView.setLayoutParams(_indicatorBGParams);

        invalidate();
    }
}
