package co.pragra.coop.springbootjpaproject.services;

import co.pragra.coop.springbootjpaproject.entities.User;
import co.pragra.coop.springbootjpaproject.exceptions.NotFoundException;
import co.pragra.coop.springbootjpaproject.exceptions.RequiredDataMissingException;
import co.pragra.coop.springbootjpaproject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //Post
    public User saveUser(User user) {

        if (null != user) {
            if (null == user.getFirstName() || user.getFirstName().equals("")) {
                throw new RequiredDataMissingException("First Name should not be empty");
            }
            return userRepo.save(user);
        }
        throw new RequiredDataMissingException("User body cannot be null");
    }
    //Get
    public User getUserByLogin(String login) throws NotFoundException{
        //Optional<User> byLogin = Optional.of(userRepo.findByLogin(login));
//        if(!byLogin.isPresent()){
//            throw new RequiredDataMissingException("User with " + login+ " login doesn't exist" );
//        }
        return  userRepo.findByLogin(login);
    }
    //Get - All users
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    //Delete
    public String deleteUser(String login) {
        Optional<User> byLogin = Optional.ofNullable(userRepo.findByLogin(login));
        if(login.equals("") || null==login){
            throw new RequiredDataMissingException("User login cannot be empty");
        } else if ( !byLogin.isPresent())
            {
                throw  new RequiredDataMissingException("User login " +login+" Doesn't exist ");
            }
            userRepo.deleteByLogin(login);
        return " user Sucessfully removed " + login;
        }

    //Push
    public User updateUser(User user){
        if(null != user){
            if(null == user.getFirstName() || user.getFirstName().equals("")){
                throw new RequiredDataMissingException("Name should not be empty");
            }
            User fetctExistingUser = userRepo.findByLogin(user.getLogin());
            fetctExistingUser.setLogin(user.getLogin());
            fetctExistingUser.setFirstName(user.getFirstName());
            fetctExistingUser.setLastName(user.getLastName());
            fetctExistingUser.setEmail(user.getEmail());
            fetctExistingUser.setActivated(user.isActivated());
            fetctExistingUser.setLangKey(user.getLangKey());
            fetctExistingUser.setAuthorities(user.getAuthorities());
            fetctExistingUser.setPassword(user.getPassword());
            return  userRepo.save(fetctExistingUser);
        }
        throw new RequiredDataMissingException("User body can't be null");
    }

}
