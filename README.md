# MaterialDesignTest
## Toolbar  
## 滑动菜单  
* DrawerLayout   
* NavigationView   
 * menu
 * headerLayout   

## 悬浮按钮和可交互提示     
* FloatingActionButton   
 * android:layout_gravity="bottom|end"    
 可以将按钮固定在页面右下角      
* Snackbar    
* CoordinatorLayout(一个可以监听所有子控件事件的FrameLayout)(坐标布局)    


## 卡片式布局    
* CardView   
* RecyclerView    
* AppBarLayout(一个垂直的LinearLayout,内部进行了很多滚动事件的封装)     

 * 在Toolbar外层嵌套一个AppBarLayout就可以解决滑动时遮挡Toolbar的问题    
  * app:layout_scrollFlags:"scroll|enterAlways|snap"属性     

* ViewPager(容器类，继承ViewGroup)(经常和Fragment一起使用)      
 * 需要适配器提供数据    
  *
  ```java
  public class AdapterFragment extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public AdapterFragment(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {//必须实现
        return mFragments.get(position);
    }

    @Override
    public int getCount() {//必须实现
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {//选择性实现
        return mFragments.get(position).getClass().getSimpleName();
    }
}
  ```    

  * 一个重要的属性  mViewPager.setOffscreenPageLimit()    
  这个方法用来控制Fragment不重新走生命周期的个数的，如果一共有4个Fragment，那么所有的fragment都只走一次生命周期，如果是mViewPager.setOffscreenPageLimit(2)，那么其中有一个fragment会在切换的时候重新走一遍生命周期      


 * TabLayout   
   * 通常嵌套在AppBarLayout下，可以有多个横着的选项    
   * app:tabIndicatorColor  每个选项被选中的时候下划线的颜色     
   * app:tabMode
   * app:tabGravity   
  比较常用的是app:tabMode设置值scrollable，以及app:tabGravity设置值center。
比如，当app:tabMode设置值scrollable表示此TabLayout中当子view超出屏幕边界时候，将提供滑动以便滑出不可见的那些子view。
而app:tabGravity设置值center，在有些情况下，比如TabLayout中子view较少需要居中显示时候的情景。

## 下拉刷新   
* SwipeRefreshLayout   
 * 在RecyclerView布局外层嵌套一个SwipeRefreshLayout就可以实现下拉刷新    
 * 为SwipeRefreshLayout添加一个刷新事件监听，用来进行具体的刷新逻辑   

## 可折叠式标题栏   
* CollapsingToolbarLayout   
 *  CollapsingToolbarLayout不能单独存在，必须当作AppBarLayout的直接子布局使用，而AppBarLayout又必须是CoordinatorLayout(坐标布局)的子布局  
 * app:layout_contentScrim属性用来指定CollapsingToolbarLayout在趋于折叠状态以及折叠之后的颜色   
* NestedScrollView(与AppBarLayout平级)     
 * 是在ScrollView基础上添加了响应滚动事件的功能，所以将它嵌套在CoordinatorLayout内部。










PS:在使用MaterialDesign编写布局时经常需要设置命名空间  
**xmlns:app="http://schemas.android.com/apk/res-auto"**   
