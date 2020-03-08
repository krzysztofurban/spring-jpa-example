package pl.krzysztofurban.jpaexample.repository;

import org.springframework.stereotype.Repository;
import pl.krzysztofurban.jpaexample.model.jpa.Blog;
import pl.krzysztofurban.jpaexample.repository.base.BaseRepository;

@Repository
public interface BlogRepository extends BaseRepository<Blog, Long> {
}
