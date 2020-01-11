package com.cqjtu.cssl.service.impl;

import com.cqjtu.cssl.entity.Project;
import com.cqjtu.cssl.mapper.ProjectMapper;
import com.cqjtu.cssl.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Project get(Integer proId) {

        Project project = null;
        project = projectMapper.findProjectById(proId);
        return project;

    }

    @Override
    public void addProject(Project project) {

        projectMapper.addProject(project);

    }

    @Override
    public List<Project> loadAll() {

        return projectMapper.findAllProject();
/**
 * 测试 mapper.select()
 *
 User user = new User();
 user.setUserNo("000007");
 user.setUserName("厂子7");

 List<User> userList = userMapper.select(user);

 Set<User> userSet = new TreeSet<>(Comparator.comparing(User::getUserName));
 userSet.addAll(userList);
 return new ArrayList<>(userSet);
 */

    }

    /*@Override
    public List<Project> loadDistinct() {
        List<User> userList = userMapper.selectAll();
        System.out.println("selectAll"+userList.size());
        List<String> distinct = new ArrayList<>();
        List<User> userDistinctList = new ArrayList<>();
        int flag;
        for (User each : userList) {
            flag = 0;
            System.out.println(each.getUserName());
            for (String name : distinct) {
                if (each.getUserName().equals(name)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                continue;
            distinct.add(each.getUserName());
            System.out.println(each.getUserName());
            userDistinctList.add(each);
        }

        return userDistinctList;
        List<User> userList = userMapper.selectAll();

        Set<User> userSet = new TreeSet<>(Comparator.comparing(User::getUserName));
        userSet.addAll(userList);
        return new ArrayList<>(userSet);
    }*/

    @Override
    public void removeProject(Integer proId) {

        projectMapper.deleProjectById(proId);

    }

    @Override
    public void updateProject(Project project) {

       projectMapper.updateProjectById(project);

    }

    @Override
    public Project getProjectById(Integer proId) {

        return projectMapper.findProjectById(proId);

    }

    /**
     * 注解式
     * 自定义 mappper 方法调用
     *
     * @param userName
     * @return
     */
//    public User getUserByName(String userName) {
//        return userMapper.selectByUserName(userName);
//    }

}