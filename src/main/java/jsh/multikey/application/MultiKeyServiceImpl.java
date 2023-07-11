package jsh.multikey.application;

import jsh.multikey.domain.CustomKeyItem;
import jsh.multikey.infra.MultiKeyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MultiKeyServiceImpl implements MultiKeyService {

    private final MultiKeyMapper multiKeyMapper;

    public CustomKeyItem getCustomKeyItem(String id) {
        return multiKeyMapper.getCustomKeyItem(id);
    }

    public void insertCustomKeyItem(String id, long param1, long param2, long param3, String info) {
        multiKeyMapper.insertCustomKeyItem(id, param1, param2, param3, info);
    }
}
