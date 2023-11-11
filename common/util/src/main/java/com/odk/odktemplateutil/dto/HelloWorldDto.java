package com.odk.odktemplateutil.dto;

import com.odk.base.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * HelloWorldDto
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HelloWorldDto extends DTO {

    private String name;
}
