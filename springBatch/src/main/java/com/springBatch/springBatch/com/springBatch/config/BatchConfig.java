package com.springBatch.springBatch.com.springBatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.springBatch.springBatch.com.springBatch.model.Products;
import com.springBatch.springBatch.com.springBatch.springBatch.CustomItemProcessor;
import com.springBatch.springBatch.com.springBatch.springBatch.JobCompletionNotificationImpl;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
    Job jobBean(JobRepository jobRepository,
                          JobCompletionNotificationImpl listener,
                          Step steps
                          ) {
        return new JobBuilder("job", jobRepository)
                .listener(listener)
                .start(steps)
                .build();
    }

    @Bean
    Step steps(
             JobRepository jobRepository,
             DataSourceTransactionManager transactionManager,
             ItemReader<Products> reader,
             ItemProcessor<Products, Products> processor,
             ItemWriter<Products> writer
             ) {
        return new StepBuilder("jobStep", jobRepository)
                .<Products,Products>chunk(5000, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

    }

    //    reader
    @Bean
    FlatFileItemReader<Products> reader() {
        return new FlatFileItemReaderBuilder<Products>()
                .name("itemReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names("productId", "title", "description", "price", "discount")
                .targetType(Products.class)
                .build();
    }

//    processor

    @Bean
    ItemProcessor<Products, Products> itemProcessor() {
        return new CustomItemProcessor();
    }

//    writer

    @Bean
    ItemWriter<Products> itemWriter(DataSource dataSource) {

        return new JdbcBatchItemWriterBuilder<Products>()
                .sql("insert into products(productId,title,description,price,discount)values(:productId, :title, :description, :price, :discount)")
                .dataSource(dataSource)
                .beanMapped()
                .build();

    }


}
