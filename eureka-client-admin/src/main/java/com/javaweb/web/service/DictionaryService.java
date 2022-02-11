package com.javaweb.web.service;

import java.util.List;

import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.dictionary.DictionaryListRequest;
import com.javaweb.web.po.Dictionary;

public interface DictionaryService {
    
    List<Dictionary> selectAll();
    
    List<Dictionary> getDictionary(Dictionary dictionary);
    
    void dictionaryAdd(Dictionary dictionary);
    
    Page dictionaryList(DictionaryListRequest dictionaryListRequest);
    
    void dictionaryModify(Dictionary dictionary);
    
    Dictionary dictionaryDetail(String dictionaryId);
    
    void dictionaryDelete(String dictionaryId);
	
}
