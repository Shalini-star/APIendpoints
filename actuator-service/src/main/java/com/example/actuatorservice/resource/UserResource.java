package com.example.actuatorservice.resource;

import com.example.actuatorservice.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class UserResource extends ResourceSupport {

    private final long id;
    private final String description;
    private final String tags;

    public UserResource(User user) {
        id = user.getId();
        description = user.getEmailaddress();
        tags = user.getTag();
            }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tags;
    }


}