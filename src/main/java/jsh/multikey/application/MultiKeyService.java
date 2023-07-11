package jsh.multikey.application;

import jsh.multikey.domain.CustomKeyItem;

public interface MultiKeyService {

    CustomKeyItem getCustomKeyItem(String id);
    void insertCustomKeyItem(String id, long param1, long param2, long param3, String info);
}
