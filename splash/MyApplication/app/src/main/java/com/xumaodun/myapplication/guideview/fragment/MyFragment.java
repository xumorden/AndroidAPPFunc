package com.xumaodun.myapplication.guideview.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.xumaodun.myapplication.R;
import com.xumaodun.myapplication.guideview.component.MutiComponent;
import com.xumaodun.myapplication.guideview.ui.Guide;
import com.xumaodun.myapplication.guideview.ui.GuideBuilder;


public class MyFragment extends Fragment {
  private LinearLayout ll_nearby;
  Guide guide;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_simple_guide_view, container, false);
    ll_nearby = (LinearLayout) view.findViewById(R.id.ll_nearby);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getActivity().getWindow()
        .getDecorView()
        .getViewTreeObserver()
        .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
          @Override
          public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
              getActivity().getWindow()
                  .getDecorView()
                  .getViewTreeObserver()
                  .removeOnGlobalLayoutListener(this);
            } else {
              getActivity().getWindow()
                  .getDecorView()
                  .getViewTreeObserver()
                  .removeGlobalOnLayoutListener(this);
            }
            showGuideView();
          }
        });
  }

  public void showGuideView() {
    GuideBuilder builder = new GuideBuilder();
    builder.setTargetView(ll_nearby)
        .setAlpha(150)
        .setHighTargetCorner(20)
        .setHighTargetPadding(10)
        .setOverlayTarget(false)
        .setOutsideTouchable(false);
    builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
      @Override
      public void onShown() {
      }

      @Override
      public void onDismiss() {
      }
    });

    builder.addComponent(new MutiComponent());
    guide = builder.createGuide();
    guide.setShouldCheckLocInWindow(true);
    guide.show(getActivity());
  }
}
