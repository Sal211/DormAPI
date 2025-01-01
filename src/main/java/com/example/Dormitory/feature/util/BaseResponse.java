package com.example.Dormitory.feature.util;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.example.Dormitory.feature.util.constant.GlobalConstant.FAIL;
import static com.example.Dormitory.feature.util.constant.GlobalConstant.SUCCESS;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    @Builder.Default
    String status = FAIL;
    @Builder.Default
    String responseMsg = "";
    @Builder.Default
    String errMsg = "";
    T Data;

    public void isSuccess(){
        status = SUCCESS;
    }
}
