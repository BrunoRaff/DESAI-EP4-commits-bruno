package pe.isil.moduloseguridad.applications.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApplicationDto {
  private int status;
  private String message;

  public static ApplicationDto whenApplicationsExists() {
    return ApplicationDto.builder().status(400).message("El nombre de la aplicacion debe ser único").build();
  }

  public static ApplicationDto onSuccess() {
    return ApplicationDto.builder().status(200).build();
  }
}
