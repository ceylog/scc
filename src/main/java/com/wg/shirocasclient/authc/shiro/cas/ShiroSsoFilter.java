package com.wg.shirocasclient.authc.shiro.cas;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

public class ShiroSsoFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;

		Principal principal = request.getUserPrincipal();
		if (principal != null) {
			// 这里是多源数据库的选择,系统根据用户组的不同会选择不同的数据库操作
			// DatasourceContextHolder.setGroupType(GroupType.CUSTOMER);

			TrustedSsoAuthenticationToken token = new TrustedSsoAuthenticationToken(
					principal.getName());
			SecurityUtils.getSubject().login(token);
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}
}