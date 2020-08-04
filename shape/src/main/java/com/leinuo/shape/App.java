package com.leinuo.shape;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.SchemaException;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by leinuo on 2020/5/18 上午11:36
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class App {


    public static void main(String[] args) throws ParseException, IOException, SchemaException {
        String shapeFile =  "/home/leinuo/gitee/shape6/src/main/resources/shp/xining/3jiliuyu.shp";
        String dbfFile =  "/home/leinuo/gitee/shape6/src/main/resources/shp/xining/3jiliuyu.dbf";
        //Map map = shape2Geojson(shapeFile);
        testRead(shapeFile);
        System.out.println("shape2Geojson = " + shape2Geojson(shapeFile));
    }
    /**
     * shp转换为Geojson
     * @param shpPath
     * @return
     */
    public static Map shape2Geojson(String shpPath){
        Map map = new HashMap();

        FeatureJSON fjson = new FeatureJSON();

        try{
            StringBuffer sb = new StringBuffer();
            sb.append("{\"type\": \"FeatureCollection\",\"features\": ");

            File file = new File(shpPath);
            ShapefileDataStore shpDataStore = null;

            shpDataStore = new ShapefileDataStore(file.toURL());
            //设置编码
            Charset charset = Charset.forName("GBK");
            shpDataStore.setCharset(charset);
            String typeName = shpDataStore.getTypeNames()[0];
            SimpleFeatureSource featureSource = null;
            featureSource =  shpDataStore.getFeatureSource (typeName);
            SimpleFeatureCollection result = featureSource.getFeatures();
            SimpleFeatureIterator itertor = result.features();
            JSONArray array = new JSONArray();
            while (itertor.hasNext())
            {
                SimpleFeature feature = itertor.next();
                StringWriter writer = new StringWriter();
                fjson.writeFeature(feature, writer);
                JSONObject json = JSON.parseObject(writer.toString());
                array.add(json);
            }
            itertor.close();
            sb.append(array.toString());
            sb.append("}");
            map.put("status", "success");
            map.put("message", sb.toString());
        }
        catch(Exception e){
            map.put("status", "failure");
            map.put("message", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    public static void testRead(String file) throws IOException {
        long start = System.currentTimeMillis();
        List<Object> list;
        // 使用GeoTools读取ShapeFile文件
        File shapeFile = new File(file);
        ShapefileDataStore store = new ShapefileDataStore(shapeFile.toURI().toURL());
        //设置编码
        Charset charset = Charset.forName("utf-8");
        store.setCharset(charset);
        SimpleFeatureSource sfSource = store.getFeatureSource();
        SimpleFeatureIterator sfIter = sfSource.getFeatures().features();
        // 从ShapeFile文件中遍历每一个Feature，然后将Feature转为GeoJSON字符串
        while (sfIter.hasNext()) {
            SimpleFeature feature = sfIter.next();
            //System.out.println(JsonsUtils.objectToString(feature));
            list = feature.getAttributes();
            System.out.println(list.toString());
        }
        System.out.println("数据导入完成，共耗时"+(System.currentTimeMillis() - start)+"ms");
    }

}
