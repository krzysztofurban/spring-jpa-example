package pl.krzysztofurban.jpaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Component;
import pl.krzysztofurban.jpaexample.helper.DataGenerator;
import pl.krzysztofurban.jpaexample.repository.BlogRepository;
import pl.krzysztofurban.jpaexample.repository.FileRepository;
import pl.krzysztofurban.jpaexample.repository.PostRepository;
import pl.krzysztofurban.jpaexample.repository.UserRepository;
import pl.krzysztofurban.jpaexample.service.UserCRUDService;

@Component
public class BlogTestBase {
  @Autowired
  protected TestRestTemplate restTemplate;
  @Autowired
  DataGenerator dataGenerator;
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserCRUDService userCRUDService;
  @Autowired
  PostRepository postRepository;
  @Autowired
  BlogRepository blogRepository;
  @Autowired
  FileRepository fileRepository;
}
