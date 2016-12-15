package com.jpmorgan.util;

import java.lang.reflect.Field;

public class Validations {

	public static boolean isNotValidObject( Object obj ) {
		
		if ( obj == null ){
			return Boolean.TRUE;
		}
		
		try {
			
			for ( Field f : obj.getClass().getDeclaredFields()  ) {
				
				f.setAccessible( true );
				
				if ( f.get( obj ) == null ){
					
					return Boolean.TRUE;
					
				}
				
			}
			
			return Boolean.FALSE;
			
		} catch ( Exception e ) {
			
			return Boolean.FALSE;
			
		}

	}
}
