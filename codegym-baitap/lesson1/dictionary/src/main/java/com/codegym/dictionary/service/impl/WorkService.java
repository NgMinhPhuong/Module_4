package com.codegym.dictionary.service.impl;

import com.codegym.dictionary.service.IWorkService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WorkService implements IWorkService {
    public static Map<String, String> listWork;
    static {
        listWork = new HashMap<>();
        listWork.put("hello","Xin chào");
        listWork.put("thanks","cảm ơn");
    }

    @Override
    public String get(String key) {
        if(listWork.get(key) == null){
            return "Không tìm thây1";
        }
        return listWork.get(key);

    }
}
