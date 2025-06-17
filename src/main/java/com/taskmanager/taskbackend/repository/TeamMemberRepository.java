package com.taskmanager.taskbackend.repository;

import com.taskmanager.taskbackend.model.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepository extends MongoRepository<TeamMember, String> {
    TeamMember findByEmail(String email);
}
