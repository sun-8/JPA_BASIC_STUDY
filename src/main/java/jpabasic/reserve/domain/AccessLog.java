package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "access_log")
public class AccessLog {
    @Id
    @TableGenerator(
            name = "accessIdGen",
            table = "id_seq",
            pkColumnName = "entity",
            pkColumnValue = "accessLog",
            valueColumnName = "nextval",
            initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(generator = "accessIdGen")
    private Long id;
    private String path;
    private LocalDateTime accessed;

    protected AccessLog() {
    }

    public AccessLog(String path, LocalDateTime accessed) {
        this.path = path;
        this.accessed = accessed;
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getAccessed() {
        return accessed;
    }
}

/* @TableGenerator
*       엔티티 클래스의 주요 키(pk)값을 자동으로 생성하기 위해 사용되는 전략 중의 하나이다.
*       개발자는 주요 키 값을 직접 관리하는 대신 JPA가 자동으로 값을 생성할 수 있도록 할 수 있다.
*       보통 엔티티 클래스에서는 주요 키를 직접 설정하거나 데이터베이스에서 시퀀스, 자동 증가 컬럼 등을 사용하여 값을 생성하지만,
*       @TableGenerator를 사용하여 주요 키 값을 자동으로 생성할 수도 있다.
*
*       name: 생성되는 생성기(generator)의 이름을 지정. 엔티티 클래스에서 해당 생성기를 참조할 때 사용.
*       table: 키 값을 저장할 데이터베이스 테이블 이름을 지정. 키 생성에 사용되는 값들이 저장.
*       pkColumnName: 테이블에서 주요 키를 식별하는 데 사용되는 컬럼의 이름을 지정.
*       valueColumnName: 실제로 생성된 키 값을 저장하는 컬럼의 이름을 지정.
*       pkColumnValue: 키 생성기를 구분하는 값으로, 테이블에서 여러 엔티티에 대해 다른 키 생성기를 사용할 때 유용.
*       initialValue: 키의 시작값을 지정.
*       allocationSize: 키 생성기가 한번에 얼마만큼 증가하는지 지정. 성능을 향상시키기 위해 한 번에 여러 키를 미리 생성하는데 사용.*/