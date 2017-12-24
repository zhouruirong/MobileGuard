package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by 38322 on 2017/10/12.
 */

public class Setup3Activity  extends  BaseSetUpActivity implements View.OnClickListener{
    private EditText mInputPhone;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_3);
        //设置第3个小圆点的颜色
        ((RadioButton) findViewById(R.id.rb_third)).setChecked(true);
        ((RadioButton) findViewById(R.id.rb_third)).setChecked(true);

        findViewById(R.id.btn_addcontact).setOnClickListener(this);
        mInputPhone=(EditText) findViewById(R.id.et_inputphone);
        String safaphone=sp.getString("safaphone",null);
        if(!TextUtils.isEmpty(safaphone)){
            mInputPhone.setText(safaphone);
        }
    }
    @Override
    public  void showNext(){
        //判断文本输入框中是否有电话号码
        String safaPhone=mInputPhone.getText().toString().trim();
        if(TextUtils.isEmpty(safaPhone)){
            Toast.makeText(this,"请输入安全号码",Toast.LENGTH_LONG).show();
            return;
        }
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("safephone",safaPhone);
        edit.commit();
        startActivityAndFinishSelf(Setup4Activity.class);
    }
    @Override
    public  void showPre(){
        startActivityAndFinishSelf(Setup2Activity.class);
    }
    @Override
    public  void onClick(View view){
        switch (view.getId()){
            case  R.id.btn_addcontact:
                //启动联系人选择activity拼获取返回值
                startActivityForResult(new Intent(this,ContactSelectActivity.class),0);
                break;
        }
    }
    //获取被调用的activity的返回值
    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data!=null){
            String phone=data.getStringExtra("phone");
            mInputPhone.setText(phone);
        }
    }
}
