package com.cqjtu.cssl.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author suwen
 * @since 2020-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArrangePeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer aid;

    private Integer labWeek;

    private Integer labDay;

    private Integer labSession;

    private String expProname;


}
