package me.rheeyouyoung.springbootdeveloper.repository;

import me.rheeyouyoung.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
