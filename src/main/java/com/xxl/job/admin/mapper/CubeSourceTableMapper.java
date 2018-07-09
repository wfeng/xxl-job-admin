package com.xxl.job.admin.mapper;

import com.xxl.job.admin.core.model.CubeSourceTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 数据立方表mapper
 *
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface CubeSourceTableMapper {

    int save(CubeSourceTable info);

    CubeSourceTable loadById(@Param("id") int id);

    List<CubeSourceTable> getSourceTableByCubeId(@Param("cubeId") String cubeId);

    int update(CubeSourceTable item);

    int delete(@Param("id") int id);

    int deleteByCubeId(@Param("cubeId") String cubeId);

}
