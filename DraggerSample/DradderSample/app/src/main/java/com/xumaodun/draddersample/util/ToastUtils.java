package com.xumaodun.draddersample.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sll on 2016/5/19.
 */
public class ToastUtils {
  private final Context mContext;

  public ToastUtils(Context mContext) {
    this.mContext = mContext;
  }

  public void showToast(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }
}
