package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        task.setNo(taskIndex);
        this.tasks[this.taskIndex++] = task;
    }
    
    public Task[] list() {
        Task[] arr = new Task[taskIndex];
        for (int i = 0; i < taskIndex; i++) 
            arr[i] = tasks[i];
        return arr;
    }
    
    public Task get(int i) {
        if (i < 0 || i >= taskIndex)
            return null;
        return tasks[i];
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
    
    public void delete(int i) {
        tasks[i] = null;
    }
}

// ver 17 - 클래스 생성





