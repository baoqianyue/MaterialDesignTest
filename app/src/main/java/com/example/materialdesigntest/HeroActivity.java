package com.example.materialdesigntest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class HeroActivity extends AppCompatActivity {
    public static final String HERO_NAME = "hero_name";
    public static final String HERO_IMAGE_ID = "hero_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        Intent intent = getIntent();
        String heroName = intent.getStringExtra(HERO_NAME);
        int heroImageId = intent.getIntExtra(HERO_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.hero_content_toolbar_view);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.hero_collapsingtoolbar);
        ImageView heroImageView = (ImageView) findViewById(R.id.hero_content_image_view);
        TextView heroContentView = (TextView) findViewById(R.id.hero_content_text_view);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(heroName);
        Glide.with(this).load(heroImageId).into(heroImageView);
        String heroContent = loadHeroContent(heroName);
        heroContentView.setText(heroContent);
    }

    private String loadHeroContent(String heroName) {
        StringBuilder heroContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            heroContent.append(heroName);
        }
        return heroContent.toString();
    }

    /**
     * 为HomeAnUp按钮设置点击事件，调用finish()方法关闭当前活动达到
     * 返回的效果
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
