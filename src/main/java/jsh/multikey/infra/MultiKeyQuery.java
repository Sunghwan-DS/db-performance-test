package jsh.multikey.infra;

public class MultiKeyQuery {

    //language=SQL
    public static final String CUSTOM_KEY_SELECT =
        """
        SELECT * FROM CUSTOM_KEY WHERE id = #{id}
        """;

    //language=SQL
    public static final String CUSTOM_KEY_SELECT_WHERE_PARAMS =
        """
        SELECT * FROM CUSTOM_KEY WHERE param_one = #{paramOne}
                                 AND param_two = #{paramTwo}
                                 AND param_three = #{paramThree}
        """;

    //language=SQL
    public static final String CUSTOM_KEY_INSERT =
        """
        INSERT INTO CUSTOM_KEY values (#{id}, #{paramOne}, #{paramTwo}, #{paramThree}, #{info}, sysdate, sysdate)
        """;

    //language=SQL
    public static final String COMPOSITE_KEY_SELECT =
        """
        SELECT * FROM COMPOSITE_KEY WHERE param_one = #{paramOne}
                                    AND param_two = #{paramTwo}
                                    AND param_three = #{paramThree}
        """;

    //language=SQL
    public static final String COMPOSITE_KEY_SELECT_REVERSE_QUERY =
        """
        SELECT * FROM COMPOSITE_KEY WHERE param_three = #{paramThree}
                                    AND param_two = #{paramTwo}
                                    AND param_one = #{paramOne}
        """;


    //language=SQL
    public static final String COMPOSITE_KEY_INSERT =
        """
        INSERT INTO COMPOSITE_KEY values (#{paramOne}, #{paramTwo}, #{paramThree}, #{info}, sysdate, sysdate)
        """;
}
