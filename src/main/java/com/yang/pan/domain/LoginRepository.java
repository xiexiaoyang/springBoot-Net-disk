package com.yang.pan.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer> {

    public Login findByUname(String uname);
    public void deleteAllByUname(String uname);
}
