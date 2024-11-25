package com.example.authorizationserver.repository;

import com.example.authorizationserver.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
