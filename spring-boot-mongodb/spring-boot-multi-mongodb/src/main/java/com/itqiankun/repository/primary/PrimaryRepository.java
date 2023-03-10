package com.itqiankun.repository.primary;

import com.itqiankun.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author neo
 */
public interface PrimaryRepository extends MongoRepository<User, String> {
}
