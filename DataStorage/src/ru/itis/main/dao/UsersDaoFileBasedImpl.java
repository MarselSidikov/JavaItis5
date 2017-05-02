package ru.itis.main.dao;

import ru.itis.main.exception.UserNotFoundException;
import ru.itis.main.generators.SimpleIdGenerator;
import ru.itis.main.mapper.RowMapper;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryTemplate;
import ru.itis.main.utils.FileDaoQueryTemplateImpl;

import java.io.*;
import java.util.*;

public class UsersDaoFileBasedImpl implements UsersDao {

    private String fileName;
    private FileDaoQueryTemplate template;

    public UsersDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    private Map<Integer, User> usersMap;

    private RowMapper<User> userRowMapper = new RowMapper<User>(){

        @Override
        public User mapRow(String row) {
            String rowAsArray[] = row.split(" ");
            User user = new User.Builder().id(Integer.parseInt(rowAsArray[0]))
                    .login(rowAsArray[1])
                    .password(rowAsArray[2])
                    .name(rowAsArray[3])
                    .age(Integer.parseInt(rowAsArray[4]))
                    .autos(new ArrayList<Auto>()).build();
            if (usersMap != null) {
                usersMap.put(user.getId(), user);
            }
            return user;
        }
    };
    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(String row) {
            String autoDataAsArray[] = row.split(" ");
            Auto auto = new Auto(Integer.parseInt(autoDataAsArray[0]),
                    autoDataAsArray[1],
                    autoDataAsArray[2],
                    Double.parseDouble(autoDataAsArray[3]),
                    Boolean.valueOf(autoDataAsArray[4]),
                    Integer.parseInt(autoDataAsArray[5]));
            User owner = usersMap.get(auto.getIdOwner());
            owner.getAutos().add(auto);
            return auto;
        }
    };

    @Override
    public int save(User user) {
      return template.save(fileName,user);
    }

    // поиск объекта по id
    @Override
    public User find(int id) {

        List<User> users = template.findByValue(fileName,userRowMapper,0,id);

        if(users.size() == 0) {
            throw new UserNotFoundException("User with id <"+id+"> not found");
        } else {
            return users.get(0);
        }
    }


    @Override
    public void delete(int id) {
        template.deleteByValue(fileName,0,id);
    }

    @Override
    public void update(User model) {
        template.update(fileName,model);
    }

    @Override
    public List<User> findAll() {
        this.usersMap = new HashMap<>();
        template.findAll(fileName,userRowMapper);
        template.findAll("autos.txt", autoRowMapper);
        List<User> users =  new ArrayList<>(usersMap.values());
        usersMap = null;
        return users;
    }

    @Override
    public List<User> findAllByAge(int age) {
       return template.findByValue(fileName,userRowMapper,4,age);
    }

    @Override
    public List<User> findAllByName(String name){
       return template.findByValue(fileName,userRowMapper,3, name);
    }
}
