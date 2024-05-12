package com.splitwise.main.groups.services;

import com.splitwise.main.groups.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group getGroupById(Long id);
    Group createGroup(Group group);
    Group updateGroup(Long id, Group group);
    void deleteGroup(Long id);

}
