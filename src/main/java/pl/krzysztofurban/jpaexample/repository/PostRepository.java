package pl.krzysztofurban.jpaexample.repository;

import org.springframework.stereotype.Repository;
import pl.krzysztofurban.jpaexample.model.jpa.Post;
import pl.krzysztofurban.jpaexample.repository.base.BaseRepository;

@Repository
public interface PostRepository extends BaseRepository<Post, Long> {
}
