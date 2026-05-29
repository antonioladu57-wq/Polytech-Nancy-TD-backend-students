package business.service;

import dao.TaskDao;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service gérant la logique métier des tâches.
 * Fait le lien entre le Contrôleur (HTTP) et le DAO (Données).
 */
public class TaskService {

    private final TaskDao taskDao = new TaskDao();

    public Task createTask(Task task) {
        return taskDao.save(task);
    }

    public Optional<Task> getTaskById(int id) {
        return taskDao.findById(id);
    }

    public Collection<Task> getAllTasks(boolean todoOnly) {
        if (todoOnly) {
            return taskDao.findAll(true); // Passe le filtre au DAO
        }
        return taskDao.findAll(false);
    }

    public boolean updateTask(int id, Task input) {
        Optional<Task> existing = taskDao.findById(id);
        if (existing.isPresent()) {
            Task updatedTask = new Task(id, input.title(), input.description(), input.done());
            taskDao.save(updatedTask);
            return true;
        }
        return false;
    }

    public boolean deleteTaskById(int id) {
        return taskDao.deleteById(id);
    }

    public void deleteAllTasks() {
        taskDao.clearAll();
    }

    public int countTasks() {
        return taskDao.count();
    }
}