package com.splitwise.main.groups.services;

import com.splitwise.main.groups.entity.Group;
import com.splitwise.main.groups.exceptions.ResourceNotFoundException;
import com.splitwise.main.groups.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements  GroupService{
    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", id));
    }

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Long id, Group group) {
        Group existingGroup = groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", id));
        existingGroup.setGname(group.getGname());
        return groupRepository.save(existingGroup);
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "id", id));
        groupRepository.delete(group);
    }
}
