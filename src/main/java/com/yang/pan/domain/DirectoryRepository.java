package com.yang.pan.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectoryRepository extends JpaRepository<Directory, Integer> {
    public void deleteAllByUname(String uname);
    public List<Directory> findAllByUnameAndUpdirid(String uname,Integer did);
}
