package im.greenery.simple.service;

import java.util.List;

import org.springframework.stereotype.Service;

import im.greenery.simple.dto.SimpleReq;
import im.greenery.simple.entity.Simple;
import im.greenery.simple.repository.SimpleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SimpleService {
    
    private final SimpleRepository repository;

    public List<Simple> findAll() {        
        return repository.findAll();
    }

    public Simple findById(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    public void save(SimpleReq req) {
        Simple savedSimple = Simple.builder()
            .name(req.getName())
            .email(req.getEmail())
            .phone(req.getPhone())
            .build();
        repository.save(savedSimple);
    }

    @Transactional
    public void update(Long id, SimpleReq req) throws Exception {
        Simple simple = repository.findById(id).orElseThrow(() -> new Exception());
        simple.setName(req.getName());
        simple.setEmail(req.getEmail());
        simple.setPhone(req.getPhone());        
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
