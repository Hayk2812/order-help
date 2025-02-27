package com.platform.controller;

import com.platform.constants.RoutConstants;
import com.platform.exceptions.ExceptionResponse;
import com.platform.model.User;
import com.platform.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping(RoutConstants.BASE_URL + RoutConstants.VERSION + RoutConstants.USERS)
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Get user with given ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),

            @ApiResponse(responseCode = "500", description = "Error occurred while getting user", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping("/{id}")
    public @ResponseBody User getById(@PathVariable UUID id) {
        log.info("Received request to get user");
        User user = userService.getById(id);
        log.info("User found");
        return user;
    }


    @Operation(summary = "Get list of users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),

            @ApiResponse(responseCode = "500", description = "Error occurred while getting user", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping
    public @ResponseBody List<User> getUsers() {
        log.info("Received request to get list of  users ");
        List<User> users = userService.getUsers();
        log.info("Users found");
        return users;
    }


    @Operation(summary = "Create user with specified parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid request to send endpoint", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
            @ApiResponse(responseCode = "409", description = "User already excists", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Error occurred while creating user", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody User create(@RequestBody @Valid User user) {
        log.info("Received request to create user");
        User newUser = userService.createUser(user);
        log.info("User created successfully");
        return newUser;
    }
    @Operation(summary = "Get list of users by given email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),

            @ApiResponse(responseCode = "500", description = "Error occurred while getting user", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping(params = "email")
    public @ResponseBody List<User> getUsersByEmail(@RequestParam(required = false)String email) {
        log.info("Received request to get list of  users by email");
        List<User> users = userService.getUsersByEmail(email);
        log.info("Users found");
        return users;
    }
}

