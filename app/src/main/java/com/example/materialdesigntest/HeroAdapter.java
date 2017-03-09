package com.example.materialdesigntest;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 鲍骞月 on 2017/3/9.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private List<Hero> mHeroList;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        /**
         * ViewHolder的构造函数中，我们传入了一个view参数，这个参数通常就是RecyclerView子项的
         * 最外层布局，然后就可以通过这个view将布局中的控件加载进来
         *
         * @param itemView
         */

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = (ImageView) itemView.findViewById(R.id.hezo_image);
            textView = (TextView) itemView.findViewById(R.id.hezo_name);
        }
    }

    /**
     * HeroAdapter的构造参数中，将用于显示的数据源赋给一个全局变量mHeroList，
     * 之后的都在这个数据源上进行
     *
     * @param heros
     */
    public HeroAdapter(List<Hero> heros) {
        mHeroList = heros;

    }

    /**
     * 这个方法用来创造ViewHolder实例，在这个方法中将RecyclerView的子项布局item加载进来
     * 然后将ViewHolder的实例返回
     *
     * @param parent
     * @param viewType
     * @return
     */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.hero_item,
                parent, false);
        return new ViewHolder(view);
    }

    /**
     * 这个方法用来给RecyclerView的子项数据进行赋值，我们通过position参数得到当前项的实例，
     * 就可以将数据设置入ImageView或其他控件中了
     *
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hero hero = mHeroList.get(position);
        holder.textView.setText(hero.getName());
        //这里调用了Glide中with()方法来加载图片，需要一个Context,Activity或Fragment参数，
        //load()中需要url参数，into()将图片加载到一个具体的位置
        Glide.with(mContext).load(hero.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mHeroList.size();
    }
}
