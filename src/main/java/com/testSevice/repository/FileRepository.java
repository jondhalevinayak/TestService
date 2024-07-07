package com.testSevice.repository;

import com.testSevice.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FileRepository extends JpaRepository<File, Integer> {

    ArrayList<File> findAll();
}
