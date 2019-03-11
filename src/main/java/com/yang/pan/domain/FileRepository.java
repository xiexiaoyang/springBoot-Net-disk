package com.yang.pan.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  FileRepository extends JpaRepository<File, Integer> {
    public void deleteAllByUname(String uname);
    //public List<File> findAllByUname(String uname);
    public List<File> findAllByUpdirid(Integer updirid);
    public File findByFilename(String fileName);
}
