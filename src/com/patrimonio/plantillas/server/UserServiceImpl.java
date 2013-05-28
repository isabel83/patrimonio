package com.patrimonio.plantillas.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.patrimonio.plantillas.client.UserService;
import com.patrimonio.plantillas.server.dao.UserDao;
import com.patrimonio.plantillas.shared.User;


@Service("UserService")
public class UserServiceImpl implements UserService{

       
        @Autowired
        UserDao UserDao;


        @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
        public User saveUser(String name, String surname, String jobDescription) {

                System.out.println("UserServiceImpl => saveUser()");
                
                User UserPersisted1 = UserDao.persist(new User(name, surname, jobDescription));
                System.out.println("User ID: " + UserPersisted1.getEmployeeId());
                

                return UserPersisted1;
                
                
        }

}