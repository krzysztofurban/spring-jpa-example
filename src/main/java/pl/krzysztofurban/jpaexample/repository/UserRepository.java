package pl.krzysztofurban.jpaexample.repository;

import org.springframework.stereotype.Repository;
import pl.krzysztofurban.jpaexample.model.jpa.User;
import pl.krzysztofurban.jpaexample.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
  void deleteByUsername(String username);
}
