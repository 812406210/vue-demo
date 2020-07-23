package com.vue.demo.test;

/**
 * @author yangwj
 * @date 2020/5/23 11:03
 */
import lombok.SneakyThrows;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5Util {
    /**
     * 一次性处理的文件字节数
     */
    private static final int ONE_HANDLE_FILE_BYTE_COUNT = 8192;

    /**
     * MD5 算法
     */
    private static final String MD5_ALGORITHM = "MD5";

    /**
     * 无数据的索引值
     */
    private static final int NOT_DATA_INDEX = -1;

    /**
     * 正数符号
     */
    private static final int POSITIVE_SIGN = 1;

    /**
     * 十六进制
     */
    private static final int HEXADECIMAL = 16;

    /**
     * 生成文件内容的 MD5 值
     *
     * @param file
     * @return
     */
    public static String generateMD5(File file) {
        if (!file.isFile())//不是文件
            return null;

        MessageDigest digest;
        FileInputStream in = null;
        byte buffer[] = new byte[ONE_HANDLE_FILE_BYTE_COUNT];
        int len;
        try {
            digest = MessageDigest.getInstance(MD5_ALGORITHM);
            in = new FileInputStream(file);

            while ((len = in.read(buffer)) != NOT_DATA_INDEX) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInteger = new BigInteger(POSITIVE_SIGN, digest.digest());
            return bigInteger.toString(HEXADECIMAL);
        } catch (NoSuchAlgorithmException e) {
            //logger.error(" 生成文件内容的 MD5", e);
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            //logger.error(" 生成文件内容的 MD5", e);
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // logger.error(" 生成文件内容的 MD5", e);
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
                // logger.error("关闭文件", e);
            }
        }
    }

        @SneakyThrows
        public static void main (String[]args){
            String md5 = MD5Util.generateMD5( new File("D:\\1.txt"));
            System.out.println(md5);
            System.out.println("########################");
            InputStream is = new FileInputStream(new File("D:\\1.txt"));
            String md5Hex = DigestUtils.md5DigestAsHex(is);
            System.out.println(md5Hex);
            System.out.println("########################");
            String md5s= DigestUtils.md5DigestAsHex("11111".getBytes());
            System.out.println(md5s);
            File f= new File("D:\\2.txt");



        }

}