package org.smart.cmd;

import javax.servlet.http.HttpServletRequest;

public interface ICMD {
	String action(HttpServletRequest request);
}
