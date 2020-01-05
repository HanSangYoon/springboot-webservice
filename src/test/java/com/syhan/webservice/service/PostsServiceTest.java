package com.syhan.webservice.service;

import com.syhan.webservice.domain.posts.Posts;
import com.syhan.webservice.domain.posts.PostsRepository;
import com.syhan.webservice.web.PostsSaveRequestDto;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder().author("microscope83@naver.com").content("ServiceTest").title("ServiceTest title").build();

        //when : 실제 액션(dto 클래스가 service.save에 전달된다)
        postsService.save(dto);

        //then : 검증
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}
