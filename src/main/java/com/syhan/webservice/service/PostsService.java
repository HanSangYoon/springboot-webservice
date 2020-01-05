package com.syhan.webservice.service;

import com.syhan.webservice.domain.posts.PostsRepository;
import com.syhan.webservice.web.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        /*
        호출한 쪽에서, 게시글의 ID 값을 알 수 있도록, return type을 Long으로 두고, .getId()를 반환값으로 설정함.
        Service 의 save 메소드는 Entity를 바로 받지 않고, PostsSaveRequestDto를 받아서 저장함.
        */
        /*
        Controller에서 dto.toEntity()를 선언함으로써 값을 받아도 되는데, 그러지 않은 이유는,
        service와 controller의 역할을 분리하기 위함.
        Service: 비즈니스 로직 + 트랜잭션 관리.
        Controller: View와 연동된 부분을 담당.
         */
        /*
        @Transactional 어노테이션은 DB 데이터를 등록/수정/삭제하는 Service 메소드를 선언할 때 반드시 선언하는 것.
        @Transactional의 역할: 메소드 내에 Exception이 발생하면 메소드에서 이루어진 모든 DB 작업을 초기화 함.
         */
        return postsRepository.save(dto.toEntity()).getId();
    }
}
