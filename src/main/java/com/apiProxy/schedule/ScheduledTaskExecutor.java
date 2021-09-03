package com.apiProxy.schedule;

import com.apiProxy.mbg.po.Jacoco;
import com.apiProxy.service.JacocoServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author：hem
 * @Date：6/26/21 6:55 下午
 */
@Slf4j
@Component
public class ScheduledTaskExecutor {

    @Autowired
    private JacocoServer jacocoServer;

    @Autowired
    private CreatReportTaskExecutor creatReportTaskExecutor;
    /**
     * 提交创建jacoco报告任务
     */
    @Transactional
    @Scheduled(fixedRate = 15000)
    public void statisticsFinishedTestTask() {
        List<Jacoco> jacocos = jacocoServer.getUnFinishedTasks();
        if (CollectionUtils.isEmpty(jacocos)) {
            return;
        }
        creatReportTaskExecutor.commitTestTask(jacocos.get(0));
        Jacoco update = jacocos.get(0);
        update.setTaskStatus(1);
        jacocoServer.update(update);
    }
}
