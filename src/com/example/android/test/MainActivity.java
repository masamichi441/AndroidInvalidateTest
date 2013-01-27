package com.example.android.test;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setOrientation(1);
        setContentView(linearLayout);

        View view = new CustomImageView(this);
        linearLayout.addView(view, new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));

        Button button = new Button(this);
        button.setText("Button");
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick()");
                linearLayout.invalidate();
            }
        });
        linearLayout.addView(button, new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
    }

    static class CustomImageView extends ImageView {
        private boolean mState = false;

        public CustomImageView(Context context) {
            super(context);
            setMinimumWidth(50);
            setMinimumHeight(50);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Log.d("CustomImageView", "onDraw()");

            mState = !mState;
            canvas.drawColor(mState ? Color.GREEN : Color.DKGRAY);
        }
    }
}
