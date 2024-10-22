package im.greenery.simple.controller;

import im.greenery.simple.dto.SimpleReq;
import im.greenery.simple.entity.Simple;
import im.greenery.simple.service.SimpleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/simple")
@AllArgsConstructor
@Tag(name = "Simple", description = "Simple API")
public class SimpleController {

    private final SimpleService simpleService;

    @GetMapping
    @Operation(summary = "전체 조회", description = "전체 항목을 조회합니다.")
    public ResponseEntity<List<Simple>> findAll() {
        List<Simple> result = simpleService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{id}")
    @Operation(summary = "ID 조회", description = "ID로 항목을 조회합니다.")
    public ResponseEntity<Simple> getMethodName(@PathVariable Long id) {
        Simple result = simpleService.findById(id);
        return ResponseEntity.ok().body(result);
    }    

    @PostMapping
    @Operation(summary = "저장", description = "새로운 항목을 저장합니다.")
    public ResponseEntity<?> postMethodName(@RequestBody SimpleReq req) {
        simpleService.save(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "ID 수정", description = "ID의 항목을 수정합니다.")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @RequestBody SimpleReq req) throws Exception {
        simpleService.update(id, req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "ID 삭제", description = "ID의 항목을 삭제합니다.")
    public ResponseEntity<?> deleteMethodName(@PathVariable Long id) {
        simpleService.delete(id);        
        return ResponseEntity.ok().build();
    }    
}
