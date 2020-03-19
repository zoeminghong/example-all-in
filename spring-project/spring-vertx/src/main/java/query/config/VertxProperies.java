package query.config;

import java.io.Serializable;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
public class VertxProperies implements Serializable {

    private Integer eventLoopPoolSize = 4;

    private Integer workerPoolSize = 100;

    private Integer internalBlockingPoolSize = 100;

    private Long maxWorkerExecuteTime = 20000000000L;

    private Long warningExceptionTime = 10000000000L;

    public Integer getEventLoopPoolSize() {
        return eventLoopPoolSize;
    }

    public VertxProperies setEventLoopPoolSize(Integer eventLoopPoolSize) {
        this.eventLoopPoolSize = eventLoopPoolSize;
        return this;
    }

    public Integer getWorkerPoolSize() {
        return workerPoolSize;
    }

    public VertxProperies setWorkerPoolSize(Integer workerPoolSize) {
        this.workerPoolSize = workerPoolSize;
        return this;
    }

    public Integer getInternalBlockingPoolSize() {
        return internalBlockingPoolSize;
    }

    public VertxProperies setInternalBlockingPoolSize(Integer internalBlockingPoolSize) {
        this.internalBlockingPoolSize = internalBlockingPoolSize;
        return this;
    }

    public Long getMaxWorkerExecuteTime() {
        return maxWorkerExecuteTime;
    }

    public VertxProperies setMaxWorkerExecuteTime(Long maxWorkerExecuteTime) {
        this.maxWorkerExecuteTime = maxWorkerExecuteTime;
        return this;
    }

    public Long getWarningExceptionTime() {
        return warningExceptionTime;
    }

    public VertxProperies setWarningExceptionTime(Long warningExceptionTime) {
        this.warningExceptionTime = warningExceptionTime;
        return this;
    }
}
