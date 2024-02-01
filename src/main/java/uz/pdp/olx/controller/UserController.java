package uz.pdp.olx.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.olx.dto.userdto.UserUpdateDto;
import uz.pdp.olx.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok(userService.update(userUpdateDto));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
