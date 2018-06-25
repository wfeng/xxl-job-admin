package com.xxl.job.admin.rest;

import com.alibaba.fastjson.JSONObject;
import com.xxl.job.admin.core.conf.XxlJobAdminConfig;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.model.XxlJobInfoExt;
import com.xxl.job.admin.rest.vm.JobInfoRequestVM;
import com.xxl.job.admin.rest.vm.JobInfoResponseVM;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.util.JacksonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
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

    private static final Logger logger = LoggerFactory.getLogger(JobInfoRestController.class);

    @Resource
    private XxlJobService xxlJobService;

    @ApiOperation(value = "搜索任务接口", notes = "")
    @GetMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length,
                                        int jobGroup, String jobDesc, String executorHandler, String filterTime) {

        return xxlJobService.pageList(start, length, jobGroup, jobDesc, executorHandler, filterTime);
    }

    @ApiOperation(value = "新增任务接口", notes = "")
    @PostMapping("/add")
    public ReturnT<JobInfoResponseVM> add(@RequestBody JobInfoRequestVM requestVM) {
        logger.info("执行新增任务接口");

        //定义任务对象
        XxlJobInfo jobInfo;

        //复制请求对象中任务属性
        ModelMapper modelMapper = new ModelMapper();
        jobInfo = modelMapper.map(requestVM, XxlJobInfo.class);

        //设置系统定义任务属性
        jobInfo.setJobGroup(XxlJobAdminConfig.getAdminConfig().getJobGroup());
        jobInfo.setExecutorRouteStrategy(XxlJobAdminConfig.getAdminConfig().getExecutorRouteStrategy());
        jobInfo.setGlueType(XxlJobAdminConfig.getAdminConfig().getGlueType());
        jobInfo.setExecutorHandler(XxlJobAdminConfig.getAdminConfig().getExecutorHandler());
        jobInfo.setExecutorBlockStrategy(XxlJobAdminConfig.getAdminConfig().getExecutorBlockStrategy());

        //报警邮箱不能为NULL
        if (StringUtils.isEmpty(jobInfo.getAlarmEmail())) {
            jobInfo.setAlarmEmail("");
        }

        logger.info("jobInfo:" + JacksonUtil.writeValueAsString(jobInfo));
        //添加任务逻辑
        ReturnT<String> runResult = xxlJobService.add(jobInfo);
        logger.info("runResult:" + JacksonUtil.writeValueAsString(runResult));
        //添加任务返回结果判断
        //添加成功
        if (ReturnT.SUCCESS_CODE == runResult.getCode()) {
            //@todo 任务添加成功后，是否需要立刻执行?
            logger.info("jobInfo:" + JacksonUtil.writeValueAsString(jobInfo));

            //保存任务扩展信息
            XxlJobInfoExt jobInfoExt = new XxlJobInfoExt();
            jobInfoExt.setJobId(jobInfo.getId());
            //模型处理
            jobInfoExt.setCalculateModel(JSONObject.toJSONString(requestVM.getCalculateModel()));
            //任务扩展信息保存结果
            ReturnT<String> result = xxlJobService.addExt(jobInfoExt);
            //保存信息成功，则返回任务编号
            if (ReturnT.SUCCESS_CODE == runResult.getCode()) {

                //更新任务参数
                jobInfo.setExecutorParam("JobId:" + jobInfo.getId());
                xxlJobService.update(jobInfo);

                JobInfoResponseVM responseVM = new JobInfoResponseVM();
                responseVM.setJobId(jobInfo.getId());
                return new ReturnT(responseVM);
            } else {
                //扩展信息保存失败，删除任务主体
                xxlJobService.remove(jobInfo.getId());
                return new ReturnT(ReturnT.FAIL_CODE, result.getMsg());
            }

//            CalculateModel calculateModel = JSONObject.parseObject(jobInfo.getExecutorParam(), CalculateModel.class);
            //添加失败
        } else {
            //@todo 任务添加失败后，如何报错
            return new ReturnT(ReturnT.FAIL_CODE, runResult.getMsg());
        }
    }

    @ApiOperation(value = "执行任务接口", notes = "")
    @GetMapping("/trigger/{id}")
    public ReturnT<String> triggerJob(@PathVariable int id) {
        return xxlJobService.triggerJob(id);
    }
}
