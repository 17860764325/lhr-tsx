package com.lhrtsx.study.Controller;

import com.lhrtsx.study.dto.ClassificationDto;
import com.lhrtsx.study.enirty.Classification;
import com.lhrtsx.study.service.impl.ClassificationServiceImpl;
import com.lhrtsx.study.util.resultDate.ResultData;
import com.lhrtsx.study.util.resultDate.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 *  //分类Contriller，各种笔记分类
 * @author lhr
 * @date  2022/4/17 19:33
 * @param
 * @return:
 */
@RestController
@RequestMapping("/classification")
public class ClassificationController extends Controller {

    @Autowired
    private ClassificationServiceImpl classificationServiceImpl;

    @GetMapping("/getAll")
    @ResponseBody
    public ResultData<List<ClassificationDto>> TestAll(){
        ResultData<List<ClassificationDto>> resultData = new ResultData<>();
        resultData.setData(classificationServiceImpl.getAll());
        resultData.setStatus(ReturnCode.RC100.getCode());
        return resultData;
    }



}
