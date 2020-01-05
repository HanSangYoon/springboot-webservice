package com.syhan.webservice.web;

import com.syhan.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    //Request, Response 용도이기 때문에 View를 위한 클래스라 볼 수 있다. Controller 에서 많이 갖다 쓰는 클래스이다.
    //Entity 클래스는 DB layer, DTO 클래스는 View layer라고 생각해야 한다.

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
