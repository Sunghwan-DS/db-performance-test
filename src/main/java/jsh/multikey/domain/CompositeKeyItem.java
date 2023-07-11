package jsh.multikey.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompositeKeyItem {

    long paramOne;
    long paramTwo;
    long paramThree;
    String info;
    Date createDt;
    Date updateDt;
}
