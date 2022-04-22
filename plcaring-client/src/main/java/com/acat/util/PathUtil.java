package com.acat.util;

/**
 * 返回项目图片的根路径或者子路径
 */
public class PathUtil {
    public static String seperator = System.getProperty("file.seperator");

    public static String getImgBasePath() {

        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "C:/Users/lenovo/Pictures/";
        } else {
            //有macbook配置在这里
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getShopImagePath(long shopId) {
        String imagePath = "upload/item/shop" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
    public static String getHeadLineImagePath() {
        String imagePath = "/upload/images/item/headtitle/";
        return imagePath.replace("/", seperator);
    }
    public static String getShopCategoryPath() {
        String imagePath = "/upload/images/item/shopcategory/";
        return imagePath.replace("/", seperator);
    }
}
