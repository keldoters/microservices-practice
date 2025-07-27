package com.example.microservice.controller;

import com.example.microservice.model.request.UserDetailsRequest;
import com.example.microservice.model.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
        UserResponse user = new UserResponse("michael"
                , "gelo",
                "gelo@gmail.com");
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @GetMapping
    public String getUsers(@RequestParam(value = "page" , defaultValue = "1") int page,
                           @RequestParam(value = "limit" , defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
                           ) {
        return String.format("users limit request with page : %s and limit : %d and sort : %s", page, limit, sort);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserDetailsRequest userDetails){
        UserResponse user = new UserResponse(userDetails.getFirstName()
                , userDetails.getLastName()
                , userDetails.getEmail());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser(){
        return "a user was updated";
    }

    @DeleteMapping
    public String deleteUser(){
        return "a user was deleted";

    }

}
