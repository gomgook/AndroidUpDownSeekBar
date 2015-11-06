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

    private RelativeLayout _seekBarView;
    private LayoutParams _seekBarViewParams;
    private int _seekBarViewWidth;

    private RelativeLayout _minIndicatorView;
    private LayoutParams _minIndicatorViewParams;
    private int _minIndicatorViewWidth;
    private int _minIndicatorViewHeight;

    private RelativeLayout _maxIndicatorView;
    private LayoutParams _maxIndicatorViewParams;
    private int _maxIndicatorViewWidth;
    private int _maxIndicatorViewHeight;

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

    private RelativeLayout _indicatorBGView;
    private LayoutParams _indicatorBGViewParams;

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
        _seekBarView = null;
        _seekBarViewParams = null;
        _seekBarViewWidth = -1;

        _minIndicatorView = null;
        _minIndicatorViewParams = null;
        _minIndicatorViewWidth = -1;
        _minIndicatorViewHeight = -1;

        _maxIndicatorView = null;
        _maxIndicatorViewParams = null;
        _maxIndicatorViewWidth = -1;
        _maxIndicatorViewHeight = -1;

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

        _indicatorBGView = null;
        _indicatorBGViewParams = null;
    }

    public void setSeekBarViewWidth(int seekBarViewWidth) {
        _seekBarViewWidth = seekBarViewWidth;
    }

    public void setMinIndicatorViewWidth(int minIndicatorViewWidth) {
        _minIndicatorViewWidth = minIndicatorViewWidth;
    }

    public void setMinIndicatorViewHeight(int minIndicatorViewHeight) {
        _minIndicatorViewHeight = minIndicatorViewHeight;
    }

    public void setMaxIndicatorViewWidth(int maxIndicatorViewWidth) {
        _maxIndicatorViewWidth = maxIndicatorViewWidth;
    }

    public void setMaxIndicatorViewHeight(int maxIndicatorViewHeight) {
        _maxIndicatorViewHeight = maxIndicatorViewHeight;
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

    public void setProgress(int progress) {
        if (_seekBarView == null) {
            _seekBarView = new RelativeLayout(getContext());
            addView(_seekBarView);
        }
        if (_seekBarViewParams == null) {
            _seekBarViewParams = new LayoutParams(_seekBarViewWidth, getMeasuredHeight() - ((_indicatorDetailViewHeight / 2) - (_minIndicatorViewHeight / 2)) - ((_indicatorDetailViewHeight / 2) - (_maxIndicatorViewHeight / 2)) - (_minIndicatorViewHeight / 2) - (_maxIndicatorViewHeight / 2));
            _seekBarViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            _seekBarViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            _seekBarViewParams.setMargins(0, (_indicatorDetailViewHeight / 2), _indicatorDetailViewWidth + (_indicatorViewWidth / 2) - (_seekBarViewWidth / 2), 0);
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
        if (_maxIndicatorView == null) {
            _maxIndicatorView = new RelativeLayout(getContext());
            addView(_maxIndicatorView);
        }
        if (_maxIndicatorViewParams == null) {
            _maxIndicatorViewParams = new LayoutParams(_maxIndicatorViewWidth, _maxIndicatorViewHeight);
            _maxIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            _maxIndicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            _maxIndicatorViewParams.setMargins(0, 0, _indicatorDetailViewWidth + ((_indicatorViewWidth - _maxIndicatorViewWidth) / 2), (_indicatorDetailViewHeight / 2) - (_maxIndicatorViewHeight / 2));
        }
        if (_indicatorViewGroup == null) {
            _indicatorViewGroup = new RelativeLayout(getContext());
            addView(_indicatorViewGroup);
        }
        if (_indicatorViewGroupParams == null) {
            _indicatorViewGroupParams = new LayoutParams(_indicatorViewWidth + _indicatorDetailViewWidth, ViewGroup.LayoutParams.MATCH_PARENT);
            _indicatorViewGroupParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            _indicatorViewGroupParams.setMargins(0, 10, 0, 0);
        }
        if (_indicatorDetailView == null) {
            _indicatorDetailView = new RelativeLayout(getContext());
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
            _indicatorView.setId(R.id.indicatorView);
            _indicatorViewGroup.addView(_indicatorView);
        }
        if (_indicatorViewParams == null) {
            _indicatorViewParams = new LayoutParams(_indicatorViewWidth, _indicatorViewHeight);
            _indicatorViewParams.addRule(RelativeLayout.LEFT_OF, _indicatorDetailView.getId());
            _indicatorViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            _indicatorViewParams.setMargins(0, (_indicatorDetailViewHeight / 2) - (_indicatorViewHeight / 2), 0, 0);
        }
        if (_indicatorBGView == null) {
            _indicatorBGView = new RelativeLayout(getContext());
            _indicatorViewGroup.addView(_indicatorBGView);
        }
        if (_indicatorBGViewParams == null) {
            _indicatorBGViewParams = new LayoutParams(_seekBarViewWidth, getMeasuredHeight());
            _indicatorBGViewParams.addRule(RelativeLayout.ALIGN_LEFT, _indicatorView.getId());
            _indicatorBGViewParams.addRule(RelativeLayout.BELOW, _indicatorView.getId());
            _indicatorBGViewParams.setMargins((_indicatorViewWidth / 2) - (_seekBarViewWidth / 2), 0, 0, 0);
        }

        _seekBarView.setLayoutParams(_seekBarViewParams);
        _seekBarView.setBackgroundColor(Color.MAGENTA);
        _minIndicatorView.setBackgroundColor(Color.GREEN);
        _minIndicatorView.setLayoutParams(_minIndicatorViewParams);
        _maxIndicatorView.setBackgroundColor(Color.GREEN);
        _maxIndicatorView.setLayoutParams(_maxIndicatorViewParams);
        _indicatorViewGroup.setLayoutParams(_indicatorViewGroupParams);
        _indicatorDetailView.setBackgroundColor(Color.BLUE);
        _indicatorDetailView.setLayoutParams(_indicatorDetailViewParams);
        _indicatorView.setBackgroundColor(Color.GRAY);
        _indicatorView.setLayoutParams(_indicatorViewParams);
        _indicatorBGView.setBackgroundColor(Color.RED);
        _indicatorBGView.setLayoutParams(_indicatorBGViewParams);

        invalidate();
    }
}