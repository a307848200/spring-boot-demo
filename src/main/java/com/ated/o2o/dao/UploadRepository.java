package com.ated.o2o.dao;

import com.ated.o2o.entity.Upload;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {


}
