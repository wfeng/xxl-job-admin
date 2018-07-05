package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.conf.XxlJobAdminConfig;
import com.xxl.job.admin.core.model.CubeDimensionInfo;
import com.xxl.job.admin.core.model.CubeInfo;
import com.xxl.job.admin.core.model.CubeSourceTable;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.util.I18nUtil;
import com.xxl.job.admin.mapper.CubeDimensionExecLogMapper;
import com.xxl.job.admin.mapper.CubeDimensionInfoMapper;
import com.xxl.job.admin.mapper.CubeInfoMapper;
import com.xxl.job.admin.mapper.CubeSourceTableMapper;
import com.xxl.job.admin.rest.vm.*;
import com.xxl.job.admin.service.CubeService;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据立方相关服务实现类
 * <p>
 * Created by wfeng on 2018/7/4.
 */
@Service
public class CubeServiceImpl implements CubeService {

    @Autowired
    CubeInfoMapper cubeInfoMapper;

    @Autowired
    CubeSourceTableMapper cubeSourceTableMapper;

    @Autowired
    CubeDimensionInfoMapper cubeDimensionInfoMapper;

    @Autowired
    CubeDimensionExecLogMapper cubeDimensionExecLogMapper;

    @Autowired
    XxlJobService xxlJobService;

