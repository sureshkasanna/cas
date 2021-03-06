package org.apereo.cas;

import org.apereo.cas.support.openid.authentication.handler.support.OpenIdCredentialsAuthenticationHandlerTests;
import org.apereo.cas.support.openid.authentication.principal.OpenIdServiceFactoryTests;
import org.apereo.cas.support.openid.authentication.principal.OpenIdServiceTests;
import org.apereo.cas.support.openid.web.mvc.SmartOpenIdControllerTests;
import org.apereo.cas.support.openid.web.support.OpenIdPostUrlHandlerMappingTests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * The {@link AllTestsSuite} is responsible for
 * running all openid test cases.
 *
 * @author Misagh Moayyed
 * @since 4.2.0
 */

@SelectClasses({
    OpenIdPostUrlHandlerMappingTests.class,
    SmartOpenIdControllerTests.class,
    OpenIdCredentialsAuthenticationHandlerTests.class,
    OpenIdServiceFactoryTests.class,
    OpenIdServiceTests.class
})
@RunWith(JUnitPlatform.class)
public class AllTestsSuite {
}
