package com.taskmanager.taskbackend.service;

import com.taskmanager.taskbackend.model.TeamMember;
import com.taskmanager.taskbackend.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberService {
    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberService(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    public TeamMember addMember(TeamMember member) {
        return teamMemberRepository.save(member);
    }

    public List<TeamMember> getAllMembers() {
        return teamMemberRepository.findAll();
    }

    public Optional<TeamMember> getMemberById(String id) {
        return teamMemberRepository.findById(id);
    }

    public void deleteMember(String id) {
        teamMemberRepository.deleteById(id);
    }

    public TeamMember updateMember(String id, TeamMember updated) {
        updated.setId(id);
        return teamMemberRepository.save(updated);
    }
}
