// This code is based on:
//
//   com.thoughtworks.selenium.webdriven.commands.GetCookie
//
// in Selenium WebDriver.
//
// The following copyright is copied from original.
// ---
// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package jp.vmi.selenium.selenese.subcommand;

import java.util.stream.Collectors;

import jp.vmi.selenium.selenese.Context;

/**
 * Re-implementation of GetCookie.
 */
public class GetCookie extends AbstractSubCommand<String> {

    /**
     * Constructor.
     */
    public GetCookie() {
        super();
    }

    @Override
    public String execute(Context context, String... args) {
        return context.getWrappedDriver().manage().getCookies().stream()
            .map(cookie -> cookie.getName() + "=" + cookie.getValue())
            .collect(Collectors.joining("; "));
    }
}
