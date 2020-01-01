package com.syhan.webservice.domain.posts;

import com.syhan.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // @Lombok annotation : 기본 생성자 자동 추가
// access = AccessLevel.PROTECTED :  기본 생성자의 접근 권한을 protected로 제한
// 생성자로 protected Posts() {} 로 만드는 효과를 만듦.
// Entity 클래스를 프로젝트 코드상에서 기본 생성자로 생성하는 것은 막되,
// JPA에서 Entity 클래스를 생성하는 것은 허용하기 위해 추가함.

@Getter // @Lombok annotation
// 클래스 내 모든 필드의 Getter 메소드를 자동 생성

@Entity // 테이블과 링크될 클래스임을 나타냄.
        // 데이터 베이스에 테이블 명 반영시, 반드시 언더스코어(_) 네이밍 사용.
public class Posts extends BaseTimeEntity {
    // Make Domain Code
    // matching with Database table, Called Entity Class

    @Id // 해당 테이블의 PK 필드를 나타냄.
    @GeneratedValue // PK 생성규칙을 나타냄.
                    // 기본 값은 AUTO, mysql의 autoIncrement 와 같은 정수 자동 증가형.
    private Long id;

    // @Column: 테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨.
    // 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용.
    // 문자열의 경우, Varchar(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나,
    // 타입을 TEXT로 변경하고 싶거나 하면 본 Annotation을 사용한다.
    @Column(length=500, nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // @Lombok annotation
    // 해당 클래스의 빌더 패턴 클래스를 생성
    // (직접 만든) 생성자 상단에 선언시, 생성자에 포함된 필드만 빌더에 포함.
    // 생성 시점에 최종 값을 채워주는 역할을 함.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
