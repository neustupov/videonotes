package org.neustupov.videonotes.repo;

import org.neustupov.videonotes.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
