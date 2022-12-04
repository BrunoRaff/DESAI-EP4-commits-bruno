package pe.isil.moduloseguridad.user;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
  private String code;
  private String message;
  private Object data;

  public static UserDto whenUserEmailAlreadyExists() {
    return UserDto.builder().code("510").message("Correo ya existe").build();
  }

  public static UserDto whenError(String message) {
    return UserDto.builder().code("500").message("Something went wrong ".concat(message)).build();
  }

  public static UserDto whenRegistrationSucced() {
    return UserDto.builder()
            .code("200")
            .message("User registered successfully")
            .build();
  }

}
