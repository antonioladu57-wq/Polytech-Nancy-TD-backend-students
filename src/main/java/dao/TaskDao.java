package dao;

import business.service.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Data Access Object for {@link Task} model.
 */
public class TaskDao {

    private final Map<Integer, Task> storage = new HashMap<>();

    {
        save(new Task(1, "Réviser DS de maths", "Séries numériques et probabilités.", false));
        save(new Task(2, "Valider mon PIVE", "PIVE Club Poker.", true));
        save(new Task(3, "Choisir mon parcours de 4A", "SIR ou SIA ?", false));
    }

    public Task save(Task task) {
        storage.put(task.id(), task);
        return task;
    }

    public Optional<Task> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Collection<Task> findAll(boolean todoOnly) {
        if (todoOnly) {
            return storage.values().stream()
                    .filter(task -> !task.done())
                    .collect(Collectors.toList());
        }
        return storage.values();
    }

    public boolean deleteById(int id) {
        return storage.remove(id) != null;
    }

    public void clearAll() {
        storage.clear();
    }

    public int count() {
        return storage.size();
    }
}