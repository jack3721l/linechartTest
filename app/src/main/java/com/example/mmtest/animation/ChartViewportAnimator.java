package com.example.mmtest.animation;

import com.example.mmtest.model.Viewport;

public interface ChartViewportAnimator {

	public static final int FAST_ANIMATION_DURATION = 300;

	public void startAnimation(Viewport startViewport, Viewport targetViewport);

	public void cancelAnimation();

	public boolean isAnimationStarted();

	public void setChartAnimationListener(ChartAnimationListener animationListener);

}
