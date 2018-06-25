package com.xxl.job.admin.mapper;

import com.xxl.job.admin.core.model.XxlJobInfoExt;
import org.apache.ibatis.annotations.Param;


/**
 * job info
 *
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface XxlJobInfoExtMapper {

    int save(XxlJobInfoExt info);

    XxlJobInfoExt loadById(@Param("id") int id);

    XxlJobInfoExt loadByJobId(@Param("jobId") int jobId);

    int update(XxlJobInfoExt item);

    int delete(@Param("id") int id);

}
