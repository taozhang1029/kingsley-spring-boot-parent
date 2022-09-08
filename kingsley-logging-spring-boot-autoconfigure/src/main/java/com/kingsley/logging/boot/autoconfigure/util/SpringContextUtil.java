package com.kingsley.logging.boot.autoconfigure.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ZhangTao
 * @date 2022/9/4
 * @desc
 */
@Component
public class SpringContextUtil {

    private static ApplicationContext context;

    public SpringContextUtil(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
