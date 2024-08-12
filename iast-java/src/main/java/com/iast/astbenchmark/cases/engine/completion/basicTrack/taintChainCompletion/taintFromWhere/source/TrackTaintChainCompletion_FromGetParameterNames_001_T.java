package com.iast.astbenchmark.cases.engine.completion.basicTrack.taintChainCompletion.taintFromWhere.source;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iast.astbenchmark.analyser.Category;
import com.iast.astbenchmark.analyser.cache.IastTestCase;
import com.iast.astbenchmark.analyser.cache.IastTestCaseDescriptor;
import com.iast.astbenchmark.analyser.cache.IastTestCasePayloadProvider;
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
// assession project = IAST引擎能力评估体系(JAVA) -> 完整度 -> 基础跟踪能力 -> 污点链路完整度 -> 污点来源识别能力(source) -> 污点来自http body -> form/url-encode -> getParameterNames
// compose = TrackTaintChainCompletion_FromGetParameterNames_001_T.java
// bind_url = /case0040
// assession information end
public class TrackTaintChainCompletion_FromGetParameterNames_001_T
    implements IastTestCaseDescriptor, IastTestCasePayloadProvider {

    /**
     * 污点来自http body form/url-encode getParameterNames
     *
     * @param
     * @return
     */
    @PostMapping(value = "case0040")
    @IastTestCase(caseNo = "aTaintCase0040",
        caseFullName = "IAST引擎能力评估体系(JAVA)->完整度->基础跟踪能力->污点链路完整度->污点来源识别能力(source)->污点来自http body->form/url-encode->getParameterNames",
        thisMethodTag = "aTaintCase0040", hasVul = true)
    public Map<String, Object> aTaintCase0040(@RequestParam("cmd") String cmd, HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            String cmdStr = request.getParameterNames().nextElement();
            Runtime.getRuntime().exec(cmdStr);
            modelMap.put("status", CommonConsts.SUCCESS_STR);
        } catch (IOException e) {
            modelMap.put("status", CommonConsts.ERROR_STR);
        }
        return modelMap;
    }

    @Override
    public String caseNo() {
        return "aTaintCase0040";
    }

    @Override
    public String[] category() {
        return new String[] {
            //
            Category.LEVEL1_IAST_JAVA_ENGINE,
            //
            Category.LEVEL2_完整度,
            //
            Category.LEVEL3_基础跟踪能力,
            //
            Category.LEVEL4_污点链路完整度,
            //
            Category.LEVEL5_污点来源识别能力,
            //
            Category.LEVEL6_污点来自HttpBody,
            //
            "form/url-encode",
            //
            "getParameterNames",
            //
        };
    }

}
