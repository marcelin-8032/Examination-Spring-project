package com.examination.project.infrastructure.persistance.common.audit;

import org.springframework.data.domain.Auditable;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class AuditableBaseEntity implements Auditable<String, Integer, LocalDateTime> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String createdBy;
	private LocalDateTime createdAt;
	private String updatedBy;
	private LocalDateTime updatedAt;

	@Override
	public Optional<String> getCreatedBy() {
		return Optional.ofNullable(createdBy);
	}

	@Override
	public Optional<LocalDateTime> getCreatedDate() {
		return Optional.ofNullable(createdAt);
	}

	@Override
	public Optional<String> getLastModifiedBy() {
		return Optional.ofNullable(updatedBy);
	}

	@Override
	public Optional<LocalDateTime> getLastModifiedDate() {
		return Optional.ofNullable(updatedAt);
	}

	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdAt = createdDate;
	}

	@Override
	public void setLastModifiedBy(String lastModifiedBy) {
		this.updatedBy = lastModifiedBy;
	}

	@Override
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.updatedAt = lastModifiedDate;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return false;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BaseAuditableEntity other = (BaseAuditableEntity) obj;
//		return Objects.equals(createdAt, other.createdAt) && Objects.equals(createdBy, other.createdBy)
//				&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(updatedBy, other.updatedBy);
//	}

}
