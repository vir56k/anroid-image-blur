package zhangyf.vir56k.myapplication3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;

import zhangyf.vir56k.androidimageblur.BlurUtil;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview1;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview1 = (ImageView) findViewById(R.id.imageview1);

        rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        showBlurBackground();
    }

    private void showBlurBackground() {
        Bitmap img1;
        try {
            img1 = BitmapFactory.decodeStream(getResources().getAssets().open("img1.png"));
            //缩放并显示
            Bitmap newImg = BlurUtil.doBlur(img1, 20, 10);
            img1.recycle();

            rootView.setBackground(new BitmapDrawable(getResources(), newImg));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void alert(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}
