package rw.ac.rca.online_shopping_system.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.online_shopping_system.DTO.AuthRequest;
import rw.ac.rca.online_shopping_system.DTO.AuthResponse;
import rw.ac.rca.online_shopping_system.DTO.Response;
import rw.ac.rca.online_shopping_system.DTO.UserDTO;
import rw.ac.rca.online_shopping_system.authentication.JwtTokenUtil;
import rw.ac.rca.online_shopping_system.enums.ResponseType;
import rw.ac.rca.online_shopping_system.services.UserService;
import rw.ac.rca.online_shopping_system.services.CustomUserDetailsService;
import rw.ac.rca.online_shopping_system.utils.ExceptionHandlerUtil;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, CustomUserDetailsService customUserDetailsService, JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new User")
    public ResponseEntity<Response> registerUser(@RequestBody UserDTO userDTO) {
        try {
            System.out.println(userDTO);
            return ResponseEntity.status(201).body(new Response().setResponseType(ResponseType.SUCCESS).setPayload(userService.registerUser(userDTO)));
        }catch (Exception e){
            return ExceptionHandlerUtil.handleException(e);
        }
    }

    @PostMapping("/login")
    @Operation(summary = "Authenticate a User")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
