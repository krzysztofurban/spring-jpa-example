package pl.krzysztofurban.jpaexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Slf4j
public class BlogJpaAppTests extends BlogTestBase {
  private boolean generateData = true;

  @PostConstruct
  public void init() {
    log.info("Checking if already initialized");
    if (dataGenerator.getInitialized().get() == false && generateData) {
      dataGenerator.generateSampleData();
    }
  }

  @Test
  @Transactional
  @Commit
  public void testOneToManyDeletion() {
    log.info("Deleted user: {}", "Akira");
    userCRUDService.deleteUser("Akira");
    log.info("Printing all users");
    userRepository.findAll().stream().forEach(user -> log.info("User {}, {}",
        user.getId(), user.getUsername()));
  }

}
