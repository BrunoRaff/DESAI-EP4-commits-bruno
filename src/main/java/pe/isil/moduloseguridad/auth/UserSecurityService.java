package pe.isil.moduloseguridad.auth;

import pe.isil.moduloseguridad.user.UserDto;

public interface UserSecurityService {

  UserSecurity findUserSecurity(String email, String password);

  UserSecurity findUserByEmail(String email);
  UserDto addUserSecurity(UserSecurity user);

  UserSecurity findById(Long id);
  UserSecurity changePassword(UserSecurity user, String newPassword);

}
