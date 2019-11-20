package com.example.actuatorservice.Repository;

import com.example.actuatorservice.domain.User;
import org.springframework.stereotype.Repository;

    @Repository
    public class UserRepository extends InMemoryRepository<User> {

        protected void updateIfExists(User original, User updated) {
            original.setEmailaddress(updated.getEmailaddress());
            original.setTags(updated.getTag());
        }
    }

