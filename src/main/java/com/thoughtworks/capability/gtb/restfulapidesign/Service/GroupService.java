package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.GroupException;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.GroupList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    public void updateGroupNameById(Integer id, String updateGroupName) {
        List<Group> groupList = GroupList.groupList.stream().filter(group -> group.getId() == id).collect(Collectors.toList());
        if (groupList.size() == 0) {
            throw new GroupException("Group 不存在");
        }
        groupList.get(0).setName(updateGroupName);
    }
}
