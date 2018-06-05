package com.xxl.job.admin.config;

import com.xxl.job.admin.core.schedule.XxlJobDynamicScheduler;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

/**
 * XXL-Job-Admin 调度配置
 * <p>
 * Created by wfeng on 2018/6/4.
 */
@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class JobConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    private String configLocation;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setStartupDelay(20);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setConfigLocation(new ClassPathResource(configLocation));
        return schedulerFactoryBean;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public XxlJobDynamicScheduler xxlJobDynamicScheduler(SchedulerFactoryBean schedulerFactoryBean) {
        XxlJobDynamicScheduler xxlJobDynamicScheduler = new XxlJobDynamicScheduler();
        xxlJobDynamicScheduler.setScheduler(schedulerFactoryBean.getScheduler());
        xxlJobDynamicScheduler.setAccessToken("");
        return xxlJobDynamicScheduler;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, null);
        this.configLocation = propertyResolver.getProperty("quartz.configLocation");
    }
}
