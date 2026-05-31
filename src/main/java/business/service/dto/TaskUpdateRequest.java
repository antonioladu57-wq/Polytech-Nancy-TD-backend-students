package business.service.dto;

/**
 * DTO d'entrée pour la modification d'une tâche via PUT.
 */
public record TaskUpdateRequest(String title, String description, boolean done) {
}