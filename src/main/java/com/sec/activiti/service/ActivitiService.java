package com.sec.activiti.service;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ActivitiService
 * Description: Activiti服务
 * Created by liuff on 2017/10/29 14:06.
 */
@Service
@Transactional
public class ActivitiService {
    //注入为我们自动配置好的服务
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 开始流程传入申请信息
     */
    public void startProcess() {

//        runtimeService.startProcessInstanceByKey()
    }

    /**
     * 获取某个人的任务列表
     * @param assignee
     * @return
     */
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskCandidateUser(assignee).list();
    }

    /**
     * 完成任务
     * @param joinApproved
     * @param taskId
     */
    public void completeTasks(Boolean joinApproved, String taskId) {
        Map<String, Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("joinApproved", joinApproved);
        taskService.complete(taskId, taskVariables);
    }

}
