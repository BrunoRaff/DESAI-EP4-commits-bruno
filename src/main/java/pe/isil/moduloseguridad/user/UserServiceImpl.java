package pe.isil.moduloseguridad.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDto addUser(User user) {
    Optional<User> userToAdd = userRepository.findUserByEmail(user.getEmail());
    if (userToAdd.isPresent()) {
      return UserDto.whenUserEmailAlreadyExists();
    }
    userRepository.save(user);
    return UserDto.whenRegistrationSucced();
  }

  @Override
  public User findUserByEmail(String email) {
    Optional<User> userToFind = userRepository.findUserByEmail(email);
    if (userToFind.isPresent()) {
      return userToFind.get();
    } return null;
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public UserDto updateUser(User user, Long id) {
    try {
      Optional<User> userToUpdate = userRepository.findById(id);
      if (userToUpdate.isPresent()) {
        userToUpdate.get().setName(user.getName() != null ? user.getName() : userToUpdate.get().getName());
        userToUpdate.get().setEmail(user.getEmail() != null ? user.getEmail() : userToUpdate.get().getEmail());
        userToUpdate.get().setLastname(user.getLastname() != null ? user.getLastname() : userToUpdate.get().getLastname());
        userToUpdate.get().setPhoto(user.getPhoto() != null ? user.getPhoto() : userToUpdate.get().getPhoto());
        userRepository.save(userToUpdate.get());
        return UserDto.whenRegistrationSucced();
      }
      return UserDto.whenError("User does not exist");
    } catch (Exception e) {
      return UserDto.whenError("Correo en uso use otro");
    }
  }

  @Override
  public void deleteUser(Long id) {
    Optional<User> userToDelete = userRepository.findById(id);
    userToDelete.ifPresent(user -> userRepository.delete(user));
  }

  @Override
  public User findUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
}
