package com.examination.project.handler.persistance.common.readonly;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface ReadOnlyRepository {
	
}