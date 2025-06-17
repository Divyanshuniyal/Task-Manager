package com.taskmanager.taskbackend.controller;

import com.taskmanager.taskbackend.model.TeamMember;
import com.taskmanager.taskbackend.service.TeamMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = "*")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @PostMapping
    public ResponseEntity<TeamMember> addMember(@RequestBody TeamMember member) {
        return ResponseEntity.ok(teamMemberService.addMember(member));
    }

    @GetMapping
    public ResponseEntity<List<TeamMember>> getAllMembers() {
        return ResponseEntity.ok(teamMemberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMember> getMember(@PathVariable String id) {
        Optional<TeamMember> member = teamMemberService.getMemberById(id);
        return member.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamMember> updateMember(@PathVariable String id, @RequestBody TeamMember member) {
        return ResponseEntity.ok(teamMemberService.updateMember(id, member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable String id) {
        teamMemberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
