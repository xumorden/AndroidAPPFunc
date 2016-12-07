package com.xumaodun.draddersample.view;

import android.support.v7.app.AppCompatActivity;

import com.xumaodun.draddersample.MyApplication;
import com.xumaodun.draddersample.injection.components.ApplicationComponent;


/**
 * Created by xumaodun on 2016/12/6.
 */
public class BaseActivity extends AppCompatActivity {
  public ApplicationComponent getApplicationComponent() {
    return ((MyApplication) getApplication()).getApplicationComponent();
  }
}
