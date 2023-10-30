package com.examination.project.infrastructure.persistance.common.readonly;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface ReadOnlyRepository {
	
}