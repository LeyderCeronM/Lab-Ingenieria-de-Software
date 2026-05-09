package main.java.com.piedrazul.userservice.service;

import com.piedrazul.userservice.entity.User;
import com.piedrazul.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userDetails.getUsername());
        user.setFullname(userDetails.getFullname());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setState(userDetails.getState());
        user.setCitizenshipCard(userDetails.getCitizenshipCard());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setProfession(userDetails.getProfession());
        user.setSpecialty(userDetails.getSpecialty());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}