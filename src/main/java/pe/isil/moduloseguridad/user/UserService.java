package pe.isil.moduloseguridad.user;

import java.util.List;

public interface UserService {
  UserDto addUser(User user);
  User findUserByEmail(String email);
  List<User> findAll();
  UserDto updateUser(User user, Long id);
  void deleteUser(Long id);

  User findUserById(Long id);
}
