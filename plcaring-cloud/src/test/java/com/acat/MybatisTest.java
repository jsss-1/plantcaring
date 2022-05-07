package com.acat;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.acat.dao.pojo.Condition;
import com.acat.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
public class MybatisTest {
    @Autowired
    private ConditionService conditionService;
    @Test
    public void insert(){
//        Condition condition = new Condition();
//        condition.setKind("xxxx");
//        conditionService.save(condition);
        BaseMapper<Condition> baseMapper = conditionService.getBaseMapper();
        System.out.println(baseMapper);
    }
    @Test
    public void inser(){
        String[] words = new String[]{"ab","ac"};
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            System.out.println(word);
            int wordLength = word.length();
            System.out.println(wordLength);
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
                System.out.println(masks[i]);
            }
        }
        System.out.println(masks);
//        ab
//        2
//        1
//        3
//        cd
//        2
//        4
//        12

    }
    @Test
    public void a(){
        System.out.println(1<<0);
    }
}
