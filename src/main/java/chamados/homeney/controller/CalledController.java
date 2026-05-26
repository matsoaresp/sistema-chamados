package chamados.homeney.controller;

import chamados.homeney.dto.request.RequestCalledDto;
import chamados.homeney.entity.Called;
import chamados.homeney.service.CalledService;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/called")
public class CalledController {

    @Autowired
    private CalledService calledService;

    @PostMapping("create-called")
    public ResponseEntity<Called> createCalled (@RequestBody RequestCalledDto dto){
        Called called = calledService.createCalled(dto);
        return ResponseEntity.ok().body(called);
    }

}
