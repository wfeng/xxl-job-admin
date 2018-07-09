package com.xxl.job.admin.mapper;

import com.xxl.job.admin.core.model.CubeDimensionExecLog;
import org.apache.ibatis.annotations.Param;


/**
 * 数据立方表mapper
 *
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface CubeDimensionExecLogMapper {

    int save(CubeDimensionExecLog info);

    CubeDimensionExecLog loadById(@Param("id") int id);

    int update(CubeDimensionExecLog item);

    int delete(@Param("id") int id);

    int deleteByCubeId(@Param("cubeId") String cubeId);

    CubeDimensionExecLog loadByJobLogId(@Param("jobLogId") int jobLogId);

    CubeDimensionExecLog getLastOneLogByJobId(@Param("jobId") int jobId);
}
