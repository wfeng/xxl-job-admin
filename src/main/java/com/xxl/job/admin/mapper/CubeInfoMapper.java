package com.xxl.job.admin.mapper;

import com.xxl.job.admin.core.model.CubeInfo;
import org.apache.ibatis.annotations.Param;


/**
 * 数据立方表mapper
 *
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface CubeInfoMapper {

    int save(CubeInfo info);

    CubeInfo loadByCubeId(@Param("cubeId") String cubeId);

    int update(CubeInfo item);

    int delete(@Param("cubeId") String cubeId);

}
