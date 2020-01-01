package com.syhan.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    // iBatis, MyBatis에서 DAO라고 불리는 Database Layer 접근자임.
    // JPA에서는 Repository라고 부르며, interface로 생성함.
    // 단순히 interface를 생성 후, JpaRepository<Entity클래스, PK타입>을 상속.
    // 이렇게 상속하면 기본적인 CRUD 메소드를 자동생성함.
    // 특별하게 @Repository 어노테이션을 선언할 필요 없다.
}
