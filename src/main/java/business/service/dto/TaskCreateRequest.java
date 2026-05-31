package business.service.dto;

/**
 * DTO d'entrée pour la création d'une tâche via POST (sans ID ni done).
 */
public record TaskCreateRequest(String title, String description) {
}