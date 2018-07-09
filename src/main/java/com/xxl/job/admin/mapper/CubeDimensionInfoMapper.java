package com.xxl.job.admin.mapper;

import com.xxl.job.admin.core.model.CubeDimensionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 数据立方表mapper
 *
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface CubeDimensionInfoMapper {

    int save(CubeDimensionInfo info);

    CubeDimensionInfo loadById(@Param("id") int id);

    CubeDimensionInfo loadByJobId(@Param("jobId") int jobId);

    int update(CubeDimensionInfo item);

    int delete(@Param("id") int id);

    int deleteByCubeId(@Param("cubeId") String cubeId);

    List<CubeDimensionInfo> getDimensionInfoByCubeId(@Param("cubeId") String cubeId);

    CubeDimensionInfo getDimensionInfoByDimTableName(@Param("cubeId") String cubeId, @Param("dimTableName") String dimTableName);
}
