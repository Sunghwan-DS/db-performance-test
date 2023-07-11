package jsh.multikeytest;

import jsh.multikey.domain.CompositeKeyItem;
import jsh.multikey.domain.CustomKeyItem;
import jsh.multikey.infra.MultiKeyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MultiKeyControllerTest {

    private final MultiKeyMapper multiKeyMapper;

    @Autowired
    public MultiKeyControllerTest(MultiKeyMapper multiKeyMapper) {
        this.multiKeyMapper = multiKeyMapper;
    }

    @Test
    void insertCustomKeyTest() {
        String id, info;
        long param1, param2, param3;

        for (int i = 0; i < 1000000; i++) {
            param1 = param2 = param3 = i;
            id = Long.toString(param1) + "_" + Long.toString(param2) + "_" + Long.toString(param3);
            info = Long.toString(Math.floorMod(i, 10));
            multiKeyMapper.insertCustomKeyItem(id, param1, param2, param3, info);
        }
    }

    @Test
    void insertCompositeKeyTest() {
        String info;
        long param1, param2, param3;

        for (int i = 0; i < 1000000; i++) {
            param1 = param2 = param3 = i;
            info = Long.toString(Math.floorMod(i, 10));
            multiKeyMapper.insertCompositeKeyItem(param1, param2, param3, info);
        }
    }

    @Test
    void selectCustomAndCompositeKeyTest() {
        long customKeyStartTime = System.currentTimeMillis();

        String id;
        long param1, param2, param3;
        CustomKeyItem customKeyItem;
        CompositeKeyItem compositeKeyItem;

        for (int i = 500000; i < 510000; i++) {
            param1 = param2 = param3 = i;
            id = Long.toString(param1) + "_" + Long.toString(param2) + "_" + Long.toString(param3);
            customKeyItem = multiKeyMapper.getCustomKeyItem(id);
        }
        long customKeyEndTime = System.currentTimeMillis();
        log.info("customKey: " + Long.toString(customKeyEndTime - customKeyStartTime));

        long customKeyWhereParamsStartTime = System.currentTimeMillis();
        for (int i = 500000; i < 510000; i++) {
            param1 = param2 = param3 = i;
            id = Long.toString(param1) + "_" + Long.toString(param2) + "_" + Long.toString(param3);
            customKeyItem = multiKeyMapper.getCustomKeyItemWhereParams(param1, param2, param3);
        }
        long customKeyWhereParamsEndTime = System.currentTimeMillis();
        log.info("customKey: " + Long.toString(customKeyWhereParamsEndTime - customKeyWhereParamsStartTime));

        long compositeKeyStartTime = System.currentTimeMillis();

        for (int i = 500000; i < 510000; i++) {
            param1 = param2 = param3 = i;
            compositeKeyItem = multiKeyMapper.getCompositeKeyItem(param1, param2, param3);
        }
        long compositeKeyEndTime = System.currentTimeMillis();
        log.info("compositeKey: " + Long.toString(compositeKeyEndTime - compositeKeyStartTime));
    }

    @Test
    void selectCompositeKeyReverse() {

        long param1, param2, param3;
        CompositeKeyItem compositeKeyItem;

        long compositeKeyStartTime = System.currentTimeMillis();

        for (int i = 500000; i < 510000; i++) {
            param1 = param2 = param3 = i;
            compositeKeyItem = multiKeyMapper.getCompositeKeyItem(param1, param2, param3);
        }
        long compositeKeyEndTime = System.currentTimeMillis();
        log.info("compositeKey: " + Long.toString(compositeKeyEndTime - compositeKeyStartTime));

        long compositeKeyReverseStartTime = System.currentTimeMillis();

        for (int i = 500000; i < 510000; i++) {
            param1 = param2 = param3 = i;
            compositeKeyItem = multiKeyMapper.getCompositeKeyItemReverseQuery(param1, param2, param3);
        }
        long compositeKeyReverseEndTime = System.currentTimeMillis();
        log.info("compositeKeyReverse: " + Long.toString(compositeKeyEndTime - compositeKeyStartTime));

    }
}
