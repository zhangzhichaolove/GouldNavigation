package peak.chao.gouldnavigation;


import android.view.View;

import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;

public class MyINaviInfoCallback implements INaviInfoCallback {

    /**
     * 导航初始化失败时的回调函数
     **/
    @Override
    public void onInitNaviFailure() {

    }

    /**
     * 导航播报信息回调函数。
     *
     * @param text 语音播报文字
     **/

    @Override
    public void onGetNavigationText(String text) {

    }

    /**
     * 当GPS位置有更新时的回调函数。
     *
     * @param location 当前自车坐标位置
     **/
    @Override
    public void onLocationChange(AMapNaviLocation location) {

    }

    @Override
    public void onArriveDestination(boolean b) {

    }

    /**
     * 启动导航后的回调函数
     **/
    @Override
    public void onStartNavi(int i) {

    }

    /**
     * 算路成功回调
     *
     * @param routeIds 路线id数组
     */
    @Override
    public void onCalculateRouteSuccess(int[] routeIds) {

    }

    /**
     * 步行或者驾车路径规划失败后的回调函数
     **/
    @Override
    public void onCalculateRouteFailure(int errorCode) {

    }

    /**
     * 停止语音回调，收到此回调后用户可以停止播放语音
     **/
    @Override
    public void onStopSpeaking() {

    }

    @Override
    public void onReCalculateRoute(int i) {

    }

    @Override
    public void onExitPage(int i) {

    }

    @Override
    public void onStrategyChanged(int i) {

    }

    /**
     * 底部自定义区域,返回null则不显示自定义区域
     * @return
     */
    @Override
    public View getCustomNaviBottomView() {
        return null;
    }

    /**
     * 中部自定义区域,返回null则不显示自定义区域
     * @return
     */
    @Override
    public View getCustomNaviView() {
        return null;
    }

    /**
     * 到达目的地后回调函数。
     **/
    @Override
    public void onArrivedWayPoint(int i) {

    }

    @Override
    public void onMapTypeChanged(int i) {

    }
}
