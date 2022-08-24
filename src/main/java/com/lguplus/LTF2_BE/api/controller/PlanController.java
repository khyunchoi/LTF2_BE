package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;
import com.lguplus.LTF2_BE.api.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        List<PlanResDto> result = null;

        try {
            result = planService.findAll();

            if(result.size() == 0) {
                resultMap.put("message", "해당하는 요금제가 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("PlanList", result);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "요금제를 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(resultMap, status);
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/telecom-tech/{telecomTech}")
    public ResponseEntity<Map<String, Object>> findByTelecomTech(@PathVariable(value="telecomTech") String telecomTech) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        List<PlanResDto> result = null;
        try {
            result = planService.findByTelecomTech(telecomTech);

            if(result.size() == 0) {
                resultMap.put("message", "해당하는 요금제가 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("PlanList", result);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "요금제를 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(resultMap, status);
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/{plan_id}")
    public ResponseEntity<Map<String, Object>> findOne(@PathVariable(value="plan_id") Long planId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        PlanResDto result = null;

        try {
            result = planService.findOne(planId);

            if(result == null) {
                resultMap.put("message", "해당하는 요금제가 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("Plan", result);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "요금제를 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(resultMap, status);
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
