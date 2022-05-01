package com.helmes.sectors.controllers;

import com.helmes.sectors.dto.SectorDTO;
import com.helmes.sectors.dto.UserDTO;
import com.helmes.sectors.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@Valid  @RequestBody UserDTO userDTO) {
        UserDTO response = userService.save(userDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        List<UserDTO> userDTOList = userService.listAll();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody SectorDTO sectorDTO, @PathVariable Long id) {
        UserDTO response = userService.updateUser(sectorDTO, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
