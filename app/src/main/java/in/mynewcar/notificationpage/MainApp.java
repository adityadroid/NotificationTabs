package in.mynewcar.notificationpage;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/CenturyGothic.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
