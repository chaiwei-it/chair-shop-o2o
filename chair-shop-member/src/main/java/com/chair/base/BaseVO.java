package com.chair.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by shihan on 2019/12/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVO<T> {

    private Integer stateCode;

    private String msg;

    private T data;

    public boolean isSuccess() {
        return stateCode == StateCode.SUCCESS.getCode();
    }

}
