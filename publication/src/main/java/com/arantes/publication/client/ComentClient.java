package com.arantes.publication.client;

import com.arantes.publication.domain.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ComentClient", url = "${client.comments.url}")
public interface ComentClient {

    @GetMapping("/comments/{publicationId}")
    List<Comment> getComments(@PathVariable("publicationId") String publicationId);
}
