package com.volkrove.learning.repo;

import com.volkrove.learning.model.OcrBehavior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcrBehaviorRepo extends JpaRepository<OcrBehavior,Long> {
}
