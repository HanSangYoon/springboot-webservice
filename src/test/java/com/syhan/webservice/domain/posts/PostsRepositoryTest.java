package com.syhan.webservice.domain.posts;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;    //
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest // @SpringBootTest 라는 annotation을 붙이지 않으면 "Error creating bean with name ~~",
                // "nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type ~~ " 에러가 발생한다.
                // 내 생각: Autowired 되어있는 테스트 클래스의 대상이 되는 원래의 클래스가 bean으로 생성되어 ~Test 클래스의 bean도 생성이 되어야 하는데, 그 연계성을 이어주지 못해 에러 발생하는 듯.
                // No qualifying bean of type 'com.syhan.webservice.domain.posts.PostsRepository' available: expected at least 1 bean which qualifies as autowire candidate.
                // Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
                // 이런 에러가 발생하는 걸 보면 추측할 수 있음.
                // @SpringBootTest 라는 annotation을 통해서 애플리케이션 테스테에 대한 거의 모든 의존성을 제공한다.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Before
    public void setUp(){
        System.out.println("setUp!");
    }

    @After
    public void cleanUp(){
        /**
         * 이후 테스트 코드(@Test)에 영향을 주지 않기 위해
         * 테스트 메소드 끝날 때 마다 repository 전체를 비우는 목적으로
         * 본 코드(@After) 실행
         */
        System.out.println("clean up!!");
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        // BDD: Behaviour - Driven Developer
        // given : 테스트 기반의 환경 구축. @Builder 사용법도 같이 확인하면 좋음.
        System.out.println("Given!!");
        postsRepository.save(Posts.builder().title("Just test").content("test content").author("microscope83@gmail.com").build());

        //when : 테스트 하고자 하는 행위 선언. 아래처럼, ~.findAll() !!!!
        System.out.println("When!!");
        List<Posts> postsList = postsRepository.findAll();

        //then : 테스트 결과 검증. 실제로 DB에 insert 되었는지 확인하기 위해, 조회 후, 입력된 값 확인.
        System.out.println("then!!");
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("Just test"));
        assertThat(posts.getContent(), is("test content"));
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("테스트2게시글").content("test2Content").author("microscope83@gmail.com2").build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
