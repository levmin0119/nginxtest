package com.levmin.nginxtest.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;


public class CodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create(
                "jdbc:mysql://192.168.1.176:3306/levmin"
                        + "?useSSL=false"
                        + "&useUnicode=true"
                        + "&characterEncoding=utf8"
                        + "&serverTimezone=Asia/Shanghai"
                        + "&allowPublicKeyRetrieval=true",
                "root",
                "Zy5201ljf&"
        ).globalConfig(builder -> {
            builder.author("zhangyue")
                    .outputDir(System.getProperty("user.dir")+"/src/main/java")
                    .disableOpenDir();
        }).packageConfig(builder -> {
            builder.parent("com.levmin.nginxtest")
                    .entity("entity")
                    .mapper("mapper")
                    .pathInfo(Collections.singletonMap(
                            OutputFile.xml,
                            System.getProperty("user.dir")+"/src/main/resources/com/levmin/nginxtest/mapper"
                    ));
        }).strategyConfig(builder -> {
            builder.addInclude("user_account").entityBuilder()
                    .enableTableFieldAnnotation()
                    .mapperBuilder()
                    .enableMapperAnnotation()
                    .enableBaseResultMap();
        }).execute();
    }
}
