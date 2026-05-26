package chamados.homeney.controller;

import chamados.homeney.dto.request.RequestUserDto;
import chamados.homeney.entity.User;
import chamados.homeney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create-user")
    public ResponseEntity<User> createUser (@RequestBody RequestUserDto dto){
        User user = userService.createUser(dto);
        return ResponseEntity.status(201).body(user);
    }

    @PostMapping("create-atendent")
    public ResponseEntity<User> createAtendent (@RequestBody RequestUserDto dto){
        User user = userService.createAtendent(dto);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findOne (@PathVariable Long id) throws Exception{
        User user = userService.findOne(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll (){
        List<User> user = userService.findAll();
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<User> delete (@PathVariable Long id) throws  Exception{
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
