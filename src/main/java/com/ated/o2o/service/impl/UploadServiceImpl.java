package com.ated.o2o.service.impl;

import com.ated.o2o.dao.UploadRepository;
import com.ated.o2o.entity.Upload;
import com.ated.o2o.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadRepository uploadRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Upload saveOrUpdate(Upload model,MultipartFile[] file) throws IOException {
        if(file.length!=0){
            String url = null;
            for (MultipartFile multipartFile : file) {
                String str="src/main/resources/static/upload/";
                String fileName = multipartFile.getOriginalFilename();
                fileName = UUID.randomUUID().toString().replace("-", "")
                        + fileName.substring(fileName.lastIndexOf("."));
                File saveFile = new File(str + fileName);
                if (!saveFile.getParentFile().exists()) {
                    saveFile.getParentFile().mkdirs();
                }

                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(multipartFile.getBytes());
                out.flush();
                out.close();
                url.concat(fileName+",");
            }
            model.setImage(url);
            return uploadRepository.save(model);
        }else{
            return uploadRepository.save(model);
        }
    }

    @Override
    public Page<Upload> findAllUploadByPage(int page, int size) {
        Pageable pageable = new PageRequest(page,size);
        Page<Upload> uploads = uploadRepository.findAll(pageable);
        return uploads;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void delete(Long id) {
        uploadRepository.delete(id);
    }

}
