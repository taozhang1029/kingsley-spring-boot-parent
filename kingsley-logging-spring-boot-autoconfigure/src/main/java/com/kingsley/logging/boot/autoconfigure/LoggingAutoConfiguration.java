package com.kingsley.logging.boot.autoconfigure;

import com.kingsley.logging.boot.autoconfigure.properties.LoggingProperties;
import com.kingsley.logging.boot.autoconfigure.trace.TraceIdGenerateStrategy;
import com.kingsley.logging.boot.autoconfigure.trace.UUIDTraceIdGenerateStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhangTao
 * @date 2022/9/4
 * @desc
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
public class LoggingAutoConfiguration {

    public LoggingAutoConfiguration(LoggingProperties properties) {
        log.info("kingsley.logging.context: {}", properties.getContext());
        log.info("kingsley.logging.logDir: {}", properties.getLogDir());
        log.info("kingsley.logging.consoleLevel: {}", properties.getConsoleLevel());
        log.info("kingsley.logging.consolePattern: {}", properties.getConsolePattern());
        log.info("kingsley.logging.colorfulConverterClass: {}", properties.getColorfulConverterClass());
        log.info("kingsley.logging.fileLevel: {}", properties.getFileLevel());
        log.info("kingsley.logging.filePattern: {}", properties.getFilePattern());
        log.info("kingsley.logging.maxFileSize: {}", properties.getMaxFileSize());
        log.info("kingsley.logging.totalSizeCap: {}", properties.getTotalSizeCap());
        log.info("kingsley.logging.maxHistoryDays: {}", properties.getMaxHistoryDays());
    }

    @Bean
    @ConditionalOnMissingBean(TraceIdGenerateStrategy.class)
    public TraceIdGenerateStrategy traceIdGenerateStrategy() {
        return new UUIDTraceIdGenerateStrategy();
    }

}
