package peak.chao.gouldnavigation;

import java.math.BigDecimal;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * 坐标工具类
 */
public class CoordinateUtil {
    private static double PI = 3.14159265358979324 * 3000.0 / 180.0;

    /**
     * 百度转高德
     *
     * @param bd_lat
     * @param bd_lon
     * @return
     */
    public static double[] bdToGaoDe(double bd_lat, double bd_lon) {
        double[] gd_lat_lon = new double[2];
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;
        double z = sqrt(x * x + y * y) - 0.00002 * sin(y * PI);
        double theta = atan2(y, x) - 0.000003 * cos(x * PI);
        gd_lat_lon[0] = z * sin(theta);
        gd_lat_lon[1] = z * cos(theta);
        return gd_lat_lon;
    }

    /**
     * 高德、腾讯转百度
     *
     * @param gd_lon
     * @param gd_lat
     * @return
     */
    public static double[] gaoDeToBaidu(double gd_lon, double gd_lat) {
        double[] bd_lat_lon = new double[2];
        double x = gd_lon, y = gd_lat;
        double z = sqrt(x * x + y * y) + 0.00002 * sin(y * PI);
        double theta = atan2(y, x) + 0.000003 * cos(x * PI);
        bd_lat_lon[0] = z * cos(theta) + 0.0065;
        bd_lat_lon[1] = z * sin(theta) + 0.006;
        return bd_lat_lon;
    }

    /**
     * 百度转高德
     *
     * @param bd_lat
     * @param bd_lon
     * @return
     */
    public static double[] bd_decrypt(double bd_lat, double bd_lon) {
        double[] bd_lat_lon = new double[2];
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;
        double z = sqrt(x * x + y * y) - 0.00002 * sin(y * PI);
        double theta = atan2(y, x) - 0.000003 * cos(x * PI);
        double gg_lon = z * cos(theta);
        double gg_lat = z * sin(theta);

        BigDecimal lat = new BigDecimal(gg_lat);
        BigDecimal lon = new BigDecimal(gg_lon);
        System.out.println(bd_lat + "," + bd_lon);
        System.out.println(gg_lat + "," + gg_lon);
        bd_lat_lon[0] = lat.setScale(6, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        bd_lat_lon[1] = lon.setScale(6, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        return bd_lat_lon;
    }
}