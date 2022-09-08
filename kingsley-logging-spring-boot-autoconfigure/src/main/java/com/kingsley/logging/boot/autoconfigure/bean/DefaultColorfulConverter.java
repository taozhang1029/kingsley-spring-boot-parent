package com.kingsley.logging.boot.autoconfigure.bean;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;

/**
 * @author ZhangTao
 * @date 2022/9/4
 * @desc
 */
public class DefaultColorfulConverter extends ColorfulConverter {

    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        Level level = event.getLevel();
        switch (level.toInt()) {
            //ERROR等级为红色
            case Level.ERROR_INT:
                return ANSIConstants.RED_FG;
            //WARN等级为黄色
            case Level.WARN_INT:
                return ANSIConstants.YELLOW_FG;
            //INFO等级为绿色
            case Level.INFO_INT:
                return ANSIConstants.GREEN_FG;
            //DEBUG等级为白色
            case Level.DEBUG_INT:
                return ANSIConstants.WHITE_FG;
            //其他为默认颜色
            default:
                return ANSIConstants.DEFAULT_FG;
        }
    }
}
