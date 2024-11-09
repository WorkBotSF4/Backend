package com.uco.backend.api.trasformate.infraestructure.rest.User;

import com.uco.backend.api.trasformate.application.UserService;
import com.uco.backend.api.trasformate.domain.model.User;
import com.uco.backend.api.trasformate.infraestructure.dto.RoleDTO;
import com.uco.backend.api.trasformate.infraestructure.dto.UserRoutineDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/crear")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/get/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping("/all")
    public Iterable<User> findAll() {
        return userService.findAll();
    }
    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }

    @PostMapping("/upd/role")
    public User updRole(@RequestBody RoleDTO role) {
        return userService.update(role);
    }

    @PostMapping("/upd/routine")
    public User updRoutine(@RequestBody UserRoutineDTO routineDTO) {
        return userService.UpdateRutine(routineDTO);
    }

}
