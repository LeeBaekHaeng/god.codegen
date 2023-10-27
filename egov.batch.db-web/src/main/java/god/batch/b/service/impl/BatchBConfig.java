package god.batch.b.service.impl;

import java.util.List;

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

import egovframework.example.bat.domain.trade.CustomerCredit;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class BatchBConfig {

    private final JobBuilderFactory jobs;

    private final StepBuilderFactory steps;

    private final BatchBDAO batchBDAO;

    public BatchBConfig(JobBuilderFactory jobs, StepBuilderFactory steps, BatchBDAO batchBDAO) {
        super();
        this.jobs = jobs;
        this.steps = steps;
        this.batchBDAO = batchBDAO;
    }

    @Bean
    public Job batchBJob(Step batchBStep1) {
        return jobs.get("batchBJob").start(batchBStep1).build();
    }

    @Bean
    protected Step batchBStep1() {
        return steps.get("batchBStep1").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                log.debug("{}", this);
                log.debug("BatchBStep1");

                CustomerCredit customerCredit = new CustomerCredit();
                List<Integer> allCustomerCreditIds = batchBDAO.getAllCustomerCreditIds(customerCredit);

                for (Integer allCustomerCreditId : allCustomerCreditIds) {
                    log.debug("allCustomerCreditId={}", allCustomerCreditId);
                    contribution.incrementReadCount();
//                    contribution.incrementWriteCount(1);
//                    contribution.incrementReadSkipCount();
//                    contribution.incrementProcessSkipCount();
//                    contribution.incrementWriteSkipCount();
                }

                allCustomerCreditIds.forEach(a -> {
                    log.debug("a={}", a);
                });

                return RepeatStatus.FINISHED;
            }
        }).build();
    }

}
