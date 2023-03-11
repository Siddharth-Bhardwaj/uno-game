package com.uno.model;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuditModel {
  @CreatedDate private Instant createdAt;

  @LastModifiedDate private Instant updatedAt;
}
