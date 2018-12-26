package com.blog.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {
    /**
     * 博客内容文件的保存路径
     */
    public static final String BLOG_SAVE_PATH = "D:\\blogs";

    /**
     * 将字符串写入文件操作，字节流的操作
     *
     * @param str      需要写入的字符串
     * @param root     文件保存的目录
     * @param filename 保存的文本文件名
     * @throws IOException
     */
    public static void OutPutString(String str, String root, String filename) throws IOException {
        String path = root + "\\" + filename;
        //System.out.println(path);
        File file = new File(root);
        if (!file.exists()) {
            boolean b = file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(new File(path));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] bytes = new byte[1024];
        bytes = str.getBytes(StandardCharsets.UTF_8);
        bos.write(bytes, 0, bytes.length);
        //关闭顺序不能调
        bos.close();
        fos.close();
    }

    /**
     * 将字符串从文本文件中读取出来的操作，字节流操作
     * @param root 文件所在目录
     * @param filename 文件名
     * @return 从文件中读取的字符串
     * @throws IOException
     */
    public static StringBuffer InputString(String root, String filename) throws IOException {
        String path = root + "\\" + filename;
        File file = new File(path);
        StringBuffer content = new StringBuffer();
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes, 0, bytes.length)) != -1) {
                String str = new String(bytes, 0, len, StandardCharsets.UTF_8);
                content.append(str);
            }
            //关闭顺序不能调
            bis.close();
            fis.close();
        }else {
            throw new FileNotFoundException(path+" 文件不存在");
        }
        return content;
    }

    /**
     * 删除指定文件
     * @param root 文件所在目录
     * @param filename 文件名
     * @throws FileNotFoundException
     */
    public static void DeleteFile(String root, String filename) throws FileNotFoundException {
        String path = root + "\\" + filename;
        File file = new File(path);
        if (file.exists()) {
            boolean b = file.delete();
        } else {
            throw new FileNotFoundException(path + " 文件不存在");
        }
    }
}
