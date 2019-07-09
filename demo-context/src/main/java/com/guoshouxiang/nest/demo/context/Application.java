package com.guoshouxiang.nest.demo.context;

import com.guohuoxiang.nest.mybatis.pagination.PageListPlugin;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    public PageListPlugin getPageListPlugin() {
        return new PageListPlugin();
    }

    @Bean
    public Mapper mapper(@Value(value = "classpath*:dozer/*mapper.xml") Resource[] resourceArray) throws IOException {
        List<String> mappingFileUrlList = new ArrayList<>();
        for (Resource resource : resourceArray) {
            mappingFileUrlList.add(String.valueOf(resource.getURL()));
        }
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFileUrlList);
        return dozerBeanMapper;
    }
}
