package com.akbtron.user.user.service;

import com.akbtron.user.user.VO.Department;
import com.akbtron.user.user.VO.ResponseTemplate;
import com.akbtron.user.user.entity.User;
import com.akbtron.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {

        ResponseTemplate responseTemplate = new ResponseTemplate();

        User user = userRepository.findByUserId(userId);

        Department department = restTemplate
                .getForObject("localhost:9001/departments/"+user.getDepartmentId(),Department.class);

        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);

        return responseTemplate;

    }
}
