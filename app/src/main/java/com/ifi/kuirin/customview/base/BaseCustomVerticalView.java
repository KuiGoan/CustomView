package com.ifi.kuirin.customview.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ifi.kuirin.customview.R;
import com.ifi.kuirin.customview.databinding.BaseCustomviewVerticalBinding;

/**
 * Created by KuiRin on 7/27/2017 AD.
 */

public class BaseCustomVerticalView extends RelativeLayout {
    private int mTextColor;
    private int mBackground;
    private int mTextColorPressed;
    private int mBackgroundPressed;
    private int mImageResourceId;
    private String mText;

    private TextView mTextView;
    private ImageView mImageView;
    private boolean mHasPressed;

    public BaseCustomVerticalView(Context context) {
        this(context, null);
    }

    public BaseCustomVerticalView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseCustomVerticalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init(context, attrs, defStyleAttr, 0);
        }
    }

    public BaseCustomVerticalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init(context, attrs, defStyleRes, defStyleRes);
        }
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.BaseCustomVerticalView, defStyleAttr, defStyleRes);
        try {
            mHasPressed = a.getBoolean(R.styleable.BaseCustomVerticalView_hasPressed, false);
            mText = a.getString(R.styleable.BaseCustomVerticalView_text);
            mImageResourceId = a.getResourceId(R.styleable.BaseCustomVerticalView_imageResource, -1);
            mTextColor = a.getResourceId(R.styleable.BaseCustomVerticalView_textColor, -1);
            mBackground = a.getResourceId(R.styleable.BaseCustomVerticalView_backgroundNormal, -1);
            mTextColorPressed = a.getResourceId(R.styleable.BaseCustomVerticalView_textColorPressed, -1);
            mBackgroundPressed = a.getResourceId(R.styleable.BaseCustomVerticalView_backgroundPressed, -1);
            initView();
        } finally {
            a.recycle();
        }
    }

    private void initView() {
        BaseCustomviewVerticalBinding mBinding = DataBindingUtil.inflate(LayoutInflater
                .from(getContext()), R.layout.base_customview_vertical, this, true);
        mTextView = mBinding.textItem;
        mImageView = mBinding.imageItem;
        Log.d("base_custom_view", "#mTextView = " + mTextView);
        Log.d("base_custom_view", "#mImageView = " + mImageView);

        Log.d("base_custom_view", "#mText = " + mText);
        Log.d("base_custom_view", "#mTextColor = " + mTextColor);
        Log.d("base_custom_view", "#mBackground = " + mBackground);
        Log.d("base_custom_view", "#mImageResourceId = " + mImageResourceId);
        if (mImageView != null && mImageResourceId != -1) {
            mImageView.setBackgroundResource(mImageResourceId);
        }
        if (mTextView != null) {
            mTextView.setText(mText);
        }
        setViewHasPress(mHasPressed);
    }


    public void setViewHasPress(boolean viewHasPress) {
        this.mHasPressed = viewHasPress;
        if (mHasPressed) {
            if (mTextColor != -1) {
                mTextView.setTextColor(getResources().getColorStateList(mTextColorPressed));
            }
            if (mBackground != -1) {
                setBackgroundResource(mBackgroundPressed);
            }
        } else {
            if (mTextColor != -1) {
                mTextView.setTextColor(getResources().getColorStateList(mTextColor));
            }
            if (mBackground != -1) {
                setBackgroundResource(mBackground);
            }
        }
    }
}
