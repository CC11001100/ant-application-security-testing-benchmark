package com.iast.astbenchmark.cases.engine.accuracy.trackTaintObject.string.stringPartHasTaint.subNotTaint.string.replace;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iast.astbenchmark.analyser.Category;
import com.iast.astbenchmark.analyser.cache.IastTestCaseDescriptor;
import com.iast.astbenchmark.analyser.cache.IastTestCasePayloadProvider;
import com.iast.astbenchmark.analyser.cache.RequestPayloadConstant;
import com.iast.astbenchmark.common.CommonConsts;

/**
* Introduction X
* Level X  
* Date 2024-08-12
* @author CC11001100 
*/
@RestController

// assession information start
// real vulnerability = true
// assession project = IAST引擎能力评估体系(JAVA) -> 准确度 -> 污点对象跟踪粒度 -> 字符串级别 -> 字符串部分存在污点 -> 截取非污点部分 -> String操作 -> replcace
// compose = AccuracyTrackTaintString_Replace_002_T.java && !AccuracyTrackTaintString_Replace_003_F.java && AccuracyTrackTaintString_Replace_001_T.java
// bind_url = /case00940
// assession information end
public class AccuracyTrackTaintString_Replace_001_T implements IastTestCaseDescriptor, IastTestCasePayloadProvider {

    @PostMapping(value = "case00940")
    public Map<String, Object> aTaintCase00940(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            String hardcode = "abc";
            String urlfull = hardcode + cmd;
            String data = urlfull.replace(hardcode, "");
            Runtime.getRuntime().exec(data);
            modelMap.put("status", CommonConsts.SUCCESS_STR);
        } catch (IOException e) {
            modelMap.put("status", CommonConsts.ERROR_STR);
        }
        return modelMap;
    }

    @Override
    public String[] category() {
        return new String[] {
            //
            Category.LEVEL1_IAST_JAVA_ENGINE,
            //
            Category.LEVEL2_准确度,
            //
            Category.LEVEL3_污点对象跟踪粒度,
            //
            Category.LEVEL4_字符串级别,
            //
            "字符串部分存在污点",
            //
            "截取非污点部分",
            //
            "String操作",
            //
            "replcace",
            //
        };
    }

    @Override
    public Map<String, String> params() {
        return RequestPayloadConstant.DEFAULT_COMMAND_REQUEST_PARAMS;
    }

}
