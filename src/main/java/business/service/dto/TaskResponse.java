package business.service.dto;

/**
 * DTO de sortie standard renvoyé au client pour toutes les fiches de consultation.
 */
public record TaskResponse(Integer id, String title, String description, boolean done) {
}