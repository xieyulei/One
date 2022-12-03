### BRVAH--RecyclerView框架

#### 1.为什么要使用这个框架？

```kotlin
1）可以节约开发者大量的时间
2）集成了大部分列表常用需求解决方案
```

#### 2.框架基本信息

```kotlin
名称：BaseRecyclerViewAdapterHelper
github仓库：【https://github.com/CymChad/BaseRecyclerViewAdapterHelper】
```

#### 3.框架引入

```kotlin
1)settings.gradle 配置
        dependencyResolutionManagement {
            repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
            repositories {
                ...
                maven { url "https://jitpack.io" }
            }
        }
]

2)build.gradle(app)
dependencies {
    // 最新版本参考[https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/readme/0-BaseRecyclerViewAdapterHelper.md]
    implementation 'com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.10'
}
```

#### 4.基本列表使用

```kotlin
列表显示基本要素：1.数据源 2.适配器  3.控件layoutManager 4.点击事件响应（item、item子元素、长按事件）

1.构建数据源
2.根据数据源，构建适配器
3.控件设置布局方式，并将适配器与控件连接起来显示页面
```

#### 5.点击事件

```kotlin
mAdapter.setOnItemClickListener { _, _, position -> doSomeThing() }
```

#### 6.子控件的点击事件

```kotlin
mAdapter.setOnItemChildClickListener { adapter, _, position -> doSomeThing() }
```

#### 7.长按事件

```kotlin
mAdapter.setOnItemLongClickListener { _, _, position ->
    doSomeThing()
    true // 这里的true和false影响点击事件向下传递，false时，onItemChildListener也会响应
}
```

#### 8.列表加载动画

```kotlin
mAdapter.apply {
    // 是否打开动画,默认false
    animationEnable = true

    // 动画是否仅第一次执行，默认true
    isAnimationFirstOnly = false

    // 使用内置默认动画设置,默认AnimationType.AlphaIn（参照：BaseQuickAdapter.addAnimation()）
    setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInRight)
}
```

#### 9.添加头部、尾部

```kotlin
mNormalListAdapter.apply {
    // addFooterView可以设置view的位置，设定在列表中的位置，setFootView默认在最后一个,header也是如此
    val headerBinding = RvItemHeaderBinding.inflate(layoutInflater)
    setHeaderView(headerBinding.root)
    headerBinding.rvItemLayout.setOnClickListener {
        Toast.makeText(this@NormalRvListActivity, "Click Header", Toast.LENGTH_SHORT).show()
    }

    // addFooter
    val footerBinding = RvItemFooterBinding.inflate(layoutInflater)
    setFooterView(footerBinding.root)
    footerBinding.rvItemLayout.setOnClickListener {
        Toast.makeText(this@NormalRvListActivity, "Click Footer", Toast.LENGTH_SHORT).show()
    }
}
```

#### 10.分组布局

```kotlin
实现分组布局的关键点在于：
1)实体类必须继承SectionEntity
2)adapter构造需要传入两个布局id，第一个是head的，第二个是item的
3)convert方法里边加载item数据，在convertHead方法里边加载head数据

// date source
data class GroupFruit(
    val name: String,
    val imageId: Int,
    override val isHeader: Boolean = false,
    val header: String = ""
) : SectionEntity

// entity
fun getGroupListData(): MutableList<GroupFruit> {
    val fruitList = mutableListOf<GroupFruit>()
    for (i in 0..40) {
        fruitList.add(
            GroupFruit(
                "Fruit${i + 1}",
                R.mipmap.ic_launcher_round,
                i % 5 == 0,
                "Head${i + 1}"
            )
        )
    }
    return fruitList
}

// Adapter 
class GroupRvAdapter(
    @LayoutRes headLayoutRes: Int,
    @LayoutRes itemLayoutRes: Int,
    data: MutableList<GroupFruit>
) :
    BaseSectionQuickAdapter<GroupFruit, BaseViewHolder>(headLayoutRes, itemLayoutRes, data) {
    override fun convert(holder: BaseViewHolder, item: GroupFruit) {
        holder.setText(R.id.rv_item_tv, item.name)
            .setImageResource(R.id.rv_item_iv, item.imageId)
    }

    override fun convertHeader(helper: BaseViewHolder, item: GroupFruit) {
        helper.setText(R.id.rv_item_header_title, item.header)
    }
}

// setAdapter 
private fun initRecyclerView() {
    mAdapter = GroupRvAdapter(R.layout.rv_item_header, R.layout.rv_item, getGroupListData())
    mBinding.groupRv.apply {
        layoutManager = LinearLayoutManager(this@GroupRvListActivity)
        // 添加列表子项分隔线
        val decoration =
            DividerItemDecoration(this@GroupRvListActivity, LinearLayoutManager.VERTICAL)
        val drawable =
            ContextCompat.getDrawable(this@GroupRvListActivity, R.drawable.rv_divider_line)
        drawable?.let {
            decoration.setDrawable(it)
        }
        addItemDecoration(decoration)
        adapter = mAdapter
    }
}

// layout_rv_item_header
<?xml version ="1.0" encoding ="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns : android ="http://schemas.android.com/apk/res/android"
    xmlns:app = "http://schemas.android.com/apk/res-auto"
    android:id = "@+id/rv_item_layout"
    android:layout_width = "match_parent"
    android:background = "@color/theme_color"
    android:layout_height = "wrap_content" >
    
    <TextView
        android:id = "@+id/rv_item_header_title"
        android:layout_width = "0dp"
        android:layout_height = "?actionBarSize"
        android:layout_marginStart = "@dimen/sp_24"
        android:gravity = "center|start"
        android:text = "@string/recycler_header_title"
        android:textSize = "20sp"
        android:textStyle = "bold"
        app:layout_constraintBottom_toBottomOf = "parent"
        app:layout_constraintEnd_toEndOf = "parent"
        app:layout_constraintStart_toStartOf = "parent"
        app:layout_constraintTop_toTopOf = "parent" />

</androidx.constraintlayout.widget.ConstraintLayout >

// layout -- rv_item
<?xml version ="1.0" encoding ="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns : android ="http://schemas.android.com/apk/res/android"
    xmlns:app = "http://schemas.android.com/apk/res-auto"
    xmlns:tools = "http://schemas.android.com/tools"
    android:id = "@+id/rv_item_layout"
    android:layout_width = "match_parent"
    android:layout_height = "?actionBarSize" >

    <TextView
        android:id = "@+id/rv_item_tv"
        android:layout_width = "0dp"
        android:layout_height = "0dp"
        android:layout_marginStart = "@dimen/sp_24"
        android:gravity = "center|start"
        android:text = "@string/title_two_fragment"
        app:layout_constraintBottom_toBottomOf = "parent"
        app:layout_constraintEnd_toStartOf = "@id/rv_item_iv"
        app:layout_constraintStart_toStartOf = "parent"
        app:layout_constraintTop_toTopOf = "parent" />
    
    <ImageView
        android:id = "@+id/rv_item_iv"
        android:layout_width = "wrap_content"
        android:layout_height = "wrap_content"
        android:layout_marginEnd = "@dimen/sp_24"
        android:src = "@mipmap/ic_launcher"
        app:layout_constraintBottom_toBottomOf = "parent"
        app:layout_constraintEnd_toEndOf = "parent"
        app:layout_constraintTop_toTopOf = "parent"
        tools:ignore = "ContentDescription" />

</androidx.constraintlayout.widget.ConstraintLayout >

```

11.多布局

12.设置空布局

13.添加拖拽、滑动删除

14.树形列表

15.自定义ViewHolder

16.混淆

17.扩展框架

