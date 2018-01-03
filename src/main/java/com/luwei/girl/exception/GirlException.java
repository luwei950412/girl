package com.luwei.girl.exception;

import com.luwei.girl.enums.ResultEnum;

/**
 * created by  luwei
 * 2017-10-16 17:20.
 **/
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
