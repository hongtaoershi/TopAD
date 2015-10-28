package com.topad.view.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.topad.R;
import com.topad.view.customviews.MyGridView;
import com.topad.view.customviews.TitleView;

/**
 * ${todo}<我要抢单详情页>
 *
 * @author lht
 * @data: on 15/10/28 16:32
 */
public class GrabSingleDetailsActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = GrabSingleDetailsActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 顶部布局 **/
    private TitleView mTitleView;
    /** 案例 **/
    private MyGridView mGridView;
    /** 名称 **/
    private TextView mName;
    /** 价钱 **/
    private TextView mMoney;
    /** 内容 **/
    private TextView mContent;
    /** 地址 **/
    private TextView mAddress;
    /** 详细内容 **/
    private TextView mDetailsContent;
    /** 提交 **/
    private Button mSubmit;

    @Override
    public int setLayoutById() {
        mContext = this;
        return R.layout.activity_grab_single_details;
    }

    @Override
    public View setLayoutByView() {
        return null;
    }

    @Override
    public void initViews() {
        mTitleView = (TitleView) findViewById(R.id.title);
        mGridView = (MyGridView) findViewById(R.id.gv_in);
        mName = (TextView) findViewById(R.id.tv_name);
        mMoney = (TextView) findViewById(R.id.tv_price);
        mContent = (TextView) findViewById(R.id.tv_content);
        mAddress = (TextView) findViewById(R.id.tv_address);
        mDetailsContent = (TextView) findViewById(R.id.tv_need_details_content);
        mSubmit = (Button) findViewById(R.id.btn_submit);

        mSubmit.setOnClickListener(this);

        // 设置title
        mTitleView.setTitle("项目详情");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());

        //为GridView设置适配器
        mGridView.setAdapter(new MyAdapter(this));

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            // 收藏
            case R.id.btn_submit:

                break;

            default:
                break;
        }
    }

    /**
     * 顶部布局--左按钮事件监听
     */
    public class TitleLeftOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }

    }

    //自定义适配器
    class MyAdapter extends BaseAdapter {
        //上下文对象
        private Context context;
        //图片数组
        private Integer[] imgs = {
                R.drawable.homepage_icon_manage, R.drawable.homepage_icon_manage, R.drawable.homepage_icon_manage,
                R.drawable.homepage_icon_manage, R.drawable.homepage_icon_manage
        };

        MyAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return imgs.length;
        }

        public Object getItem(int item) {
            return item;
        }

        public long getItemId(int id) {
            return id;
        }

        //创建View方法
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(
                        new GridView.LayoutParams(
                                (int) (getResources().getDisplayMetrics().density*75),
                                (int) (getResources().getDisplayMetrics().density*75)));//设置ImageView对象布局
                imageView.setAdjustViewBounds(false);//设置边界对齐
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//设置刻度的类型
                imageView.setPadding(8, 8, 8, 8);//设置间距
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imgs[position]);//为ImageView设置图片资源
            return imageView;

//            if(convertView == null){
//                //根据布局文件获取View返回值
//                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_grab_single_details_item_layout, null);
//            }
//            ImageView imageview = (ImageView) convertView.findViewById(R.id.icon);
//            TextView name = (TextView) convertView.findViewById(R.id.tv_name);
//
//            imageview.setImageResource(images[position]);
//            name.setText(name[position]);
//            return convertView;
        }
    }
}
