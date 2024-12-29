package com.example.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//We can manage it from here, but we manage from Application class

//@Configuration
//@EnableTransactionManagement
//public class TransactionConfig {
//
//    @Bean
//    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
//        return new MongoTransactionManager(dbFactory);
//    }
//}
