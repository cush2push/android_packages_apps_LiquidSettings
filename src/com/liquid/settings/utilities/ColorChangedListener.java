/*
** Copyright (C) 2011 The Liquid Settings Project
**
** Licensed under the Apache License, Version 2.0 (the "License"); 
** you may not use this file except in compliance with the License. 
** You may obtain a copy of the License at 
**
**     http://www.apache.org/licenses/LICENSE-2.0 
**
** Unless required by applicable law or agreed to in writing, software 
** distributed under the License is distributed on an "AS IS" BASIS, 
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
** See the License for the specific language governing permissions and 
** limitations under the License.
*/

package com.liquid.settings.utilities;

import android.app.ColorPickerDialog;
import android.preference.PreferenceActivity;
import android.provider.Settings;

public class ColorChangedListener implements ColorPickerDialog.OnColorChangedListener {
    private PreferenceActivity mActivity;
    private String mSetting;

    public ColorChangedListener(PreferenceActivity activity, String setting) {
        mActivity = activity;
        mSetting = setting;
    }

    public void colorChanged(int color) {
        Settings.System.putInt(mActivity.getContentResolver(), mSetting, color);
    }
}