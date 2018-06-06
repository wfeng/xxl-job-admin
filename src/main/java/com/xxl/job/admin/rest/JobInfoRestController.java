package com.xxl.job.admin.rest;

import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wfeng on 2018/6/6.
 */
@RestController
@RequestMapping("/api/jobinfo")
@Api(description = "任务管理接口")
public class JobInfoRestController {

    @Resource
    private XxlJobService xxlJobService;

    @ApiOperation(value = "搜索任务接口", notes = "")
    @GetMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length,
                                        int jobGroup, String jobDesc, String executorHandler, String filterTime) {

        return xxlJobService.pageList(start, length, jobGroup, jobDesc, executorHandler, filterTime);
    }

    @ApiOperation(value = "执行任务管理接口", notes = "")
    @GetMapping("/trigger/{id}")
    public ReturnT<String> triggerJob(@PathVariable int id) {
        return xxlJobService.triggerJob(id);
    }
}
