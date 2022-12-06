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

11.树形层级列表

```kotlin
    多布局关键点：
        1)构建三种类型的实体类，有子项的类，继承BaseExpandNode类，无子项的类继承BaseNode
        2)构建每种类型对应的Provider,处理他的convert方法和onClick
        3)构建包含层级的数据源
        4)自定义适配器，继承自BaseNodeAdapter，添加Provider以及重写getItemType为每种类型设置一个值区分类型
        5)RecyclerView设置adapter，layoutManager以及其他属性，放入数据源显示

/**
 * 折叠列表的几种类型
 */
class FirstNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>?) :
    BaseExpandNode() {
    init {
        isExpanded = false
    }
}


class SecondNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>?) :
    BaseExpandNode() {
    init {
        isExpanded = false
    }
}

class ThirdNode(val title: String, val imageId: Int, override val childNode: MutableList<BaseNode>? = null) : BaseNode()

/**
 * 自定义Adapter
 */
class NodeTreeAdapter(mList: MutableList<BaseNode>? = null) : BaseNodeAdapter(mList) {

    companion object {
        const val EXPAND_COLLAPSE_PAYLOAD = 110
    }

    init {
        addNodeProvider(FirstProvider())
        addNodeProvider(SecondProvider())
        addNodeProvider(ThirdProvider())
    }

    override fun getItemType(data: List<BaseNode>, position: Int) =
        when (data[position]) {
            is FirstNode -> ItemType.ITEM_FIRST.itemType
            is SecondNode -> ItemType.ITEM_SECOND.itemType
            is ThirdNode -> ItemType.ITEM_THIRD.itemType
            else -> -1
        }
}

/**
 * 构建Provider
 */
// FirstProvider
class FirstProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = ItemType.ITEM_FIRST.itemType

    override val layoutId: Int
        get() = R.layout.rv_item_node_first

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val firstNode = item as FirstNode
        helper.setText(R.id.tv_node_first, firstNode.title)
        helper.setImageResource(R.id.iv_node_first, firstNode.imageId)

        setArrowSpin(helper, item, false)
    }

    override fun convert(helper: BaseViewHolder, item: BaseNode, payloads: List<Any>) {
        for (payload in payloads) {
            if (payload is Int && payload == NodeTreeAdapter.EXPAND_COLLAPSE_PAYLOAD) {
                // 增量刷新，使用动画变化箭头
                setArrowSpin(helper, item, true)
            }
        }
    }

    private fun setArrowSpin(helper: BaseViewHolder, item: BaseNode, isAnimate: Boolean) {
        val firstNode = item as FirstNode
        val imageArrow = helper.getView<ImageView>(R.id.first_iv_arrow)

        if (firstNode.isExpanded) {
            if (isAnimate) {
                ViewCompat.animate(imageArrow).setDuration(200).setInterpolator(DecelerateInterpolator()).rotation(0f).start()
            } else {
                imageArrow.rotation = 0f
            }
        } else {
            if (isAnimate) {
                ViewCompat.animate(imageArrow).setDuration(200).setInterpolator(DecelerateInterpolator()).rotation(90f).start()
            } else {
                imageArrow.rotation = 90f
            }
        }
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: BaseNode, position: Int) {
        // 这里使用payload进行增量刷新（避免整个item刷新导致的闪烁，不自然）
        getAdapter()!!.expandOrCollapse(position, animate = true, notify = true, parentPayload = NodeTreeAdapter.EXPAND_COLLAPSE_PAYLOAD)
    }
}


// SecondProvider
class SecondProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = ItemType.ITEM_SECOND.itemType

    override val layoutId: Int
        get() = R.layout.rv_item_node_second

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val secondNode = item as SecondNode
        helper.setText(R.id.tv_node_second, secondNode.title)
        helper.setImageResource(R.id.iv_node_second, secondNode.imageId)

        if (secondNode.isExpanded) {
            helper.setImageResource(R.id.second_iv_arrow, R.drawable.ic_arrow_down)
        } else {
            helper.setImageResource(R.id.second_iv_arrow, R.drawable.ic_arrow)
        }
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: BaseNode, position: Int) {
        val secondNode = data as SecondNode
        if (secondNode.isExpanded) {
            getAdapter()?.collapse(position)
        } else {
            getAdapter()?.expandAndCollapseOther(position)
        }
    }
}

// ThirdProvider
class ThirdProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = ItemType.ITEM_THIRD.itemType

    override val layoutId: Int
        get() = R.layout.rv_item_node_third

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val thirdNode = item as ThirdNode
        helper.setText(R.id.tv_node_third, thirdNode.title)
        helper.setImageResource(R.id.iv_node_third, thirdNode.imageId)
    }
}

/**
 * 构建数据源
 */
fun getNodeTreeListData(): MutableList<BaseNode> {
    val firstList = mutableListOf<BaseNode>()

    for (i in 0 until 10) {
        val secondList = mutableListOf<BaseNode>()
        for (j in 0 until 6) {
            val thirdList = mutableListOf<BaseNode>()
            for (k in 0 until 4) {
                val node = ThirdNode("Third Node $k", R.mipmap.ic_launcher)
                thirdList.add(node)
            }

            val secondNode = SecondNode("Second Node $j", R.mipmap.ic_launcher, thirdList)
            secondNode.isExpanded = (j == 0)
            secondList.add(secondNode)
        }
        val firstNode = FirstNode("Fist Node $i", R.mipmap.ic_launcher, secondList)

        // 模拟 默认第0个是展开的
        firstNode.isExpanded = (i == 0)
        firstList.add(firstNode)
    }
    return firstList
}

/**
 * 显示数据
 */
private fun initRecyclerView() {
    mAdapter = NodeTreeAdapter(getNodeTreeListData())
    mBinding.nodeTreeRv.apply {
        layoutManager = LinearLayoutManager(this@NodeTreeListActivity)
        adapter = mAdapter
    }
}
```

12.设置空布局
```kotlin
// 没有数据的时候默认显示该布局 
val emptyView = RvEmptyBinding.inflate(layoutInflater)
mAdapter.setEmptyView(emptyView.root)
```

13.添加拖拽、滑动删除

14.多布局

15.自定义ViewHolder

16.混淆
```kotlin
-keep class com.chad.library.adapter.** {
*;
}
-keep public class * extends com.chad.library.adapter.base.BaseQuickAdapter
-keep public class * extends com.chad.library.adapter.base.BaseViewHolder
-keepclassmembers  class **$** extends com.chad.library.adapter.base.BaseViewHolder {
<init>(...);
}


```


17.扩展框架

