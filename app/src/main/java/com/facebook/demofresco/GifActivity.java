package com.facebook.demofresco;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;

/**
 * 用于演示高斯模糊的实现
 *
 * Created by android_ls on 16/11/11.
 */

public class GifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_gif);

//        String url = "http://lensbuyersguide.com/gallery/219/2/23_iso100_14mm.jpg";
        String url = "http://ww1.sinaimg.cn/large/85d77acdgw1f4hqkshvw6g20dw0741k8.jpg";

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView)findViewById(R.id.sdv_1);
        ImageLoader.loadImage(simpleDraweeView, url);


    }

}
