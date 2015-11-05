package com.stewhouse.updownseekbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Allwin-Eva on 15. 10. 16..
 */

public class UpDownSeekBar extends RelativeLayout {

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

    private RelativeLayout _minIndicatorView;
    private LayoutParams _minIndicatorViewParams;
    private int _minIndicatorViewWidth;
    private int _minIndicatorViewHeight;

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

        _minIndicatorView = null;
        _minIndicatorViewParams = null;
        _minIndicatorViewWidth = -1;
        _minIndicatorViewHeight = -1;
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

    public void setMinIndicatorViewWidth(int minIndicatorViewWidth) {
        _minIndicatorViewWidth = minIndicatorViewWidth;
    }

    public void setMinIndicatorViewHeight(int minIndicatorViewHeight) {
        _minIndicatorViewHeight = minIndicatorViewHeight;
    }

    public void setProgress(int progress) {
        if (_indicatorViewGroup == null) {
            _indicatorViewGroup = new RelativeLayout(getContext());
            addView(_indicatorViewGroup);
        }
        if (_indicatorViewGroupParams == null) {
            _indicatorViewGroupParams = new LayoutParams(_indicatorViewWidth + _indicatorDetailViewWidth, ViewGroup.LayoutParams.MATCH_PARENT);
            _indicatorViewGroupParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
//            _indicatorViewGroupParams.setMargins(0, 300, 0, 0);
        }
        if (_indicatorDetailView == null) {
            _indicatorDetailView = new RelativeLayout(getContext());
            _indicatorViewGroup.addView(_indicatorDetailView);
        }
        if (_indicatorDetailViewParams == null) {
            _indicatorDetailViewParams = new LayoutParams(_indicatorDetailViewWidth, _indicatorDetailViewHeight);
            _indicatorDetailViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            _indicatorDetailViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        }
        if (_indicatorView == null) {
            _indicatorView = new RelativeLayout(getContext());
            _indicatorViewGroup.addView(_indicatorView);
        }
        if (_indicatorViewParams == null) {
            _indicatorViewParams = new LayoutParams(_indicatorViewWidth, _indicatorViewHeight);
            _indicatorViewParams.addRule(RelativeLayout.LEFT_OF, _indicatorDetailView.getId());
            _indicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            _indicatorViewParams.setMargins(0, (_indicatorDetailViewHeight / 2) - (_indicatorViewHeight / 2), 0, 0);
        }
        if (_minIndicatorView == null) {
            _minIndicatorView = new RelativeLayout(getContext());
            addView(_minIndicatorView);
        }
        if (_minIndicatorViewParams == null) {
            _minIndicatorViewParams = new LayoutParams(_minIndicatorViewWidth, _minIndicatorViewHeight);
            _minIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            _minIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            _minIndicatorViewParams.setMargins(0, (_indicatorDetailViewHeight / 2) - (_minIndicatorViewHeight / 2), _indicatorDetailViewWidth + ((_indicatorViewWidth - _minIndicatorViewWidth) / 2), 0);
        }

        _indicatorViewGroup.setLayoutParams(_indicatorViewGroupParams);
        _indicatorDetailView.setBackgroundColor(Color.BLUE);
        _indicatorDetailView.setLayoutParams(_indicatorDetailViewParams);
        _indicatorView.setBackgroundColor(Color.GRAY);
        _indicatorView.setLayoutParams(_indicatorViewParams);
        _minIndicatorView.setBackgroundColor(Color.GREEN);
        _minIndicatorView.setLayoutParams(_minIndicatorViewParams);

        invalidate();
    }
}