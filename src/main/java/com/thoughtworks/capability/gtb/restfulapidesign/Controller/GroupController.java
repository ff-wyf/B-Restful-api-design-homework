package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PatchMapping("/groups/{id}")
    public ResponseEntity updateGroupNameById(@PathVariable Integer id, @RequestParam String updateGroupName) {
        groupService.updateGroupNameById(id, updateGroupName);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getGroupsList() {
        List<Group> groupList = groupService.getGroupsList();
        return ResponseEntity.ok(groupList);
    }
}
