package com.xxl.job.admin.mapper;

import com.xxl.job.admin.core.model.XxlJobGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
public interface XxlJobGroupMapper {

    List<XxlJobGroup> findAll();

    List<XxlJobGroup> findByAddressType(@Param("addressType") int addressType);

    int save(XxlJobGroup xxlJobGroup);

    int update(XxlJobGroup xxlJobGroup);

    int remove(@Param("id") int id);

    XxlJobGroup load(@Param("id") int id);
}
