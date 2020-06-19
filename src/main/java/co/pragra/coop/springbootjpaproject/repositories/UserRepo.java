package co.pragra.coop.springbootjpaproject.repositories;

import co.pragra.coop.springbootjpaproject.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {

    User findByLogin(String login);

    void deleteByLogin(String login);
}
