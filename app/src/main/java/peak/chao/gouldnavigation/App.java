package peak.chao.gouldnavigation;

import android.app.Application;

import com.amap.api.navi.AMapNavi;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //AMapNavi.setApiKey(this, "72d6e7cd142af16c35b8bfa27a0903bd");
    }
}
