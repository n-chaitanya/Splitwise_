package com.splitwise.main.groups.controllers;

import com.splitwise.main.groups.entity.Group;
import com.splitwise.main.groups.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/")
    public ResponseEntity<List<Group>> getAllGroups(){
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable(value = "id") Long id){
        Group group = groupService.getGroupById(id);
        return ResponseEntity.ok(group);
    }

    @PostMapping("/")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group createdGroup = groupService.createGroup(group);
        return ResponseEntity.ok(createdGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable(value = "id") Long id, @RequestBody Group group) {
        Group updatedGroup = groupService.updateGroup(id, group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable(value = "id") Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.ok().build();
    }



}
