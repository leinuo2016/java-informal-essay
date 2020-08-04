import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by leinuo on 2020/2/12 下午6:02
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class App {
    public static void main(String[] args) {
        String str = "212,12,12,dsd,dsds,ds";
        List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
        list.add("6565");
        System.out.println("运行OK！");

        String url = "http://qqsl-xn-cloud-public.oss-cn-hangzhou.aliyuncs.com/dev/panorama/1526691986621.tiles/thumb.jpg";
        String key = url.substring(url.indexOf("dev/"));
        System.out.println(key);
    }
}
