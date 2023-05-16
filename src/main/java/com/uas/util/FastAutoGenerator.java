package com.uas.util;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;

import java.util.Collections;

/**
 * Mybatis-Plus 自动生成工具类
 */
public class FastAutoGenerator {

    private static final String CODE_PATH = System.getProperty("user.dir") + "\\src\\main\\java";

    /**
     * 数据源配置
     */
    private static final DataSourceConfig dataSourceConfig = new DataSourceConfig
            .Builder("jdbc:mysql://127.0.0.1:3306/uas?serverTimezone=Asia/Shanghai", "root", "root123")
            .schema("uas")
            .build();

    /**
     * 策略配置
     */
    private static final StrategyConfig strategyConfig = new StrategyConfig.Builder()
//            .addInclude("activity")
            .build();

    /**
     * 全局配置
     */
    private static final GlobalConfig globalConfig = new GlobalConfig.Builder()
            .author("tallon")
//            .enableSwagger()
            .fileOverride()
//            .disableOpenDir()
            .outputDir(CODE_PATH)
            .build();

    /**
     * 包配置
     */
    private static final PackageConfig packageConfig = new PackageConfig.Builder()
            .parent("com")
            .moduleName("uas")
            .pathInfo(Collections.singletonMap(OutputFile.xml, CODE_PATH))
            .build();

    /**
     * 模板配置
     */
    private static final TemplateConfig templateConfig = new TemplateConfig.Builder()
            .build();


    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator(dataSourceConfig);
        generator.packageInfo(packageConfig);
        generator.template(templateConfig);
        generator.strategy(strategyConfig);
        generator.global(globalConfig);

        generator.execute();

    }
}