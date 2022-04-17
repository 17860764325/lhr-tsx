package com.lhrtsx.study.service.impl;

import com.lhrtsx.study.dto.ClassificationDto;
import com.lhrtsx.study.enirty.Classification;
import com.lhrtsx.study.mapper.ClassificationMapper;
import com.lhrtsx.study.service.ClassificationService;
import com.lhrtsx.study.util.beanCopy.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private ClassificationMapper classificationMapper;

    @Override
    public List<ClassificationDto> getAll() {
        // 查询所有分类
        List<Classification> classifications = classificationMapper.selectAll();
        List<ClassificationDto> classificationDtos = BeanCopyUtils.listCopy(classifications, ClassificationDto.class);
        classificationDtos.forEach(classificationDto -> {
            classificationDto.setChildren(new ArrayList<ClassificationDto>());
                });
        // 得到里面的第一层节点
        Map<Long ,ClassificationDto> map = new HashMap<>();
        // 创建一个list用来存储最终结果
        List<ClassificationDto> resultList = new ArrayList<>();
        for (ClassificationDto classification : classificationDtos) {
            if (classification.getPid() == 0) {
                map.put(classification.getId(),classification);
            }
        }
        for (ClassificationDto classification : classificationDtos) {
            if(map.get(classification.getPid()) != null ){
                map.get(classification.getPid()).getChildren().add(classification);
            }
        }
        for (Map.Entry<Long, ClassificationDto> entry : map.entrySet()) {
            resultList.add(entry.getValue());
        }
        return resultList;
    }
}
