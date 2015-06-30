/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.xing.api.impl.json;


import org.springframework.social.xing.api.*;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Jackson module for registering mixin annotations against Xing model classes.
 */
public class XingModule extends SimpleModule {

    public XingModule() {
        super("XingModule", new Version(1, 0, 0, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(XingProfile.class, XingProfileMixin.class);
        context.setMixInAnnotations(XingProfiles.class, XingProfilesMixin.class);
        context.setMixInAnnotations(BirthDate.class,BirthDateMixin.class);
        context.setMixInAnnotations(PhotoUrls.class,PhotoUrlsMixin.class);
        context.setMixInAnnotations(PrivateAddress.class,PrivateAddressMixin.class);
        context.setMixInAnnotations(BusinessAddress.class,BusinessAddressMixin.class);
        context.setMixInAnnotations(Address.class,AddressMixin.class);
        context.setMixInAnnotations(Company.class, CompanyMixin.class);
        context.setMixInAnnotations(ProfessionalExperience.class, ProfessionalExperienceMixin.class);
        context.setMixInAnnotations(WebProfiles.class, WebProfilesMixin.class);
        context.setMixInAnnotations(InstantMessagingAccounts.class, InstantMessagingAccountsMixin.class);
        context.setMixInAnnotations(EducationalBackground.class, EducationalBackgroundMixin.class);
        context.setMixInAnnotations(XingDate.class, XingDateMixin.class);
        context.setMixInAnnotations(Award.class, AwardMixin.class);
        context.setMixInAnnotations(XingConnections.class, XingConnectionsMixin.class);

    }

}
