/******************************************************************
 *
 *Copyright (C)2012 Amlogic, Inc.
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 ******************************************************************/
package com.droidlogic.updater.ui;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.util.Log;
import android.text.TextUtils;

public class LoaderReceiver extends BroadcastReceiver {

    private static final String TAG = "LoaderReceiver";
    private static final String BR_OTA_UPDATE = "com.khadas.ota.UPDATE";

    @Override
    public void onReceive ( Context context, Intent intent ) {
        String action = intent.getAction();
        Log.d(TAG, "action = " + action);
        if(action.equals(BR_OTA_UPDATE)) {
            String mImageFilePath = intent.getStringExtra("path");
            if (!TextUtils.isEmpty(mImageFilePath)) {
                Log.d(TAG, "BR_OTA_UPDATE mImageFilePath = " + mImageFilePath);
                Intent intentMainActivity = new Intent(context, MainActivity.class);
                intentMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentMainActivity.putExtra("path", mImageFilePath);
                context.startActivity(intentMainActivity);
            }
            return;
        }
    }

}
