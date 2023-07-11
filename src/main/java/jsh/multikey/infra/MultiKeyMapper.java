package jsh.multikey.infra;

import jsh.multikey.domain.CompositeKeyItem;
import jsh.multikey.domain.CustomKeyItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import static jsh.multikey.infra.MultiKeyQuery.COMPOSITE_KEY_INSERT;
import static jsh.multikey.infra.MultiKeyQuery.COMPOSITE_KEY_SELECT;
import static jsh.multikey.infra.MultiKeyQuery.COMPOSITE_KEY_SELECT_REVERSE_QUERY;
import static jsh.multikey.infra.MultiKeyQuery.CUSTOM_KEY_INSERT;
import static jsh.multikey.infra.MultiKeyQuery.CUSTOM_KEY_SELECT;
import static jsh.multikey.infra.MultiKeyQuery.CUSTOM_KEY_SELECT_WHERE_PARAMS;

@Mapper
public interface MultiKeyMapper {

    @Select(CUSTOM_KEY_SELECT)
    CustomKeyItem getCustomKeyItem(String id);
    @Select(CUSTOM_KEY_SELECT_WHERE_PARAMS)
    CustomKeyItem getCustomKeyItemWhereParams(long paramOne, long paramTwo, long paramThree);
    @Insert(CUSTOM_KEY_INSERT)
    void insertCustomKeyItem(String id, long paramOne, long paramTwo, long paramThree, String info);
    @Select(COMPOSITE_KEY_SELECT)
    CompositeKeyItem getCompositeKeyItem(long paramOne, long paramTwo, long paramThree);
    @Select(COMPOSITE_KEY_SELECT_REVERSE_QUERY)
    CompositeKeyItem getCompositeKeyItemReverseQuery(long paramOne, long paramTwo, long paramThree);
    @Insert(COMPOSITE_KEY_INSERT)
    void insertCompositeKeyItem(long paramOne, long paramTwo, long paramThree, String info);
}
