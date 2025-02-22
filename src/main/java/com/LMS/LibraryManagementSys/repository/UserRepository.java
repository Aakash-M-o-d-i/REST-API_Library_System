package com.LMS.LibraryManagementSys.repository;

import com.LMS.LibraryManagementSys.User;
import org.springframework.data.jpa.repository.JpaRepository;
//  Database for user
public interface UserRepository extends JpaRepository<User, Long> {
}
