package com.cloud.common.base;

import com.cloud.common.base.entity.BasePo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class BaseEntity<T extends BasePo> {

    /**
     * DTO -> PO
     * 
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        return t;
    }
    
}