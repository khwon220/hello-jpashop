package jpabook.jpashop01.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
/** @MappedSuperclass
 * 전체 엔티티에서 공통으로 적용하는 정보를 모을 때 사용 (ex. 등록일, 수정일, 등록자, 수정자)
 * 상속관계 매핑 X
 * 엔티티 X, 테이블과 매핑 X
 * 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
 * 조회, 검색 불가 (ex. em.find(BaseEntity) 불가)
 * 직접 생성해서 사용할 일이 없으므로 추상 클래스 권장
 * 테이블과 관계 없고, 단순히 엔티티가 공통으로 사용하는 매핑 정보를 모으는 역할
 *
 * @Entity 클래스는 상속 관계 매핑
 * @MappedSuperclass 클래스는 속성만 상속
 */
public abstract class BaseEntity {

    @Column(name = "INSER_MEMBER")
    private String createdBy;
    private LocalDateTime createdDate;
    @Column(name = "UPDATE_MEMBER")
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
