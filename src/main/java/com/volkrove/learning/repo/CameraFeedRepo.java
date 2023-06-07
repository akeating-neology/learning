package com.volkrove.learning.repo;

import com.volkrove.learning.model.CameraFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraFeedRepo extends JpaRepository<CameraFeed,Long> {

}
