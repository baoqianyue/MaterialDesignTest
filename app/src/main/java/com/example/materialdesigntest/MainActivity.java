package com.example.materialdesigntest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity{
    //定义侧滑栏
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_view);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        }
        /**
         * 为NavigationView的头部View设置点击事件
         */
        View headView = navView.getHeaderView(0);
        //然后调用headView中findViewById()方法找到控件，设置点击事件
        de.hdodenhof.circleimageview.CircleImageView mImage =
                (CircleImageView) findViewById(R.id.nav_me);
        TextView tvUsername = (TextView) findViewById(R.id.username);
        TextView tvMail = (TextView) findViewById(R.id.mail);
        //......
        navView.setCheckedItem(R.id.nav_me);//这里将菜单中的第一个item设为默认选中
        //为菜单中的每一项设置点击事件
        navView.setNavigationItemSelectedListener(new NavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;//将toolbar菜单加载，在onOptionsItemSelected()中处理按钮的点击事件
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(MainActivity.this, "Back up", Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }

}
