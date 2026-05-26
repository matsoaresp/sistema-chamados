package chamados.homeney.controller;
import chamados.homeney.dto.request.RequestCalledDto;
import chamados.homeney.entity.Called;
import chamados.homeney.service.CalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Called>> listAllCalled () {
       List<Called> called = calledService.listAllCalled();
       return ResponseEntity.ok().body(called);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Called> findCalled (@PathVariable Long id) throws  Exception{
        Called called = calledService.findCalled(id);
        return ResponseEntity.ok().body(called);
    }

    @PatchMapping("{id}/take")
    public ResponseEntity<Called> takeCalled (
            @PathVariable Long id
    ) throws  Exception {
        Called called = calledService.takeCalled(id);
        return ResponseEntity.ok(called);
    }

    @PatchMapping("/{id}/finish")
    public ResponseEntity<Called> finishCalled (
            @PathVariable Long id
    ) throws  Exception {
        Called called = calledService.finishCalled(id);
        return ResponseEntity.ok(called);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Called> cancelCalled (
            @PathVariable Long id
    ) throws  Exception {
        Called called = calledService.cancelCalled(id);
        return ResponseEntity.ok(called);
    }
}
