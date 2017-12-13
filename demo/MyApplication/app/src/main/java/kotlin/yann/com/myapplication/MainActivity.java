package kotlin.yann.com.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void clickEvent(View view){
        switch (view.getId()){
            case R.id.btn1:
                Intent intent = new Intent();
                intent.setAction("com.android.myaction.test");
                MainActivity.this.startActivityForResult(intent,102);
                break;
            case R.id.btn2:
                Intent intent1 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("EMAIL","465425854@qq.com");
                bundle.putString("PASSWORD","xyy123");
                intent1.putExtras(bundle);
                intent1.setClassName("kotlin.yann.com","kotlin.yann.com.LoginActivity");
                MainActivity.this.startActivityForResult(intent1,103);
                break;
            case R.id.btn3:
                Intent intent2 = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("FIRST_APP","你好，MainActivity!");
                intent2.putExtras(bundle1);

                ComponentName componentName = new ComponentName("kotlin.yann.com","kotlin.yann.com.MainActivity");
                intent2.setComponent(componentName);
                MainActivity.this.startActivityForResult(intent2,104);
                break;
            case R.id.btn4:
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }
                call();
                break;
            default:
                break;
        }

    }

    @SuppressLint("MissingPermission")
    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:18717713732"));
            startActivity(intent);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG,"requestCode:"+requestCode);
        Toast.makeText(MainActivity.this,"requestCode:"+requestCode,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    call();
                }else {
                    Toast.makeText(MainActivity.this,"You denied the permission",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
