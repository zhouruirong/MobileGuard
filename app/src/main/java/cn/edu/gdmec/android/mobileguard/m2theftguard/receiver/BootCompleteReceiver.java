package cn.edu.gdmec.android.mobileguard.m2theftguard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.edu.gdmec.android.mobileguard.App;
import cn.edu.gdmec.android.mobileguard.m9advancedtools.service.AppLockService;

/**
 * Created by 38322 on 2017/10/21.
 */

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        ((App)(context.getApplicationContext())).correctSIM();
        //启动程序锁服务
        context.startService(new Intent(context, AppLockService.class));
    }
}
