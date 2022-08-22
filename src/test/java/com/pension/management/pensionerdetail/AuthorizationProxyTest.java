package com.pension.management.pensionerdetail;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.pension.management.pensionerdetail.proxy.AuthorizationProxy;

public class AuthorizationProxyTest {

	AuthorizationProxy mockproxy = mock(AuthorizationProxy.class);
	
	@Test
	public void testToken()
	{
		String token="Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2hhbiIsImV4cCI6MTY2MDYzMDk4MSwiaWF0IjoxNjYwNjI3MzgxfQ.7-CzsVJpLCSFVCzIEbUwE-FSr5JICfUmfnIe8E51Q-s";
		when(mockproxy.validateAndReturnUser(token)).thenReturn(true);
	}
	
	@Test
	public void FailToken()
	{
		String token="Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIofkokeeiOiJtb2hhbiIsImV4cCI6MTY2MDYzMDk4MSwiaWF0IjoxNjYwNjI3MzgxfQ.7-CzsVJpLCSFVCzIEbUwE-FSr5JICfUmfnIe8E51Q-s";
		when(mockproxy.validateAndReturnUser(token)).thenReturn(false);
	}
}
