# MaterialDesignTest
## Toolbar  
## 滑动菜单  
* DrawerLayout   
* NavigationView   
 * menu
 * headerLayout   

## 悬浮按钮和可交互提示     
* FloatingActionButton   
* Snackbar    
* CoordinatorLayout(一个可以监听所有子控件事件的FrameLayout)(坐标布局)    


## 卡片式布局    
* CardView   
* RecyclerView    
* AppBarLayout(一个垂直的LinearLayout,内部进行了很多滚动事件的封装)  
  * 在Toolbar外层嵌套一个AppBarLayout就可以解决滑动时遮挡Toolbar的问题    
  * app:layout_scrollFlags:"scroll|enterAlways|snap"属性    

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
