package com.acat.util;

import com.acat.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    /**
     * 处理用户传过来的文件流
     *
     * @return
     */
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    /**
     * 将CommonsMultipartFile转换成File类
     *
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图，并返回相对值路径
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            //创建缩略图
            Thumbnails.of(thumbnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:/Users/lenovo/Desktop/PlantWateringSystem/PlantWateringSystem" +
                            "/src/main/resources/sprout_icon.png")), 0.25f).outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {

            e.printStackTrace();
        }
    return relativeAddr;
    }
    /**
     * 处理详情图，并返回新生成图片的相对值路径
     *
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = targetAddr + realFileName + extension;
       // logger.debug("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
       // logger.debug("current complete addr is :" + PathUtil.getImgBasePath() + relativeAddr);
        // 调用Thumbnails生成带有水印的图片
        try { Thumbnails.of(new File("C:/Users/lenovo/Pictures/windy.jpg")).
                size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:/Users/lenovo/Desktop/PlantWateringSystem/PlantWateringSystem" +
                        "/src/main/resources/sprout_icon.png")), 0.25f)

                    .outputQuality(0.9f).toFile(dest);
        } catch (IOException e) {
           // logger.error(e.toString());
            throw new RuntimeException("创建缩图片失败：" + e.toString());
        }
        // 返回图片相对路径地址
        return relativeAddr;
    }
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，年月日，时分秒+五位随机数
     *
     * @return
     */
    private static String getRandomFileName() {
// TODO: 2022/1/3
     int rannum = r.nextInt(8999)+10000;
     String nowTimeStr = sDateFormat.format(new Date());
     return nowTimeStr + rannum;
    }

    public static void main(String args[]) throws IOException {
//        String basePath = Thread.currentThread().getContextClassLoader()
//                .getResource("").getPath();
        Thumbnails.of(new File("C:/Users/lenovo/Pictures/windy.jpg")).
                size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:/Users/lenovo/Desktop/PlantWateringSystem/PlantWateringSystem" +
                        "/src/main/resources/sprout_icon.png")), 0.25f)
                .outputQuality(0.8f).toFile("C:/Users/lenovo/Pictures/windynew.jpg");

    }
    /**
     * storePath是文件的路径还是目录的路径， 如果storePath是文件路径则删除该文件，
     * 如果storePath是目录路径则删除该目录下的所有文件
     *
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }
}
