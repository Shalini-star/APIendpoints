package com.example.actuatorservice.Controller;

import com.example.actuatorservice.Repository.UserRepository;
import com.example.actuatorservice.domain.User;
import com.example.actuatorservice.resource.UserResource;
import com.example.actuatorservice.resource.UserResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(User.class)
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<UserResource>> findAllUsers() {
        List<User> users = repository.findAll();
        return new ResponseEntity(assembler.toResourceCollection(users), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<UserResource> createUser(@RequestBody User user) {
        User createdUser = repository.create(user);
        return new ResponseEntity<>(assembler.toResource(createdUser), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserResource> findUserById(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(user.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<UserResource> updateOrder(@PathVariable Long id, @RequestBody User updatedOrder) {
        boolean wasUpdated = repository.update(id, updatedOrder);

        if (wasUpdated) {
            return findUserById(id);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}