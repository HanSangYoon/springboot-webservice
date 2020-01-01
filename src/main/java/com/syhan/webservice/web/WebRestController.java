package com.syhan.webservice.web;

import com.syhan.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // 생성자 역할을 함.@AllArgsConstructor를 사용하는 이유는, 의존성 관계가 변경될 때 마다, 생성자 코드를 수정해야 하는 번거로움을 없애기 위함임.
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hellothere")
    public String hellothere(){
        return "Hello Spring boot Web Service world";
    }

    /*
     * @AllArgsConstructor 라는 annotation이 있기 때문에,
     * public WebRestController(PostsRepository postsRepository){
     *      this.postsRepository = postsRepository;
     * }
     * 라는 생성자를 선언하지 않아도 됨.
     */

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
