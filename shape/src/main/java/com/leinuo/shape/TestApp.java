package com.leinuo.shape;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.geojson.feature.FeatureJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.type.AttributeDescriptor;
import org.opengis.filter.Filter;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by leinuo on 2020/4/21 上午11:22
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class TestApp {

    public static void main(String[] args) throws IOException {
        testRead();
        //getShpFileAttributes();
    }

    public static void testRead() throws IOException {
        long start = System.currentTimeMillis();

        String SHAPE_FILE =  "/home/leinuo/gitHub/java-informal-essay/shape/src/main/resources/shp/xining/2JIliuyu.shp";

        // 使用GeoTools读取ShapeFile文件
        File shapeFile = new File(SHAPE_FILE);
        ShapefileDataStore store = new ShapefileDataStore(shapeFile.toURI().toURL());
        //设置编码
        Charset charset = Charset.forName("GBK");
        store.setCharset(charset);
        SimpleFeatureSource sfSource = store.getFeatureSource();
        SimpleFeatureIterator sfIter = sfSource.getFeatures().features();
        // 从ShapeFile文件中遍历每一个Feature，然后将Feature转为GeoJSON字符串
        while (sfIter.hasNext()) {
            SimpleFeature feature = (SimpleFeature) sfIter.next();
            // Feature转GeoJSON
            FeatureJSON fjson = new FeatureJSON();
            StringWriter writer = new StringWriter();
            fjson.writeFeature(feature, writer);
            String sjson = writer.toString();
            System.out.println("sjson===== >>>> "  + sjson);
        }
        System.out.println("数据导入完成，共耗时"+(System.currentTimeMillis() - start)+"ms");
    }

    public static JSONArray getShpFileAttributes()  {
        JSONArray jsonArray = new JSONArray();
        try {
            List<Object> list;
            String SHAPE_FILE =  "/home/leinuo/gitHub/java-informal-essay/shape/src/main/resources/shp/xining/2JIliuyu.shp";

            // 使用GeoTools读取ShapeFile文件
            File shapeFile = new File(SHAPE_FILE);
            FileDataStore store = FileDataStoreFinder.getDataStore(shapeFile);
            // GeoTools读取ShapeFile文件的默认编码为ISO-8859-1。而我们中文操作系统下ShapeFile文件的默认编码一般为utf-8
            ((ShapefileDataStore) store).setCharset(Charset.forName("utf-8"));
            SimpleFeatureSource featureSource = store.getFeatureSource();
            // 提取出属性的 ID 值
            List<String> attributeID = new LinkedList<>();
            List<AttributeDescriptor> attrList= featureSource.getSchema().getAttributeDescriptors();
            for(AttributeDescriptor attr : attrList){
                String ID = attr.getName().getLocalPart();
                if( !ID.equals("the_geom")){
                    attributeID.add(ID);
                }
            }
            SimpleFeatureCollection featureCollection = featureSource.getFeatures();
            SimpleFeatureIterator featureIterator = featureCollection.features();

            while (featureIterator.hasNext()) {
                SimpleFeature feature = featureIterator.next();
                JSONObject jsonObject = new JSONObject();
                list = feature.getAttributes();
                for(int k = 1; k < list.size(); k++ ){
                    jsonObject.put(attributeID.get(k-1), list.get(k));
                }
                jsonArray.add(jsonObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }


    public static void testRead1() throws IOException {
        String path1 = "/home/leinuo/gitHub/java-informal-essay/shape/src/main/resources/shp/xining/2JIliuyu.shp";
//读取shp
        SimpleFeatureCollection colls1 = readShp(path1);
//拿到所有features
        SimpleFeatureIterator iters = colls1.features();

//遍历打印
       /* while(iters.hasNext()){
            SimpleFeature sf = iters.next();
            Object ss= sf.getDefaultGeometry();
            System.out.println(ss);
            System.err.println(sf.getDefaultGeometryProperty().getValue());
            Geometry shape = (Geometry)ss;
            System.err.println(shape.toText());
            if(ss instanceof Polygon){
                Polygon polygon = (Polygon)ss;

                Coordinate[] coordinates= polygon.getCoordinates();
            }
            else if(ss instanceof MultiPolygon){
                MultiPolygon multiPolygon = (MultiPolygon)ss;
                String mult=multiPolygon.toString();
                Coordinate[] coordinates= multiPolygon.getCoordinates();
                System.err.println(coordinates.length);

            }
            System.err.println(ss.getClass().toString());
            System.out.println(sf.getID() + " , " + sf.getAttributes());
        }*/
    }

    public static SimpleFeatureCollection readShp(String path ){
        return readShp(path, null);

    }

    public static SimpleFeatureCollection readShp(String path , Filter filter){
        SimpleFeatureSource featureSource = readStoreByShp(path);
        if(featureSource == null) return null;
        try {
            return filter != null ? featureSource.getFeatures(filter) : featureSource.getFeatures() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static SimpleFeatureSource readStoreByShp(String path ){
        File file = new File(path);
        FileDataStore store;
        SimpleFeatureSource featureSource = null;
        try {
            store = FileDataStoreFinder.getDataStore(file);
            ((ShapefileDataStore) store).setCharset(Charset.forName("GBK"));
            featureSource = store.getFeatureSource();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return featureSource ;
    }

}


