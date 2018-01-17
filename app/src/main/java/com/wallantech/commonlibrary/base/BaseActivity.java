package com.wallantech.commonlibrary.base;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wallantech.commonlibrary.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        this.barBack = this.findViewById(id.barBack);
        if(!EmptyUtils.isEmpty(this.barBack)) {
            this.barBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    BaseActivity.this.finish();
                }
            });
        }

        this.barTitle = (TextView)this.findViewById(id.barTitle);
        this.ivBarBack = (ImageView)this.findViewById(id.iv_bar_back);
        this.toolbar = (Toolbar)this.findViewById(id.toolbar);
        if(this.toolbar != null) {
            this.toolbar.setTitle("");
            this.setSupportActionBar(this.toolbar);
        }

        this.loadingDialogManager = new LoadingDialogManager(this);
        ButterKnife.bind(this);
    }

    public void showError(){

    }

    public BaseApplication getBaseApplication() {
        Application application = this.getApplication();
        if(application instanceof BaseApplication) {
            return (BaseApplication)application;
        } else {
            throw new RuntimeException("App Application must extends BaseApplication");
        }
    }

}
