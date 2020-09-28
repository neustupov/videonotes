package org.neustupov.videonotes.repo;

import org.neustupov.videonotes.model.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {

}
