package com.scorpios.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.scorpios.eduservice.entity.Subject;
import com.scorpios.eduservice.entity.excel.SubjectData;
import com.scorpios.eduservice.listener.SubjectExcelListener;
import com.scorpios.eduservice.mapper.SubjectMapper;
import com.scorpios.eduservice.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author scorpios
 * @since 2020-04-02
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    //添加课程分类
    @Transactional
    @Override
    public void saveSubject(MultipartFile file,SubjectService subjectService) {
        try {
            //文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(subjectService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
