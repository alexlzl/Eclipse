package com.minsheng.app.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 
 * 
 * @describe:drawableLeft与文本一起居中显示
 * 
 * @author:LiuZhouLiang
 * 
 * @time:2014-11-5下午6:04:53
 * 
 */

public class DrawableCenterTextView extends TextView {

	public DrawableCenterTextView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public DrawableCenterTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DrawableCenterTextView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Drawable[] drawables = getCompoundDrawables();
		if (drawables != null) {
			Drawable drawableLeft = drawables[0];
			Drawable drawableRight = drawables[2];
			if (drawableLeft != null || drawableRight != null) {
				float textWidth = getPaint().measureText(getText().toString());
				int drawablePadding = getCompoundDrawablePadding();
				int drawableWidth = 0;
				if (drawableLeft != null)
					drawableWidth = drawableLeft.getIntrinsicWidth();
				else if (drawableRight != null) {
					drawableWidth = drawableRight.getIntrinsicWidth();
				}
				float bodyWidth = textWidth + drawableWidth + drawablePadding;
				canvas.translate((getWidth() - bodyWidth) / 2, 0);
			}
		}
		super.onDraw(canvas);
	}
}