    @Override
    public ReturnT<String> createCube(CreatCubeJobsRequestVM request) {
        //@TODO 记录立方数据，并根据维度表创建任务
        CubeInfo cubeInfo = cubeInfoMapper.loadByCubeId(request.getCudeId());

        //数据立方是否已创建
        if (cubeInfo != null) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, (I18nUtil.getString("cube_info") + I18nUtil.getString("system_already_exist")));
        }

        //立方定义的源表数据是否已存在
        List<CubeSourceTable> cubeSourceTableList = cubeSourceTableMapper.getSourceTableByCubeId(request.getCudeId());
        if (!cubeSourceTableList.isEmpty()) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, (I18nUtil.getString("cube_source_table") + I18nUtil.getString("system_already_exist")));
        }

        //立方定义的维度表数据是否已存在
        List<CubeDimensionInfo> cubeDimensionInfoList = cubeDimensionInfoMapper.getDimensionInfoByCubeId(request.getCudeId());
        if (!cubeDimensionInfoList.isEmpty()) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, (I18nUtil.getString("Cube_dimension_info") + I18nUtil.getString("system_already_exist")));
        }

        ModelMapper modelMapper = new ModelMapper();

        //数据立方赋值
        cubeInfo = modelMapper.map(request, CubeInfo.class);
        //保存数据立方信息
        cubeInfoMapper.save(cubeInfo);

        //保存源数据表
        List<SourceTableAttribute> sourceTableList = request.getSourceTableList();
        sourceTableList.forEach(sourceTable -> {
            //对象赋值
            CubeSourceTable cubeSourceTable = new CubeSourceTable();
            cubeSourceTable.setCubeId(request.getCudeId()); //立方编号
            cubeSourceTable.setPrimaryTable(sourceTable.isPrimaryTable() ? 1 : 0); //是否主表
            cubeSourceTable.setTableName(sourceTable.getTableName());
            //jdbc属性
            JdbcAttribute jdbcAttr = sourceTable.getJdbcAttr();
            cubeSourceTable.setJdbcUrl(jdbcAttr.getUrl());
            cubeSourceTable.setJdbcUsername(jdbcAttr.getUsername());
            cubeSourceTable.setJdbcPassword(jdbcAttr.getPassword());
            cubeSourceTable.setJdbcDriver(jdbcAttr.getDriver());
            cubeSourceTable.setJdbcFetchsize(jdbcAttr.getFetchsize());
            //分区属性
            ParallelAttribute parallelAttr = sourceTable.getParallelAttribute();
            if (parallelAttr != null) {
                cubeSourceTable.setParallelism(parallelAttr.getParallelism());
                cubeSourceTable.setParallelismFieldName(parallelAttr.getParallelismFieldName());
                cubeSourceTable.setParallelismType(parallelAttr.getParallelismType());
            }
            cubeSourceTableMapper.save(cubeSourceTable);
        });

        //判断是每日执行还是手动执行
        String triggerModel;
        if (StringUtils.isNotEmpty(request.getTriggerModel()) && request.getTriggerModel().equals(request.MANUAL)) {
            triggerModel = XxlJobAdminConfig.getAdminConfig().getJobCronManual();
        } else {
            triggerModel = XxlJobAdminConfig.getAdminConfig().getJobCronEveryDay();
        }

        //任务删除标记
        boolean jobsRemoveFlag = false;
        //成功创建任务列表
        List<Integer> jobList = new ArrayList<>();

        //根据维度信息创建xxl-job，并保存维度信息
        List<DimensionTableAttribute> dimensionTableList = request.getDimensionTableList();

        //循环遍历维度数据
        for (DimensionTableAttribute dimension : dimensionTableList) {

            //初始化任务属性
            XxlJobInfo jobInfo = new XxlJobInfo();

            //设置任务描述
            jobInfo.setJobDesc(dimension.getDescription());

            //设置系统定义任务属性
            jobInfo.setJobGroup(XxlJobAdminConfig.getAdminConfig().getJobGroup());
            jobInfo.setJobCron(triggerModel);
            jobInfo.setAuthor(XxlJobAdminConfig.getAdminConfig().getAuthor());
            jobInfo.setAlarmEmail(XxlJobAdminConfig.getAdminConfig().getAlarmEmail());
            jobInfo.setGlueType(XxlJobAdminConfig.getAdminConfig().getGlueType());
            jobInfo.setExecutorParam("");
            jobInfo.setExecutorFailStrategy(XxlJobAdminConfig.getAdminConfig().getExecutorFailStrategy());
            jobInfo.setExecutorRouteStrategy(XxlJobAdminConfig.getAdminConfig().getExecutorRouteStrategy());
            jobInfo.setExecutorHandler(XxlJobAdminConfig.getAdminConfig().getExecutorHandler());
            jobInfo.setExecutorBlockStrategy(XxlJobAdminConfig.getAdminConfig().getExecutorBlockStrategy());

            //xxl-job 添加任务
            ReturnT<String> runResult = xxlJobService.add(jobInfo);
            if (ReturnT.SUCCESS_CODE == runResult.getCode()) {
                jobList.add(jobInfo.getId());


                //根据返回的任务Id添加立方维度表数据
                CubeDimensionInfo cubeDim = new CubeDimensionInfo();

                cubeDim.setJobId(jobInfo.getId());
                cubeDim.setCubeId(request.getCudeId());
                cubeDim.setDescription(dimension.getDescription());
                cubeDim.setExecuteSql(dimension.getExecuteSql());
                cubeDim.setTableName(dimension.getTableName());
                cubeDim.setSaveMode(dimension.getSaveMode());
                //jdbc属性
                JdbcAttribute jdbcAttr = dimension.getJdbcAttr();
                cubeDim.setJdbcUrl(jdbcAttr.getUrl());
                cubeDim.setJdbcUsername(jdbcAttr.getUsername());
                cubeDim.setJdbcPassword(jdbcAttr.getPassword());
                cubeDim.setJdbcDriver(jdbcAttr.getDriver());
                cubeDim.setJdbcBatchsize(jdbcAttr.getBatchsize());

                //保存立方维度信息数据
                cubeDimensionInfoMapper.save(cubeDim);

            } else {
                jobsRemoveFlag = true;
                break;
            }
        }

        //任务创建失败，回滚已创建的任务
        if (jobsRemoveFlag) {
            for (int jobId : jobList) {
                xxlJobService.remove(jobId);
            }
            cubeDimensionInfoMapper.deleteByCubeId(request.getCudeId());
            cubeSourceTableMapper.deleteByCubeId(request.getCudeId());
            cubeInfoMapper.delete(request.getCudeId());
            return new ReturnT<String>(ReturnT.FAIL_CODE, (I18nUtil.getString("jobinfo_job") + I18nUtil.getString("system_add_fail")));
        }

        return ReturnT.SUCCESS;
    }
}
