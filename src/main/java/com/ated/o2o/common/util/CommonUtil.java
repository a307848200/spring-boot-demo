package com.ated.o2o.common.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 通用工具类
 * @author zengwx
 * @date 2017-09-30
 */
public class CommonUtil {

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 读取txt文件每一行的数据，转换成list返回
     * @param file
     * @return
     */
    public static List<String> txt2String(File file){
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        try{
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            //使用readLine方法，一次读一行
            while((s = br.readLine())!=null){
                list.add(s);
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 生成固定位数随机码
     *
     * @param num
     * @return
     */
    public static String getRandomCode(Integer num) {
        String eqCode = "" + pjwHash("" + System.currentTimeMillis());
        if (eqCode.length() != num) {
            do {
                eqCode = "" + pjwHash("" + System.currentTimeMillis());
            } while (eqCode.length() != num);
        }
        return eqCode;
    }

    /**
     * 生成算法
     *
     * @param str
     * @return
     */
    public static long pjwHash(String str) {
        // 定义随机类
        Random random = new Random();
        int result = random.nextInt(1000);
        str = str + System.currentTimeMillis() + result;
        long BitsInUnsignedInt = (long) (4 * 8);
        long ThreeQuarters = (long) ((BitsInUnsignedInt * 3) / 4);
        long OneEighth = (long) (BitsInUnsignedInt / 8);
        long HighBits = (long) (0xFFFFFFFF) << (BitsInUnsignedInt - OneEighth);
        long hash = 0;
        long test = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash << OneEighth) + str.charAt(i);
            if ((test = hash & HighBits) != 0) {
                hash = ((hash ^ (test >> ThreeQuarters)) & (~HighBits));
            }
        }
        return hash;
    }

    /**
     * 是否使用 redis
     * @return
     */
    public static boolean isUseRedis(){
        return true;
    }


    /**
     * 倒序数组
     * @param numArr
     * @return
     */
    public static Object[] backSort(Object[] numArr) {
        Object[] finalArr = new Object[0];
        for(int i = numArr.length - 1; i >= 0; i --) {
            finalArr = joinNewArr(finalArr, numArr[i]);
        }
        numArr = finalArr;
        return numArr;
    }

    public static Object[] joinNewArr (Object[] arr, Object num) {
        Object[] midArr = new Object[arr.length + 1];
        if(arr.length == 0) {
            midArr[0] = num;
        }else {
            System.arraycopy(arr, 0, midArr, 0, arr.length);
            midArr[midArr.length - 1] = num;
        }
        return midArr;
    }

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj)) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 判断对象是否不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj)) {
                b = false;
            } else {
                b = true;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 转Integer
     *
     * @param obj
     */
    public static Integer toInteger(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return Integer.parseInt(obj.toString());
            } else {
                throw new Exception("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转String
     *
     * @param obj
     */
    public static String toString(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return obj.toString();
            } else {
                throw new Exception("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 去除特殊字符
     *
     * @param obj
     */
    public static String rinseString(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return obj.toString().replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5`~!@#$%^&*()_+-=/|、\\;:<>.。,，？?/、’‘；']","");
            } else {
                throw new Exception("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转Double
     *
     * @param obj
     */
    public static Double toDouble(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return Double.parseDouble(obj.toString());
            } else {
                throw new Exception("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验是否是double数据
     *
     */
    public static boolean isDouble(Object obj) {
        try {
            Double.parseDouble(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断浏览器
     *
     * @return 1:微信浏览器,99:其他浏览器
     */
    public static Integer judgeBrowser(HttpServletRequest request) {
        Integer result = null;
        String ua = request.getHeader("user-agent")
                .toLowerCase();
        // 微信-1
        if (ua.indexOf("micromessenger") > 0) {
            result = 1;
        } else {//其他 -99
            result = 99;
        }
        return result;
    }
    public static String getCode() {
        Long date = System.currentTimeMillis();
        String cardNo = date.toString().substring(1);
        return cardNo;
    }

    /**
     * 四舍五入精确两位小数
     * @param f
     * @return
     */
    public static Double getDouble(Double f){
        // 方式一：
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

}
