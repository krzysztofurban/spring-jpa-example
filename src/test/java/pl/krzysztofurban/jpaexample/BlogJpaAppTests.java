package pl.krzysztofurban.jpaexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import pl.krzysztofurban.jpaexample.model.jpa.File;
import pl.krzysztofurban.jpaexample.model.jpa.Post;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  @Test
  @Transactional
  @Commit
  public void testManyToManyWithPostAndFiles() {
    Post post = postRepository.findAll().get(0);
    File file = new File();
    file.setName("main_image");
    fileRepository.save(file);

    File file1 = new File();
    file1.setName("second_image");
    fileRepository.save(file1);
    fileRepository.refresh(file);
    fileRepository.refresh(file1);

    Set<File> files = post.getFiles();
    if (files == null) {
      files = new HashSet<>();
    }
    files.add(file);
    files.add(file1);

    post.setFiles(files);
    postRepository.save(post);

    List<File> allFiles = fileRepository.findAll();
    allFiles.forEach(f -> {
      Set<Post> posts = f.getPosts();
      posts.forEach(p -> {
        log.info("Post: {} attached with file: {}", p.getTitle(), f.getName());
      });
    });

    post.getFiles().forEach(f -> {
      log.info("File: {} attached to Post: {}", f.getName(), post.getTitle());
    });

  }
}
