package com.spring.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EidValidator implements Validator {

	public boolean supports(Class arg0) {
		return EidSearchCommand.class.equals(arg0);
	}

	public void validate(Object obj, Errors errors) {
		EidSearchCommand eidSearchCommand = (EidSearchCommand) obj;
		String eid = eidSearchCommand.getEid();
		if (eid == null || eid.length() == 0) {
			errors.rejectValue("eid", "errors.eid.required");
		} else if (!eid.startsWith("EMP-")) {
			errors.rejectValue("eid", "errors.eid.format1");
		} else {
			String p = eid.substring(4);
			try {
				int x = Integer.parseInt(p);
				if (x < 100 || x > 999) {
					errors.rejectValue("eid", "errors.eid.format2");
				}
			} catch (Exception e) {
				errors.rejectValue("eid", "errors.eid.format3");
			}
		}
	}
}
