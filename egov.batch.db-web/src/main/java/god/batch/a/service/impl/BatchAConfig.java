package god.batch.a.service.impl;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class BatchAConfig {

    private final JobBuilderFactory jobs;

    private final StepBuilderFactory steps;

    @Bean
    public Job batchAJob(Step batchAStep1, Step batchAStep2) {
        return jobs.get("batchAJob").start(batchAStep1).next(batchAStep2).build();
    }

    @Bean
    protected Step batchAStep1() {
        return steps.get("batchAStep1").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                log.debug("batchAStep1");

                System.out.println(this);
                System.out.println("batchAStep1");

                List<String> readLines = FileUtils.readLines(new File("target/classes/db/sampledb.script"),
                        StandardCharsets.UTF_8);
                for (String readLine : readLines) {
                    System.out.println(readLine);
                    contribution.incrementReadCount();
                    contribution.incrementWriteCount(1);
                    contribution.incrementReadSkipCount();
                    contribution.incrementProcessSkipCount();
                    contribution.incrementWriteSkipCount();
                }

                Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();
                jobParameters.keySet().forEach(System.out::println);
                System.out.println(jobParameters.get("timestamp"));
                System.out.println(jobParameters.get("timestamp").getClass().getName());

                System.out.println("jobParameters key value");
                jobParameters.forEach((key, value) -> {
                    System.out.println(key);
                    System.out.println(value);
                    System.out.println();
                });

                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    protected Step batchAStep2() {
        return steps.get("batchAStep2").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println(this);
                System.out.println("batchAStep2");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

}
