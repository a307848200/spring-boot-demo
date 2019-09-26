package com.ated.o2o.service;

import com.ated.o2o.entity.Upload;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UploadService {

    Upload saveOrUpdate(Upload model, MultipartFile[] file) throws IOException;

    Page<Upload>findAllUploadByPage(int page,int size);

    void delete(Long id);
}
