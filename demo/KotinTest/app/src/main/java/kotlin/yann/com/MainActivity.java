package kotlin.yann.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xyy on 2017/10/30.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setAction("kotlin.yann.com.login");
                MainActivity.this.startActivityForResult(intent,12);
            }
        });

        TextView textView = (TextView)findViewById(R.id.tv);
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null){
            textView.setText(bundle.getString("FIRST_APP"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("=================","requestCode:"+requestCode);
    }
}
