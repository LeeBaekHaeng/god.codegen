package egovframework.example.bat.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.egovframe.rte.bat.core.launch.support.EgovBatchRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.StepExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 배치실행개발팀
 * @since 2012. 07.20
 * @version 1.0
 * @see <pre>
 *      개정이력(Modification Information)
 *
 *  수정일               수정자                 수정내용
 *  ----------   -----------   ----------------
 *  2012.07.20   배치실행개발팀       최초 생성
 *  2021.11.18   신용호                 배치실행환경 v4.0 적용
 * </pre>
 */

@Controller
public class BatchRunController {

	@Autowired
	private EgovBatchRunner egovBatchRunner;

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchRunController.class);

	@RequestMapping(value = "/batchList.do", method = RequestMethod.GET)
	public String getBatchList(ModelMap model) {

		model.addAttribute("jobList", egovBatchRunner.getJobNames());

		return "bat/web/EgovBatchList";
	}

	@RequestMapping(value = "/batchRun.do", method = RequestMethod.POST)
	public String batchRun(@RequestParam(value = "jobName", required = false) String jobName, Model model) {

		try {

			Long executionId = egovBatchRunner.start(jobName, getUniqueJobParameters(jobName));
			JobExecution jobExecution = egovBatchRunner.getJobExecution(executionId);
			JobInstance jobInstance = egovBatchRunner.getJobInstance(executionId);

			HashMap<String, Object> jobInstances = new HashMap<String, Object>();

			jobInstances.put("id", jobInstance.getId());
			jobInstances.put("name", jobInstance.getJobName());
			jobInstances.put("parameters", jobExecution.getJobParameters());
			jobInstances.put("startTime", jobExecution.getStartTime());
			jobInstances.put("endTime", jobExecution.getEndTime());
			jobInstances.put("isRunning", jobExecution.getStatus().isRunning());
			jobInstances.put("exitStatus", jobExecution.getExitStatus().getExitCode());

			List<HashMap<String, Object>> stepsInfo = new ArrayList<HashMap<String, Object>>();

			Iterator<StepExecution> iterator = jobExecution.getStepExecutions().iterator();

			while (iterator.hasNext()) {
				HashMap<String, Object> stepInfo = new HashMap<String, Object>();
				StepExecution stepExecution = iterator.next();

				stepInfo.put("stepId", stepExecution.getId());
				stepInfo.put("stepName", stepExecution.getStepName());
				stepInfo.put("readCount", stepExecution.getReadCount());
				stepInfo.put("writeCount", stepExecution.getWriteCount());
				stepInfo.put("readSkipCount", stepExecution.getReadSkipCount());
				stepInfo.put("processSkipCount", stepExecution.getProcessSkipCount());
				stepInfo.put("writeSkipCount", stepExecution.getWriteSkipCount());
				stepInfo.put("totalSkipCount", stepExecution.getSkipCount());
				stepInfo.put("commitCount", stepExecution.getCommitCount());
				stepInfo.put("rollbackCount", stepExecution.getRollbackCount());
				stepInfo.put("exitStatus", stepExecution.getExitStatus().getExitCode());

				stepsInfo.add(stepInfo);
			}

			model.addAttribute("jobInstances", jobInstances);
			model.addAttribute("stepsInfo", stepsInfo);

		} catch (Exception e) {
			LOGGER.debug(e.toString());
		}

		return "bat/web/EgovBatchRunResult";
	}

	protected String getUniqueJobParameters(String jobName) {

		String paramters = egovBatchRunner.createUniqueJobParameters();
		
		String homePath = System.getProperty("user.home");
		homePath = homePath.replace("\\", "/"); // Windows, macOS, Linux 동일하도록 수정

		if ("mybatisToFixedLengthJob".equals(jobName)) {
			paramters = egovBatchRunner.addJobParameter(paramters, "outputFile", "file:" + homePath + "/txtOutput.txt");
		} else if ("mybatisToDelimitedJob".equals(jobName)) {
			paramters = egovBatchRunner.addJobParameter(paramters, "outputFile", "file:" + homePath + "/csvOutput.csv");
		}
		return paramters;
	}
}
