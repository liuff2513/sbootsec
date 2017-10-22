package com.sec.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ClassName: EnvironmentUtil
 * @Description: 配置属性工具类,用户获取配置属性
 * <p>@Component实现将该工具类bean交由spring管理初始化和销毁</p>
 * @author feifei.liu
 * @date 2017/6/28 10:28
 */
@Component
public class EnvironmentUtil {
    private static EnvironmentUtil environmentUtil;
    @Autowired
    private Environment env;
    /**
     * @Description: @PostConstruct实现对象初始化时为env赋值
     * 
     * @author feifei.liu
     * @date 2017/6/28 11:06
     */
    @PostConstruct
    public void init() {
        environmentUtil = this;
        environmentUtil.env = env;
    }
    /**
     * @Description: 实例对象获取
     *
     * @return PropertyUtil对象
     * @author feifei.liu
     * @date 2017/6/28 10:37
     */
    public EnvironmentUtil getInstance() {
        return environmentUtil;
    }

    /**
     * @Description: 是否包含某个属性
     *
     * @param key 属性
     * @return boolean
     * @author feifei.liu
     * @date 2017/6/28 10:36
     */
    public static boolean containsProperty(String key) {
        return environmentUtil.env.containsProperty(key);
    }

    /**
     * @Description: 获取属性值 如果找不到返回null
     *
     * @param key 属性
     * @return 属性值
     * @author feifei.liu
     * @date 2017/6/28 10:30
     */
    public static String getProperty(String key) {
        return environmentUtil.env.getProperty(key);
    }

    /**
     * @Description: 获取属性值，如果找不到返回默认值
     * 
     * @param key 属性
     * @param defaultValue 默认值
     * @return 属性值
     * @author feifei.liu
     * @date 2017/6/28 10:45
     */
    public static String getProperty(String key, String defaultValue) {
        return environmentUtil.env.getProperty(key, defaultValue);
    }

    /**
     * @Description: 获取指定类型的属性值，找不到返回null
     *
     * @param key 属性
     * @param clazz 属性类型
     * @param <T> T 返回类型
     * @return 属性对象
     * @author feifei.liu
     * @date 2017/6/28 10:32
     */
    public static <T> T getProperty(String key, Class<T> clazz) {
        return environmentUtil.env.getProperty(key, clazz);
    }

    /**
     * @Description: 获取属性值，找不到抛出异常IllegalStateException
     *
     * @param key 属性
     * @return 属性值
     * @throws IllegalStateException
     * @author feifei.liu
     * @date 2017/6/28 10:54
     */
    public static String getRequiredProperty(String key) throws IllegalStateException {
        return environmentUtil.env.getRequiredProperty(key);
    }

    /**
     * @Description: 获取指定类型的属性值，找不到返回默认值
     *
     * @param key 属性
     * @param clazz 属性类型
     * @param defaultValue 默认值
     * @param <T> T 返回类型
     * @return 属性对象
     * @author feifei.liu
     * @date 2017/6/28 10:50
     */
    public static <T> T getProperty(String key, Class<T> clazz, T defaultValue) {
        return environmentUtil.env.getProperty(key, clazz, defaultValue);
    }

    /**
     * @Description: 获取属性值为某个Class类型，找不到返回null，如果类型不兼容将抛出ConversionException
     *
     * @param key 属性
     * @param clazz 属性类型
     * @param <T> T 返回类型
     * @return 属性对象
     * @author feifei.liu
     * @date 2017/6/28 10:53
     */
    public static <T> Class<T> getPropertyAsClass(String key, Class<T> clazz) {
        return environmentUtil.env.getPropertyAsClass(key, clazz);
    }

    /**
     * @Description: 获取指定类型的属性值，找不到抛出异常IllegalStateException
     *
     * @param key 属性
     * @param clazz 属性类型
     * @return 属性对象
     * @param <T> T 返回类型
     * @throws IllegalStateException
     * @author feifei.liu
     * @date 2017/6/28 10:54
     */
    public static <T> T getRequiredProperty(String key, Class<T> clazz) throws IllegalStateException {
        return environmentUtil.env.getRequiredProperty(key, clazz);
    }

    /**
     * @Description: 替换文本中的占位符（${key}）到属性值，找不到不解析
     *
     * @param text 占位符
     * @return String
     * @author feifei.liu
     * @date 2017/6/28 10:58
     */
    public String resolvePlaceholders(String text) {
        return environmentUtil.env.resolvePlaceholders(text);
    }

    /**
     * @Description: 替换文本中的占位符（${key}）到属性值，找不到抛出异常IllegalArgumentException
     *
     * @param text 占位符
     * @return String
     * @throws IllegalArgumentException
     * @author feifei.liu
     * @date 2017/6/28 10:58
     */
    public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
        return environmentUtil.env.resolveRequiredPlaceholders(text);
    }

}
