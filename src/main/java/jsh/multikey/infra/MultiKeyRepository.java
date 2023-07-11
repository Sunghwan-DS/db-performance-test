package jsh.multikey.infra;

import jsh.multikey.domain.CompositeKeyItem;
import jsh.multikey.domain.CustomKeyItem;

public interface MultiKeyRepository {

    CustomKeyItem getCustomKeyItem(String id);
    void insertCustomKeyItem(String id, long param1, long param2, long param3, String info);
    CompositeKeyItem getCompositeKeyItem(long param1, long param2, long param3);
    void insertCompositeKeyItem(long param1, long param2, long param3, String info);
}
