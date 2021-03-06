/*
 * Copyright 2017 Rudy De Busscher (www.atbash.be)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.atbash.ee.security.octopus.demo.scs.app2.rest;

import be.c4j.ee.security.model.UserPrincipal;
import org.apache.shiro.authz.annotation.RequiresUser;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Rest endpoint which return the name of the authenticated user (JWT within header)
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    private UserPrincipal principal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RequiresUser
    public TestData sayHello() {
        TestData result = new TestData();
        result.setName(principal.getName());
        return result;
    }

    public static class TestData {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
