package com.kingsley.logging.boot.autoconfigure.properties;

import com.kingsley.logging.boot.autoconfigure.bean.DefaultColorfulConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ZhangTao
 * @date 2022/9/4
 * @desc
 */
@ConfigurationProperties(prefix = "kingsley.logging")
public class LoggingProperties {

    private String context;

    private String logDir;

    private String consoleLevel = "DEBUG";
    private String colorfulConverterClass = DefaultColorfulConverter.class.getName();
    private String consolePattern = "%magenta(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %" + this.colorfulConverterClass + "(%-5level) %boldYellow(${PID:-}) %red([%-8.8X{traceId}]) %clr(%-30.30(%logger{30})){cyan} %clr(:) %msg %n";
    private String fileLevel = "DEBUG";

    private String filePattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %red([%-8.8X{traceId}]) %50.50logger{50} - %8.8([%line]): %msg%n";

    private String totalSizeCap = "20MB";

    private String maxFileSize = "2MB";

    private int maxHistoryDays = 15;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getLogDir() {
        return logDir;
    }

    public void setLogDir(String logDir) {
        this.logDir = logDir;
    }

    public String getConsoleLevel() {
        return consoleLevel;
    }

    public void setConsoleLevel(String consoleLevel) {
        this.consoleLevel = consoleLevel;
    }

    public String getConsolePattern() {
        return consolePattern;
    }

    public void setConsolePattern(String consolePattern) {
        this.consolePattern = consolePattern;
    }

    public String getColorfulConverterClass() {
        return colorfulConverterClass;
    }

    public void setColorfulConverterClass(String colorfulConverterClass) {
        this.colorfulConverterClass = colorfulConverterClass;
        if (this.consolePattern == null) {
            this.consolePattern = "%magenta(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %" + this.colorfulConverterClass + "(%-5level) %boldYellow(${PID:-}) %red([%-8.8X{traceId}]) %clr(%-30.30(%logger{30})){cyan} %clr(:) %msg %n";
        }
    }

    public String getFileLevel() {
        return fileLevel;
    }

    public void setFileLevel(String fileLevel) {
        this.fileLevel = fileLevel;
    }

    public String getFilePattern() {
        return filePattern;
    }

    public void setFilePattern(String filePattern) {
        this.filePattern = filePattern;
    }

    public String getTotalSizeCap() {
        return totalSizeCap;
    }

    public void setTotalSizeCap(String totalSizeCap) {
        this.totalSizeCap = totalSizeCap;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public int getMaxHistoryDays() {
        return maxHistoryDays;
    }

    public void setMaxHistoryDays(int maxHistoryDays) {
        this.maxHistoryDays = maxHistoryDays;
    }

    @Override
    public String toString() {
        return "LoggingProperties{" +
                "context='" + context + '\'' +
                ", logDir='" + logDir + '\'' +
                ", consoleLevel='" + consoleLevel + '\'' +
                ", colorfulConverterClass='" + colorfulConverterClass + '\'' +
                ", consolePattern='" + consolePattern + '\'' +
                ", fileLevel='" + fileLevel + '\'' +
                ", filePattern='" + filePattern + '\'' +
                ", totalSizeCap='" + totalSizeCap + '\'' +
                ", maxFileSize='" + maxFileSize + '\'' +
                ", maxHistoryDays=" + maxHistoryDays +
                '}';
    }
}
