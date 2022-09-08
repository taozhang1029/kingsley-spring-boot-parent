package com.kingsley.logging.boot.autoconfigure.bean;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 * @author ZhangTao
 * @date 2022/9/4
 * @desc
 */
public abstract class ColorfulConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {
}
