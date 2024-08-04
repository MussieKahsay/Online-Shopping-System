package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.dto.AdminDto;
import edu.miu.cs.cs425.dto.CustomerDto;
import edu.miu.cs.cs425.dto.UserDto;
import edu.miu.cs.cs425.exception.UserException;
import edu.miu.cs.cs425.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {



    public User getUserByEmailId(String emailId)throws UserException;

    public User addUser(CustomerDto customer)  throws UserException;

    public User addUserAdmin(AdminDto admin	)  throws UserException;

    public User changePassword(Integer userId, UserDto customer)  throws UserException;

    public String deactivateUser(Integer userId) throws UserException;

    public User getUserDetails(Integer userId)throws UserException;

    public List<User> getAllUserDetails() throws UserException;
}