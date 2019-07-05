package peak.chao.gouldnavigation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.AmapPageType;
import com.amap.api.navi.model.AMapCarInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * AmapNaviParams参数
 * public void setUseInnerVoice(boolean isUseInnerVoice),设置是否使用内部语音播报,注意：6.1.0版本开始，默认值改为true
 * public void setMultipleRouteNaviMode(boolean multipleRouteNaviMode),设置是否在导航页显示多备选路线, true:多路线导航模式, false:单路线导航模式(默认)
 * public void setNeedCalculateRouteWhenPresent(boolean needCalculateRouteWhenPresent),设置启动导航组件是否进行算路,默认 true : 为算路，若设置为false，启动组件以后不会算路直接开启导航，只有在直接跳转导航情况下才生效。
 * public void setNeedDestroyDriveManagerInstanceWhenNaviExit(boolean needDestroyDriveManagerInstanceWhenNaviExit),设置退出导航组件是否销毁导航实例,默认true：为销毁导航实例，若设置为false，退出导航组件以后不会销毁导航。
 * public AmapNaviParams setTheme(AmapNaviTheme theme),设置组件主题,目前支持的的主题有三种：蓝色(默认主题):{AmapNaviTheme#BLUE}白色:{AmapNaviTheme#WHITE}黑色:{AmapNaviTheme#BLACK}
 */
public class MainActivity extends AppCompatActivity {

    LatLng p1 = new LatLng(39.993266, 116.473193);//首开广场
    LatLng p2 = new LatLng(39.917337, 116.397056);//故宫博物院
    LatLng p3 = new LatLng(39.904556, 116.427231);//北京站
    LatLng p4 = new LatLng(39.773801, 116.368984);//新三余公园(南5环)
    LatLng p5 = new LatLng(40.041986, 116.414496);//立水桥(北5环)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //转换坐标
        //百度：104.075175,30.552622    三街地铁站
        //高德：104.069188,30.54621    三街地铁站
        double[] lola = CoordinateUtil.bd_decrypt(104.075175, 30.552622);
        double[] lola2 = CoordinateUtil.gaoDeToBaidu(104.069188, 30.54621);
        Log.e("MainActivity", lola[1] + "," + lola[0]);
        Log.e("MainActivity", lola2[0] + "," + lola2[1]);
    }


    public void huoche(View view) {
        gotoHuoCheNav();
    }


    public void startNav(View view) {
        startNav();
    }

    /**
     * 货车导航
     */
    private void gotoHuoCheNav() {
        AMapCarInfo aMapCarInfo = new AMapCarInfo();
        aMapCarInfo.setCarType("1");//设置车辆类型，0小车，1货车
        aMapCarInfo.setCarNumber("京DFZ239");//设置车辆的车牌号码. 如:京DFZ239,京ABZ239
        aMapCarInfo.setVehicleSize("4");//设置货车的等级
        aMapCarInfo.setVehicleLoad("100");//设置货车的载重，单位：吨。
        aMapCarInfo.setVehicleWeight("99");//设置货车的自重
        aMapCarInfo.setVehicleLength("25");//设置货车的最大长度，单位：米。
        aMapCarInfo.setVehicleWidth("2");//设置货车的最大宽度，单位：米。 如:1.8，1.5等等。
        aMapCarInfo.setVehicleHeight("4");//设置货车的高度，单位：米。
        aMapCarInfo.setVehicleAxis("6");//设置货车的轴数
        aMapCarInfo.setVehicleLoadSwitch(true);//设置车辆的载重是否参与算路
        aMapCarInfo.setRestriction(true);//设置是否躲避车辆限行。

        Poi end = new Poi("北京站", new LatLng(39.904556, 116.427231), "B000A83M61");
        AmapNaviParams naviParams = new AmapNaviParams(null, null, end, AmapNaviType.DRIVER);
        naviParams.setCarInfo(aMapCarInfo);

        AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), naviParams, new MyINaviInfoCallback());
    }

    /**
     * 直接导航
     */
    private void startNav() {
        //起点
        Poi start = new Poi("立水桥(北5环)", p5, "");
        //途经点
        List<Poi> poiList = new ArrayList();
        poiList.add(new Poi("首开广场", p1, ""));
        poiList.add(new Poi("故宫博物院", p2, ""));
        poiList.add(new Poi("北京站", p3, ""));
        //终点
        Poi end = new Poi("新三余公园(南5环)", p4, "");
        //AmapPageType.NAVI此参数决定是否直接导航。
        AmapNaviParams amapNaviParams = new AmapNaviParams(start, poiList, end, AmapNaviType.DRIVER, AmapPageType.NAVI);
        amapNaviParams.setUseInnerVoice(true);
        AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), amapNaviParams, new MyINaviInfoCallback());
    }

}
