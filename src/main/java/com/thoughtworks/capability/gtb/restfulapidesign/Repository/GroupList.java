package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;

import java.util.ArrayList;
import java.util.List;

public class GroupList {
    public static List<Group> groupList = new ArrayList<Group>(){
        {
            add(Group.builder().id(1).name("Group 1").note("note 1").studentList(new ArrayList<Student>()).build());
            add(Group.builder().id(2).name("Group 2").note("note 2").studentList(new ArrayList<Student>()).build());
            add(Group.builder().id(3).name("Group 3").note("note 3").studentList(new ArrayList<Student>()).build());
            add(Group.builder().id(4).name("Group 4").note("note 4").studentList(new ArrayList<Student>()).build());
            add(Group.builder().id(5).name("Group 5").note("note 5").studentList(new ArrayList<Student>()).build());
            add(Group.builder().id(6).name("Group 6").note("note 6").studentList(new ArrayList<Student>()).build());
        }
    };

}
