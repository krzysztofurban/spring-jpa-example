package pl.krzysztofurban.jpaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysztofurban.jpaexample.model.jpa.User;
import pl.krzysztofurban.jpaexample.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserCRUDService {
  @Autowired
  UserRepository userRepository;

  @Transactional
  public User createNewUser(User user) {
    user = userRepository.save(user);
    return user;
  }

  @Transactional
  public boolean deleteUser(String username) {
    userRepository.deleteByUsername(username);
    return true;
  }
}
