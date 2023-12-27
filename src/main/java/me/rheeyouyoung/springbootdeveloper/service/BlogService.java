package me.rheeyouyoung.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.rheeyouyoung.springbootdeveloper.domain.Article;
import me.rheeyouyoung.springbootdeveloper.dto.AddArticleRequest;
import me.rheeyouyoung.springbootdeveloper.dto.UpdateArticleRequest;
import me.rheeyouyoung.springbootdeveloper.repository.BlogRepository;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    //블로그 글 목록 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found" + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
