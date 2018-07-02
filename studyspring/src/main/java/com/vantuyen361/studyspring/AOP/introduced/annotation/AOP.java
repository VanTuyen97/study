/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.introduced.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen
 */
@Component
@Aspect
public class AOP {
    @DeclareParents(value="com.vantuyen361.studyspring.AOP.introduced.annotation.Location"//can ispackage.class+ to specifies this class and class extends this
            , defaultImpl=com.vantuyen361.studyspring.AOP.introduced.annotation.Student.class)
    public static Person person;
}
