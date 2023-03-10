package com.itqiankun.repository.secondary;

import com.itqiankun.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author neo
 */
public interface SecondaryRepository extends MongoRepository<User, String> {
}
