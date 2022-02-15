package com.talcorpdz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.talcorpdz.config.mongo.MongoDBConfig;
import com.talcorpdz.spec.config.domain.converter.ConverterConfiguration;

@Configuration
@Import({MongoDBConfig.class,ConverterConfiguration.class})
public class Configue {

}
