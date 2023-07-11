package jsh.multikey.infra;

import jsh.multikey.domain.CompositeKeyItem;
import jsh.multikey.domain.CustomKeyItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MultiKeyRepositoryImpl implements MultiKeyRepository {

    private final MultiKeyMapper multiKeyMapper;

    @Override
    public CustomKeyItem getCustomKeyItem(String id) {
        return multiKeyMapper.getCustomKeyItem(id);
    }

    @Override
    public void insertCustomKeyItem(String id, long param1, long param2, long param3, String info) {
        multiKeyMapper.insertCustomKeyItem(id, param1, param2, param3, info);
    }

    @Override
    public CompositeKeyItem getCompositeKeyItem(long param1, long param2, long param3) {
        return multiKeyMapper.getCompositeKeyItem(param1, param2, param3);
    }

    @Override
    public void insertCompositeKeyItem(long param1, long param2, long param3, String info) {
        multiKeyMapper.insertCompositeKeyItem(param1, param2, param3, info);
    }
}
