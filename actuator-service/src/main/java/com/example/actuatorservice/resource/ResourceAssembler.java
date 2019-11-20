package com.example.actuatorservice.resource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ResourceAssembler <DomainType, ResourceType> {
    public abstract UserResource toResource(DomainType domainObject);

    public List<UserResource> toResourceCollection(Collection<DomainType> domainObjects) {
        return domainObjects.stream().map(o -> toResource(o)).collect(Collectors.toList());
    }
}
