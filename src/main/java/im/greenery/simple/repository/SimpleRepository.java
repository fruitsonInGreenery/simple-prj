package im.greenery.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import im.greenery.simple.entity.Simple;

public interface SimpleRepository extends JpaRepository<Simple, Long> {

    
}